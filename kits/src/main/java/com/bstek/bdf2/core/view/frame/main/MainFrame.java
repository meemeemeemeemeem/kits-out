package com.bstek.bdf2.core.view.frame.main;

import com.bstek.bdf2.core.CoreHibernateDao;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.exception.NoneLoginException;
import com.bstek.bdf2.core.model.Url;
import com.bstek.bdf2.core.security.SecurityUtils;
import com.bstek.bdf2.core.security.UserAuthentication;
import com.bstek.dorado.annotation.DataProvider;
import com.kits.core.redis.RedisClientTemplate;
import com.kits.core.utils.SerializeUtil;
import com.kits.util.XytContextHolder;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.AccessDeniedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @since 2013-2-1
 * @author Jacky.gao
 */
public class MainFrame extends CoreHibernateDao implements InitializingBean{
	public static final String BEAN_ID="bdf2.mainFrame";
	public static final String URL_FOR_NAVI_CACHE_KEY="url_for_navi_cache_key_";
	
	private ApplicationCache applicationCache;
	
	@Autowired
	private RedisClientTemplate redisClientTemplate;
	
	@DataProvider
	@SuppressWarnings("unchecked")
	public Collection<Url> loadMeunUrls(String parentId) {
		IUser user = ContextHolder.getLoginUser();
		if (user == null) {
			throw new NoneLoginException("Please login first");
		}
		String companyId=user.getCompanyId();
		if(StringUtils.isNotEmpty(getFixedCompanyId())){
			companyId=getFixedCompanyId();
		}
		
		//修改为redis缓存
		String key = URL_FOR_NAVI_CACHE_KEY+companyId;
		Collection<Url> cacheUrls = new ArrayList<Url>();
		
		// 如果宕机，直接取数据库数据
		if(redisClientTemplate.isConn()){
			
			//由于url对象以二进制存储，且对应的key也为二进制，及此处判断key需特殊转换
			if(redisClientTemplate.exists(SerializeUtil.serialize(key))){
				cacheUrls = (Collection<Url>) redisClientTemplate.getEntity(key);
			}
			
			if(cacheUrls.size()==0 || !redisClientTemplate.exists(SerializeUtil.serialize(key))){
				this.cacheNavigatorUrls();
				cacheUrls=(Collection<Url>)this.redisClientTemplate.getEntity(key);
			}
		}else{
			cacheUrls = this.loadUrls(null, this.getSessionFactory().openSession());
		}

		Collection<Url> urls = getCacheUrls(cacheUrls,companyId,parentId);
		UserAuthentication authentication = new UserAuthentication(user);
		Collection<Url> result = new ArrayList<Url>();
		authorityCheck(urls,authentication,result);
		return result;
	}
	
	private void authorityCheck(Collection<Url> urls,UserAuthentication authentication,Collection<Url> result){
		for (Url url : urls) {
			String targetUrl = url.getUrl();
			List<Url> children=url.getChildren();
			int childrenCount = 0;
			if(children!=null){
				childrenCount=children.size();
			}
			if (childrenCount==0 && StringUtils.isEmpty(targetUrl)) {
				continue;
			}
			if(StringUtils.isEmpty(targetUrl)){
				targetUrl = url.getName();				
			}
			try {
				SecurityUtils.checkUrl(authentication, targetUrl);
				Url newUrl=buildNewUrl(url);
				result.add(newUrl);
				if(children!=null){
					List<Url> childrenUrls=new ArrayList<Url>();
					newUrl.setChildren(childrenUrls);
					authorityCheck(children,authentication,childrenUrls);				
				}
			} catch (AccessDeniedException ex) {}
		}
	}
	
	@DataProvider
	public Collection<Url> loadContainChildMeunUrls(String parentId) {
		Collection<Url> result = this.loadMeunUrls(parentId);
		this.loadContainChildMeunUrls(result, parentId);
		return result;
	}

