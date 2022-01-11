package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbbs021;
import com.kits.inms.bs.domain.Tbbs022;
import com.kits.inms.bs.domain.Tbbs023;
import com.kits.inms.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Controller
public class Bsjc021BO extends HibernateDao {

	/**
	 * 查询品名信息
	 * 
	 * @param page
	 * @param pid
	 */
	@DataProvider
	public void queryBs021(Page<Tbbs021> page, String pid) {

		String sql = "";
		if (AppUtils.isNotEmpty(pid)) {
			sql = " from Tbbs021 where pid ='" + pid + "'";
		} else {
			sql = "  from Tbbs021 where pid is null";
		}

		sql += " and compId='" + AppUtils.getLoginUser().getCompanyId()
				+ "' order by createDate asc,updDate desc";
		@SuppressWarnings("unchecked")
		List<Tbbs021> dataList = (List<Tbbs021>) this.query(sql, null,
				page.getPageNo(), page.getPageSize());

		page.setEntities(dataList);
	}
	
	//查询产品大类信息
	@DataProvider
	public void queryBs0211(Page<Tbbs021> page, Map<String, Object> map)
			throws Exception {
		String hql= " from Tbbs021 where pid5 ='"+map.get("pid5")+"' ";
		
		List<Tbbs021> dataList = (List<Tbbs021>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);		
	}
	
	
	
	
	/**
	 * 查询材质尺寸信息
	 * 
	 * @param page
	 * @param map
	 */
	@DataProvider
	public void queryBs022(Page<Tbbs022> page, Map<String, Object> map) {

		String prodeNo = (String) map.get("prodeNo");
		String typ = (String) map.get("typ");// 01 尺寸 02 材质

		String hql = "from Tbbs022 where pid='" + prodeNo + "' and typ='" + typ
				+ "' and compId='" + AppUtils.getLoginUser().getCompanyId()
				+ "'";

		@SuppressWarnings("unchecked")
		List<Tbbs022> dataList = (List<Tbbs022>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);
	}

	/**
	 * 查询质量信息
	 * 
	 * @param page
	 * @param map
	 */
	@DataProvider
	public void queryBs023(Page<Tbbs023> page, Map<String, Object> map) {

		String prodeNo = (String) map.get("prodeNo");

		String hql = "from Tbbs023 where pid='" + prodeNo + "'"
				+ " and compId='" + AppUtils.getLoginUser().getCompanyId()
				+ "'";

		@SuppressWarnings("unchecked")
		List<Tbbs023> dataList = (List<Tbbs023>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);
	}

