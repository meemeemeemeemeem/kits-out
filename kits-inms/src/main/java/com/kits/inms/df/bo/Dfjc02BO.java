package com.kits.inms.df.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.df.domain.Tbdf02;
import com.kits.inms.utils.AppUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Dfjc02BO extends HibernateDao {

	@DataProvider
	public void queryDf02(Page<Tbdf02> page,Map<String, Object> map){
		
		String hql = " from Tbdf02 where 1=1 ";
		if(map!=null){
			
			
			String refId = (String) map.get("refId");
			if(AppUtils.isNotEmpty(refId)){
				 hql+=" and refId='"+refId+"'";
			}
		}
		
		hql += " and type='A' order by valueA asc";	
		@SuppressWarnings("unchecked")
		List<Tbdf02> dataList = (List<Tbdf02>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		
		page.setEntities(dataList);
	}

	@DataResolver
	public void saveDf02(Collection<Tbdf02> dataList){
		Session session = getSession();
		for(Tbdf02 ch01:dataList){
			EntityState state = EntityUtils.getState(ch01);
			if(state.equals(EntityState.NEW)){
				
				ch01.setPkDf02(AppUtils.getUUIDKey());
				ch01.setCompId(AppUtils.getCompId());
				ch01.setType("A");
				ch01.setCreateDate(new Date());
				ch01.setCreateEmp(AppUtils.getLoginUserName());
				this.getSession().save(ch01);
				session.save(ch01);			
			}else if(state.equals(EntityState.MODIFIED)){
				ch01.setUpdDate(new Date());
				ch01.setUpdEmp(AppUtils.getLoginUserName());

				session.update(ch01);
			}else if(state.equals(EntityState.DELETED)){

				session.delete(ch01);
			}
		}
	}

	
}
