package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbdm11;
import com.kits.inms.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TBDm11的数据维护类
 * 
 * @author cheng
 * 
 */
@Controller
public class Bsjc03BO extends HibernateDao {
	/**
	 * 查询仓库信息
	 * 
	 * @param page
	 * @param map
	 */
	@DataProvider
	public void queryDm11(Page<Tbdm11> page, Map<String, Object> map) {

		String hql = "from Tbdm11 where 1=1 ";
		if (map != null) {
			// 设置参数
			// 仓库代码
			String stockId = (String) map.get("stockId");
			if (StringUtils.isNotEmpty(stockId)) {
				hql += " and stockId like '%" + stockId + "%'";
			}else {
				//采购入库仓库代码
				String stockName = (String) map.get("stockName");
				if (StringUtils.isNotEmpty(stockName)) {
					hql += " and stockId = '" + stockName + "'";
				}
			}
		}


		@SuppressWarnings("unchecked")
		List<Tbdm11> dataList = (List<Tbdm11>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}

	@DataProvider
	public List<Tbdm11> getDm11(Map<String, Object> map) {

		String hql = "from Tbdm11 where 1=1 ";


		List<Tbdm11> dataList = this.query(hql);
		return dataList;
	}

	/**
	 * 维护仓库信息
	 * 
	 * @param dataList
	 */
	@Transactional
	@DataResolver
	public String saveDm11(
			Collection<com.kits.inms.bs.domain.Tbdm11> dataList) {

		try {
			for (Tbdm11 dm11 : dataList) {

				EntityState state = EntityUtils.getState(dm11);
				if (state == EntityState.NEW) {
					// 保存
					dm11.setCreateUser(AppUtils.getLoginUserName());
					dm11.setPkDm11(AppUtils.getUUIDKey());
					dm11.setCompId(AppUtils.getLoginUser().getCompanyId());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					dm11.setCreateDate(sdf.format(new Date()));
					this.getSession().save(dm11);

				} else if (state == EntityState.DELETED) {
					// 删除
					this.getSession().delete(dm11);

					String sql = "delete from Tbdm12 where stock_id_ ='"
							+ dm11.getStockId() + "'";
					this.getSession().createSQLQuery(sql).executeUpdate();

				} else if (state == EntityState.MODIFIED) {

					// 修改
					// 设置修改日期 修改人
					dm11.setModifyDate(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date()));
					dm11.setModifyUser(AppUtils.getLoginUserName());
					this.getSession().update(dm11);
				}
			}

		} catch (Exception e) {

			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			return "操作出错：" + e.getMessage();
		}
		return null;
	}

	@Expose
	public boolean checkStockId(String parameter) {
		String hql = " from Tbdm11 where stockId='" + parameter
				+ "'";
		return this.query(hql).isEmpty();
	}
	
	/**
	 * 根据仓库查询对应的储区
	 * @param stockId
	 * @return
	 */
	
	@Expose
	public Map<String, Object> getLocationByStock(String stockId) {
		
		String sql = "select  LOC_NO_,LOC_NAME_ from Tbdm12 where "
				+ " STOCK_ID_ = '" + stockId + "' order by LOC_NO_, LOC_NAME_ ";
		
		List<Object> dataList = this.getSession().createSQLQuery(sql).list();
		
		Map<String, Object> map = new LinkedHashMap<>();
		for(Object o : dataList){
			
			Object[] obj = (Object[]) o;
			
			String locNo = (String) obj[0];
			String locName = (String) obj[1];
			
			String key = locNo+locName;
			String value = locNo+"-"+locName;
			
			map.put(key, value);
		}

		return map;
	}
}