	/**
	 * 维护品名信息
	 * 
	 * @param dataList
	 */
	@Transactional
	@DataResolver
	public String saveBs021(Collection<Tbbs021> dataList) {
		
		try {
			for (Tbbs021 ch01 : dataList) {
				EntityState state = EntityUtils.getState(ch01);
				if (state.equals(EntityState.NEW)) {

					ch01.setPkBs021(AppUtils.getUUIDKey());
					ch01.setCompId(AppUtils.getLoginUser().getCompanyId());
					if (!AppUtils.isNotEmpty(ch01.getProdeDesc())) {
						ch01.setProdeDesc(ch01.getProdeNo() + " "
								+ ch01.getProdeName());
					}

					ch01.setCreateDate(new Date());
					ch01.setCreateEmp(AppUtils.getLoginUserName());

					this.getSession().save(ch01);
				} else if (state.equals(EntityState.MODIFIED)) {
					ch01.setProdeDesc(ch01.getProdeNo() + " "
							+ ch01.getProdeName());
					ch01.setUpdDate(new Date());
					ch01.setUpdEmp(AppUtils.getLoginUserName());
					this.getSession().update(ch01);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		
		return null;
	}
	
	/**
	 * 维护产品大类信息
	 */
	@Transactional
	@DataResolver
	public String saveBs0211(Collection<Tbbs021> dataList) {
		
		try {
			for (Tbbs021 ch01 : dataList) {
				EntityState state = EntityUtils.getState(ch01);
				if (state.equals(EntityState.NEW)) {

					ch01.setPkBs021(AppUtils.getUUIDKey());
					ch01.setCompId(AppUtils.getLoginUser().getCompanyId());
					ch01.setCreateDate(new Date());
					ch01.setCreateEmp(AppUtils.getLoginUserName());

					this.getSession().save(ch01);
				} else if (state.equals(EntityState.MODIFIED)) {
					ch01.setUpdDate(new Date());
					ch01.setUpdEmp(AppUtils.getLoginUserName());
					this.getSession().update(ch01);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		
		return null;
	}

	@Transactional
	@DataResolver
	public String delBs0211(Collection<Tbbs021> dataList) {
		
		try {
			for (Tbbs021 ch01 : dataList) {
				EntityState state = EntityUtils.getState(ch01);
				
				if (state.equals(EntityState.DELETED)) {
					String pid5 = ch01.getPid5();
					String sql1 = "delete from Tbbs021 where PID5_ = '" + pid5 + "' ";
					this.getSession().createSQLQuery(sql1).executeUpdate();
					this.getSession().delete(ch01);
				} 
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		
		return null;
	}
	

	/**
	 * 维护尺寸 材质信息
	 * 
	 * @param dataList
	 */
	@Transactional
	@DataResolver
	public String saveBs022(Collection<Tbbs022> dataList) {
		try {
			for (Tbbs022 ch01 : dataList) {
				EntityState state = EntityUtils.getState(ch01);
				if (state.equals(EntityState.NEW)) {
					ch01.setPkBs022(AppUtils.getUUIDKey());
					ch01.setProdeNo(ch01.getPkBs022());
					ch01.setCompId(AppUtils.getLoginUser().getCompanyId());

					ch01.setCreateDate(new Date());
					ch01.setCreateEmp(AppUtils.getLoginUserName());
					this.getSession().save(ch01);
				} else if (state.equals(EntityState.MODIFIED)) {
					ch01.setUpdDate(new Date());
					ch01.setUpdEmp(AppUtils.getLoginUserName());
					this.getSession().update(ch01);
				} else if (state.equals(EntityState.DELETED)) {
					// 删除子节点
					String typ = ch01.getTyp();
					if (typ.equals("02")) {
						String sql = "delete from Tbbs023 where pid_='"
								+ ch01.getProdeNo() + "' and comp_id_='"
								+ AppUtils.getLoginUser().getCompanyId() + "'";

						this.getSession().createSQLQuery(sql).executeUpdate();
					}
					this.getSession().delete(ch01);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		return null;
	}

	/**
	 * 维护质量信息
	 * 
	 * @param dataList
	 */
	@Transactional
	@DataResolver
	public String  saveBs023(Collection<Tbbs023> dataList) {

		try {
			for (Tbbs023 ch01 : dataList) {
				EntityState state = EntityUtils.getState(ch01);
				if (state.equals(EntityState.NEW)) {
					ch01.setPkBs023(AppUtils.getUUIDKey());
					String prodeNo = ch01.getPkBs023();
					ch01.setProdeNo(prodeNo);
					ch01.setCompId(AppUtils.getLoginUser().getCompanyId());
					ch01.setCreateDate(new Date());
					ch01.setCreateEmp(AppUtils.getLoginUserName());

					this.getSession().save(ch01);
				} else if (state.equals(EntityState.MODIFIED)) {
					ch01.setUpdDate(new Date());
					ch01.setUpdEmp(AppUtils.getLoginUserName());
					this.getSession().update(ch01);
				} else if (state.equals(EntityState.DELETED)) {
					// 删除子节点
					this.getSession().delete(ch01);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		
		return null;
	}

	/**
	 * 删除树节点及附属资料
	 * @param map
	 * @return
	 */
	@Transactional
	@Expose
	public boolean delNodes(Map<String, Object> map) {
		
		try {
			String prodeNo = (String) map.get("prodeNo");
			String sql = "delete from Tbbs021 where prode_no_='" + prodeNo
					+ "' and comp_id_='" + AppUtils.getLoginUser().getCompanyId()
					+ "'";
			this.getSession().createSQLQuery(sql).executeUpdate();

			String hql = "from Tbbs021 where pid='" + prodeNo + "' and compId='"
					+ AppUtils.getLoginUser().getCompanyId() + "'";
			List<Tbbs021> list = this.query(hql);

			if (list.isEmpty()) {
				return false;
			}
			for (Tbbs021 data : list) {
				this.getSession().delete(data);
				String hql1 = "from Tbbs022 where pid='" + data.getProdeNo()
						+ "' and compId='" + AppUtils.getLoginUser().getCompanyId()
						+ "'";
				List<Tbbs022> list1 = this.query(hql1);
				if (!list1.isEmpty()) {
					for (Tbbs022 data1 : list1) {
						this.getSession().delete(data1);
						if (data1.getTyp().equals("02")) {
							String hql2 = "from Tbbs023 where pid='"
									+ data1.getProdeNo() + "' and compId='"
									+ AppUtils.getLoginUser().getCompanyId() + "'";

							List<Tbbs023> list2 = this.query(hql2);
							if (!list2.isEmpty()) {
								for (Tbbs023 data2 : list2) {
									this.getSession().delete(data2);
								}
							}
						}
					}
				}
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("prodeNo", data.getProdeNo());
				this.delNodes(map1);
			}
			return true;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}
	
	
	/**
	 * 删除树当前节点中被勾选的子节点
	 * @param map
	 * @return
	 */
	@Transactional
	@Expose
	public void delNodesB(List<Map<String, Object>> mapList) {
		
		try {
			List<Map<String, Object>> mapBList = new ArrayList<>();
			for (Map<String, Object> mapA : mapList) {
				String prodeNo = (String) mapA.get("prodeNo");
				String sql = "delete from Tbbs021 where prode_no_='" + prodeNo + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();
				String hql = "from Tbbs021 where pid='" + prodeNo + "'";
				List<Tbbs021> list = this.query(hql);
				if (list.isEmpty()) {
					continue;
				}
				for (Tbbs021 tbbs021 : list) {
					Map<String, Object> mapB = new HashMap<>();
					mapB.put("prodeNo", tbbs021.getProdeNo());
					mapBList.add(mapB);
				}
			}
			if (mapBList.size() > 0) {
				this.delNodesB(mapBList);
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/**
	 * 获取品名代码
	 * @param map
	 * @return
	 */
	@Expose
	public boolean getProdeNo(Map<String, Object> map) {

		String prodeNo = (String) map.get("prodeNo");
		String sql = "select prode_no_ from Tbbs021 where comp_id_='"
				+ AppUtils.getLoginUser().getCompanyId() + "' and prode_no_='"
				+ prodeNo + "'";

		String prodeNo1 = (String) this.getSession().createSQLQuery(sql)
				.uniqueResult();

		if (AppUtils.isNotEmpty(prodeNo1)) {
			return false;
		} else {
			return true;
		}
	}
}