	private void loadContainChildMeunUrls(Collection<Url> result, String parentId) {
		for (Url url : result) {
			List<Url> childList = new ArrayList<Url>();
			childList.addAll(this.loadMeunUrls(url.getId()));
			url.setChildren(childList);
			this.loadContainChildMeunUrls(childList, url.getId());
		}
	}

	public ApplicationCache getApplicationCache() {
		return applicationCache;
	}

	public void setApplicationCache(ApplicationCache applicationCache) {
		this.applicationCache = applicationCache;
	}

	private List<Url> getCacheUrls(Collection<Url> urls,String companyId,String parentId){
		List<Url> resultUrls=new ArrayList<Url>();
		this.buildCacheUrls(urls,resultUrls,companyId, parentId);
		return resultUrls;
	}	
	
	private void buildCacheUrls(Collection<Url> urls,List<Url> resultUrls,String companyId,String parentId){
		for(Url url:urls){
			if(StringUtils.isEmpty(parentId)){
				if(StringUtils.isEmpty(url.getParentId()) && url.getCompanyId()!=null && url.getCompanyId().equals(companyId)){
					resultUrls.add(url);
				}
			}else{
				if(StringUtils.isNotEmpty(url.getParentId()) && url.getParentId().equals(parentId)){
					resultUrls.add(url);
				}
			}
			if(url.getChildren()!=null){
				this.buildCacheUrls(url.getChildren(), resultUrls, companyId, parentId);
			}
		}
	}
	
	public void afterPropertiesSet() throws Exception {
		//修改原来框架对于菜单的缓存机制
//		cacheNavigatorUrls();
	}
	
	public void cacheNavigatorUrls(){
		Session session=this.getSessionFactory().openSession();
		String companyId = XytContextHolder.getLoginUser().getCompanyId();
		try{
			List<Url> urls = this.loadUrls(null,session);
			redisClientTemplate.setEntity(URL_FOR_NAVI_CACHE_KEY+companyId, urls);

		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<Url> loadUrls(String parentId,Session session){
		String companyId = XytContextHolder.getLoginUser().getCompanyId();
		String hql="from "+Url.class.getName()+" u where u.forNavigation=:forNavigation and u.companyId=:companyId ";
		List<Url> urls = null;
		if (StringUtils.isNotEmpty(parentId)) {
			hql += " and u.parentId = :parentId order by u.order asc";
			urls = session.createQuery(hql).setBoolean("forNavigation", true).setString("parentId", parentId).setString("companyId", companyId).list();
		} else {
			//只缓存当前登录公司的URL
			hql += " and u.parentId is null order by u.order asc";
			urls = session.createQuery(hql).setBoolean("forNavigation", true).setString("companyId", companyId).list();
		}
		for(Url url:urls){
			url.setChildren(this.loadUrls(url.getId(),session));
		}
		return urls;
	}
	
	private Url buildNewUrl(Url oldUrl){
		Url url=new Url();
		url.setId(oldUrl.getId());
		url.setName(oldUrl.getName());
		url.setDesc(oldUrl.getDesc());
		url.setUrl(oldUrl.getUrl());
		url.setIcon(oldUrl.getIcon());
		url.setParentId(oldUrl.getParentId());
		url.setCompanyId(oldUrl.getCompanyId());
		return url;
	}
}

class UrlRowMapper implements RowMapper<Url> {
	public Url mapRow(ResultSet rs, int rowNum) throws SQLException {
		Url url = new Url();
		url.setId(rs.getString("ID_"));
		url.setName(rs.getString("NAME_"));
		url.setDesc(rs.getString("DESC_"));
		url.setUrl(rs.getString("URL_"));
		url.setIcon(rs.getString("ICON_"));
		url.setParentId(rs.getString("PARENT_ID_"));
		url.setCompanyId(rs.getString("COMPANY_ID_"));
		return url;
	}
}
