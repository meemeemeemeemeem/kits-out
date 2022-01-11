package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbdm12;
import com.kits.inms.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

/**
 * TBDm12的数据维护类
 * 
 * @author Administrator
 */
@Controller
public class Bsjc04BO extends HibernateDao {

	/**
	 * 查询储位信息
	 * 
	 * @param page
	 * @param map
	 */
	@DataProvider
	public void queryDm12(Page<Tbdm12> page, Map<String, Object> map) {

		String hql = " from Tbdm12 where 1=1 ";
		if (map != null) {
			// 设置参数

			//仓库代码
			String stockId = (String) map.get("stockId");
			if (StringUtils.isNotEmpty(stockId)) {

				hql += " and stockId = '" + stockId + "'";
			}

			//储位代码
			String locNo = (String) map.get("locNo");
			if (StringUtils.isNotEmpty(locNo)) {
				hql += " and locNo = '" + locNo + "'";
			}
		}

		hql += " order by locNo,locName asc";
		@SuppressWarnings("unchecked")
		List<Tbdm12> dataList = (List<Tbdm12>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}
	
	@DataProvider
	public List<Tbdm12> getDm12(String stockId) {

		String hql = " from Tbdm12 where 1=1 ";
		if (AppUtils.isNotEmpty(stockId)) {

				hql += " and stockId = '" + stockId + "'";
			}

		hql += " order by LOC_NAME_ desc ";
		List<Tbdm12> dataList = this.query(hql);
		
		List<Tbdm12> list1 = new ArrayList<>();
		for(Tbdm12 data:dataList){
			String locName = data.getLocName();
			String layer = data.getLoc1f();
			
			StringBuffer sb = new StringBuffer(locName);
			if(AppUtils.isNotEmpty(layer)){
				sb.append("-"+layer);
			}
			Tbdm12 dm12 = new Tbdm12();
			dm12.setLocName(sb.toString());
			list1.add(dm12);
		}
		return list1;
	}


	/**
	 * 维护储位信息
	 * 
	 * @param dataList
	 */
	@Transactional
	@DataResolver
	public String saveDm12(Collection<Tbdm12> dataList) {
		
		try {

			for (Tbdm12 dm11 : dataList) {

				EntityState state = EntityUtils.getState(dm11);
				if (state == EntityState.NEW) {
					// 设置保存的时间 用户
					dm11.setPkDm12(AppUtils.getUUIDKey());
					dm11.setCompId(AppUtils.getLoginUser().getCompanyId());
					dm11.setCreateUser(AppUtils.getLoginUserName());
					dm11.setCreateDate(new Date());
					// 保存
					this.getSession().save(dm11);

				} else if (state == EntityState.DELETED) {
					// 删除
					this.getSession().delete(dm11);

				} else if (state == EntityState.MODIFIED) {
					// 修改
					// 设置修改时间和修改用户
					dm11.setModifyDate(new Date());
					dm11.setModifyUser(AppUtils.getLoginUserName());
					this.getSession().update(dm11);
				}
			}
		} catch (Exception e) {
			
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		
		return null;
	}
}
