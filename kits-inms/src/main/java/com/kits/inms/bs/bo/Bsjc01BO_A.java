package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.dao.NewNoDao;
import com.kits.inms.bs.domain.*;
import com.kits.inms.utils.AppUtils;
import com.kits.util.UserUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Bsjc01BO_A extends HibernateDao {

	@Autowired
	private NewNoDao dao;

	@DataProvider
	@SuppressWarnings("unchecked")
	public Map<String, String> getArea() {
		String sql = "SELECT * FROM TBAREA where area_id_ like '%0000000000'";

		List<Object> list = this.getSession().createSQLQuery(sql).list();
		Map<String, String> mapValue = new HashMap<String, String>();
		for (Object o : list) {
			Object[] obj = (Object[]) o;

			String key = (String) obj[0];
			String value = (String) obj[1];

			mapValue.put(key, value);
		}

		return mapValue;
	}

	@DataProvider
	public Tbcm011 searchTbcm011(Map<String, Object> map) throws Exception {
		String hql = " from Tbcm011 where 1=1 and defs02 = 'Y'";
		List<Tbcm011> list = this.query(hql);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 模糊查询客商资料
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 */
	@DataProvider
	public void getCustNo(Page<Tbcm011> page, Map<String, Object> map)
			throws Exception {
		String hql = " from Tbcm011 where 1=1";

		if (map != null) {
			String custNo = (String) map.get("custNo");
			String custName = (String) map.get("custName");

			String createDate = map.get("createDate") == null ? null
					: new SimpleDateFormat("yyyy-MM-dd").format(map
							.get("createDate"));

			// 客商类别
			String custCategery = (String) map.get("custCategery");
			// 公司所在地区
			String compArea = (String) map.get("email");

			if (StringUtils.isNotEmpty(createDate)) {
				hql += " and to_char(createDate,'yyyy-MM-dd') ='" + createDate
						+ "'";
			}

			if (custName != null && !custName.equals("")) {
				hql += " and custName like '%" + custName + "%'";
			}

			if (custCategery != null && !custCategery.equals("")) {
				hql += " and custCategery = '" + custCategery + "'";
			}

			if (compArea != null && !compArea.equals("")) {
				hql += " and email like '%" + compArea + "%'";
			}

			if (custNo != null && !custNo.equals("")) {
				hql += " and custNo like '%" + custNo + "%'";
			}
		}

		hql += " order by createDate desc ";

		@SuppressWarnings("unchecked")
		List<Tbcm011> dataList = (List<Tbcm011>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());

		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 查询客商 客商编号 客户简称 客商所在地区 客商类别
	 */
	@DataProvider
	public void getCust(Page<Tbcm011> page, Map<String, Object> map)
			throws Exception {
		String hql = " from Tbcm011 where 1=1 ";

		if (map != null) {
			String custNo = (String) map.get("custNo");
			String custName = (String) map.get("custName");

			// 客商类别
			@SuppressWarnings("unchecked")
			List<String> custCategery = (List<String>) map.get("custCategery");

			if (custCategery != null) {
				for (int i = 0; i < custCategery.size(); i++) {
					if (i == 0) {
						hql += " and ( custCategery like '%"
								+ custCategery.get(i) + "%'";
					} else {
						hql += " or custCategery like '%" + custCategery.get(i)
								+ "%'";

					}

				}

			}

			// 公司所在地区
			String compArea = (String) map.get("custArea");
			if (custCategery != null && custCategery.size() > 0) {
				hql += ")";
			}
			if (custNo != null && !custNo.equals("")) {
				hql += " and custNo like '%" + custNo + "%'";
			}

			if (custName != null && !custName.equals("")) {
				hql += " and custName like '%" + custName + "%'";
			}

			if (compArea != null && !compArea.equals("")) {
				hql += " and email = '" + compArea + "'";
			}

		}

		hql += " and (defs01 is null or defs01<>'del') order by custNo ";

		@SuppressWarnings("unchecked")
		List<Tbcm011> dataList = (List<Tbcm011>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 查询客户银行表中的数据
	 * 
	 * @param page
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void searchTbcm012(Page<Tbcm012> page, Map<String, Object> map) {
		String hql = " from Tbcm012 where 1=1 ";

		if (map != null) {
			String custNo = (String) map.get("custNo");

			if (custNo != null && !custNo.equals("")) {
				hql += "and custNo = '" + custNo + "'";
			}
		}

		hql += " order by defs01, createDate desc";
		List<Tbcm012> tbcm012 = (List<Tbcm012>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(tbcm012);
		page.setEntityCount(this.query(hql).size());

	}

	/**
	 * 查询开票表中的数据
	 * 
	 * @param page
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void searchTbbs012(Page<Tbbs012> page, Map<String, Object> map) {
		String hql = " from Tbbs012 where 1=1 ";

		if (map != null) {

			String custNo = (String) map.get("custNo");

			if (custNo != null && !custNo.equals("")) {
				hql += "and custNo = '" + custNo + "'";
			}
		}
		hql += " order by memo,createDate desc";
		List<Tbbs012> tbcm012 = (List<Tbbs012>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(tbcm012);
		page.setEntityCount(this.query(hql).size());

	}

	/**
	 * 查询收货表中的数据
	 * 
	 * @param page
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void searchTbbs013(Page<Tbbs013> page, Map<String, Object> map) {

		String hql = " from Tbbs013 where 1=1 ";
		if (map != null) {

			String custNo = (String) map.get("custNo");

			if (custNo != null && !custNo.equals("")) {
				hql += "and custNo = '" + custNo + "'";
			}
		}

		hql += "and compId='" + UserUtil.getLoginCompanyId()
				+ "' order by memo, createDate desc";
		List<Tbbs013> tbcm012 = (List<Tbbs013>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(tbcm012);
		page.setEntityCount(this.query(hql).size());

	}

	/**
	 * 查询联系人表中的数据
	 * 
	 * @param page
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void searchTbbs015(Page<Tbbs015> page, Map<String, Object> map) {

		String hql = " from Tbbs015 where 1=1 ";

		if (map != null) {

			String custNo = (String) map.get("custNo");

			if (custNo != null && !custNo.equals("")) {
				hql += "and custNo = '" + custNo + "'";
			}
		}

		hql += "and compId='" + UserUtil.getLoginCompanyId()
				+ "' order by memo, createDate desc";
		List<Tbbs015> tbcm012 = (List<Tbbs015>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(tbcm012);
		page.setEntityCount(this.query(hql).size());

	}

	/**
	 * 查询工商信息表中的数据
	 * 
	 * @param map
	 */
	@DataProvider
	public Tbbs016 searchTbbs016(Map<String, Object> map) {
		String hql = " from Tbbs016 where 1=1 ";

		if (map != null) {

			String custNo = (String) map.get("custNo");

			if (custNo != null && !custNo.equals("")) {
				hql += "and custNo = '" + custNo + "'";
			}
		}

		hql += "and compId='" + UserUtil.getLoginCompanyId() + "'";

		List<Tbbs016> dataList = this.query(hql);
		if (dataList.isEmpty()) {
			return null;

		} else {
			return dataList.get(0);
		}

	}

	/**
	 * 新增、修改、删除Tbbs016表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 */
	@DataResolver
	@Transactional
	public String saveTbbs016(Tbbs016 tbcm011) {
		try {
			EntityState entityState = EntityUtils.getState(tbcm011); // 抓取当前行状态
			if (entityState.equals(EntityState.NEW)) { // 新增

				tbcm011.setCreateDate(new Date());
				tbcm011.setCreateEmp(UserUtil.getLoginUserName());

				tbcm011.setPkBs016(AppUtils.getUUIDKey());
				tbcm011.setCompId(UserUtil.getLoginCompanyId());

				this.getSession().save(tbcm011);
			} else if (entityState.equals(EntityState.DELETED)) { // 删除

				this.getSession().delete(tbcm011);

			} else if (entityState.equals(EntityState.MODIFIED)) { // 修改

				tbcm011.setModifyDate(new Date());// 更新修改时间
				tbcm011.setModifyEmp(UserUtil.getLoginUserName());// 更新修改人

				this.getSession().update(tbcm011);
			}

			return tbcm011.getCustNo();

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			return "操作出错：" + e.getMessage();
		}

	}

	/**
	 * 新增、修改、删除Tbcm011表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 *             zjw-2017-11-28 修改内容：修改时间、修改人员字段在前台赋值 zjw-2017-12-28
	 */
	@DataResolver
	@Transactional
	public String saveTbcm011(Tbcm011 tbcm011) {
		try {
			EntityState entityState = EntityUtils.getState(tbcm011); // 抓取当前行状态
			if (entityState.equals(EntityState.NEW)) { // 新增

				tbcm011.setCreateDate(new Date());
				tbcm011.setCreateEmp(UserUtil.getLoginUserName());
				tbcm011.setPkCm011(AppUtils.getUUIDKey());
				tbcm011.setCompId(UserUtil.getLoginCompanyId());
				if (tbcm011.getCustNo().isEmpty()) {
					String compId = UserUtil.getLoginCompanyId(); // 公司别
					String noId = "TBCM011"; // 单号代码
					String ruleString = "c1#s5"; // 规则字串
					String ruleConstant = "9"; // 字串常数
					dao.ruleNoDef(compId, noId, ruleString, ruleConstant);
					tbcm011.setCustNo(dao.getNewNo(noId));
				}
				tbcm011.setDefs01("new");
				tbcm011.setDefs02("Y");
				this.getSession().save(tbcm011);
			} else if (entityState.equals(EntityState.DELETED)) { // 删除

				// 删除项次档
				String custNo = tbcm011.getCustNo();

				// 删除银行资料
				String sql1 = "delete from Tbcm012 where comp_id_ = '"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNo + "'";

				this.getSession().createSQLQuery(sql1).executeUpdate();
				// 删除开票资料
				String sql2 = "delete from Tbbs012 where comp_id_ = '"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNo + "'";

				this.getSession().createSQLQuery(sql2).executeUpdate();

				// 删除收货资料
				String sql3 = "delete from Tbbs013 where comp_id_ = '"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNo + "'";

				this.getSession().createSQLQuery(sql3).executeUpdate();

				// 删除联系人资料
				String sql4 = "delete from Tbbs015 where comp_id_ = '"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNo + "'";

				this.getSession().createSQLQuery(sql4).executeUpdate();

				// 删除工商信息资料
				String sql5 = "delete from Tbbs016 where comp_id_ = '"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNo + "'";

				this.getSession().createSQLQuery(sql5).executeUpdate();

				this.getSession().delete(tbcm011);

			} else if (entityState.equals(EntityState.MODIFIED)) { // 修改

				tbcm011.setUpdDate(new Date());// 更新修改时间
				tbcm011.setUpdEmp(UserUtil.getLoginUserName());// 更新修改人

				String oldCustNo = EntityUtils.getOldString(tbcm011, "custNo");
				String newCustNo = tbcm011.getCustNo();
				if (!oldCustNo.equals(newCustNo)) {
					String sql1 = "update Tbcm012 set cust_no_='" + newCustNo
							+ "' where cust_no_='" + oldCustNo
							+ "' and comp_id_='"
							+ UserUtil.getLoginCompanyId() + "'";
					this.getSession().createSQLQuery(sql1).executeUpdate();
					
					String sql2 = "update Tbbs012 set cust_no_='" + newCustNo
							+ "' where cust_no_='" + oldCustNo
							+ "' and comp_id_='"
							+ UserUtil.getLoginCompanyId() + "'";
					this.getSession().createSQLQuery(sql2).executeUpdate();
					
					String sql3 = "update Tbbs013 set cust_no_='" + newCustNo
							+ "' where cust_no_='" + oldCustNo
							+ "' and comp_id_='"
							+ UserUtil.getLoginCompanyId() + "'";
					this.getSession().createSQLQuery(sql3).executeUpdate();
					
					String sql4 = "update Tbbs015 set cust_no_='" + newCustNo
							+ "' where cust_no_='" + oldCustNo
							+ "' and comp_id_='"
							+ UserUtil.getLoginCompanyId() + "'";
					this.getSession().createSQLQuery(sql4).executeUpdate();
					
					String sql5 = "update Tbbs016 set cust_no_='" + newCustNo
							+ "' where cust_no_='" + oldCustNo
							+ "' and comp_id_='"
							+ UserUtil.getLoginCompanyId() + "'";
					this.getSession().createSQLQuery(sql5).executeUpdate();
					
				}

				this.getSession().update(tbcm011);
			}
			return tbcm011.getCustNo();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			return null;
		}

	}

	/**
	 * 新增、修改、删除客户银行表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 *             zjw-2017-11-28 修改内容：修改时间、修改人员字段在前台赋值 zjw-2017-12-28
	 */
	@DataResolver
	@Transactional
	public void saveTbcm012(List<Tbcm012> dataList) {
		try {
			boolean flag = true;
			for (Tbcm012 data : dataList) {
				if (AppUtils.isNotEmpty(data.getDefs01())) {
					flag = false;
					continue;
				}
			}
			if (flag == true) {
				dataList.get(0).setDefs01("OK");
			}

			for (Tbcm012 tbcm012 : dataList) {
				EntityState entityState = EntityUtils.getState(tbcm012); // 抓取当前行状态
				if (entityState.equals(EntityState.NEW)) { // 新增

					tbcm012.setPkCm012(AppUtils.getUUIDKey());
					tbcm012.setCompId(UserUtil.getLoginCompanyId());
					tbcm012.setCreateEmp(UserUtil.getLoginUserName());
					tbcm012.setCreateDate(new Date());

					this.getSession().save(tbcm012);

				} else if (entityState.equals(EntityState.DELETED)) {
					// 删除
					this.getSession().delete(tbcm012);

				} else if (entityState.equals(EntityState.MODIFIED)) {
					// 修改
					tbcm012.setUpdEmp(UserUtil.getLoginUserName());
					tbcm012.setUpdDate(new Date());

					this.getSession().update(tbcm012);
				}
			}
		} catch (Exception e) {

			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
		}
	}

	/**
	 * 开票
	 * 
	 * @param collection
	 */
	@DataResolver
	@Transactional
	public void saveTbBs012(List<Tbbs012> dataList) {

		try {
			boolean flag = true;
			for (Tbbs012 data : dataList) {
				if (AppUtils.isNotEmpty(data.getMemo())) {
					flag = false;
					continue;
				}
			}

			if (flag == true) {
				dataList.get(0).setMemo("OK");
			}
			for (Tbbs012 tbcm012 : dataList) {
				EntityState entityState = EntityUtils.getState(tbcm012); // 抓取当前行状态
				if (entityState.equals(EntityState.NEW)) { // 新增

					tbcm012.setPkBs012(AppUtils.getUUIDKey());
					tbcm012.setCompId(UserUtil.getLoginCompanyId());
					tbcm012.setCreateEmp(UserUtil.getLoginUserName());
					tbcm012.setCreateDate(new Date());

					this.getSession().save(tbcm012);

				} else if (entityState.equals(EntityState.DELETED)) {
					// 删除
					this.getSession().delete(tbcm012);

				} else if (entityState.equals(EntityState.MODIFIED)) {
					// 修改
					tbcm012.setModifyEmp(UserUtil.getLoginUserName());
					tbcm012.setModifyDate(new Date());

					this.getSession().update(tbcm012);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
		}

	}

	/**
	 * 收货
	 * 
	 * @param collection
	 */
	@DataResolver
	@Transactional
	public void saveTbBs013(List<Tbbs013> dataList) {

		try {

			boolean flag = true;
			for (Tbbs013 data : dataList) {
				if (AppUtils.isNotEmpty(data.getMemo())) {
					flag = false;
					continue;
				}
			}

			if (flag == true) {
				dataList.get(0).setMemo("OK");
			}

			for (Tbbs013 tbcm012 : dataList) {
				EntityState entityState = EntityUtils.getState(tbcm012); // 抓取当前行状态
				if (entityState.equals(EntityState.NEW)) { // 新增

					tbcm012.setPkBs013(AppUtils.getUUIDKey());
					tbcm012.setCompId(UserUtil.getLoginCompanyId());
					tbcm012.setCreateEmp(UserUtil.getLoginUserName());
					tbcm012.setCreateDate(new Date());

					this.getSession().save(tbcm012);

				} else if (entityState.equals(EntityState.DELETED)) {
					// 删除
					this.getSession().delete(tbcm012);

				} else if (entityState.equals(EntityState.MODIFIED)) {
					// 修改
					tbcm012.setModifyEmp(UserUtil.getLoginUserName());
					tbcm012.setModifyDate(new Date());

					this.getSession().update(tbcm012);
				}
			}

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
		}

	}

	/**
	 * 联系人
	 * 
	 * @param collection
	 */
	@DataResolver
	@Transactional
	public void saveTbBs015(List<Tbbs015> dataList) {

		try {
			boolean flag = true;
			for (Tbbs015 data : dataList) {
				if (AppUtils.isNotEmpty(data.getMemo())) {
					flag = false;
					continue;
				}
			}
			if (flag == true) {
				dataList.get(0).setMemo("OK");
			}

			for (Tbbs015 tbcm012 : dataList) {
				EntityState entityState = EntityUtils.getState(tbcm012); // 抓取当前行状态
				if (entityState.equals(EntityState.NEW)) { // 新增

					tbcm012.setPkBs015(AppUtils.getUUIDKey());
					tbcm012.setCompId(UserUtil.getLoginCompanyId());
					tbcm012.setCreateEmp(UserUtil.getLoginUserName());
					tbcm012.setCreateDate(new Date());

					this.getSession().save(tbcm012);

				} else if (entityState.equals(EntityState.DELETED)) {
					// 删除
					this.getSession().delete(tbcm012);

				} else if (entityState.equals(EntityState.MODIFIED)) {
					// 修改
					tbcm012.setModifyEmp(UserUtil.getLoginUserName());
					tbcm012.setModifyDate(new Date());

					this.getSession().update(tbcm012);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
		}
	}

	@Transactional
	@Expose
	public String doDef1(String custNo, Tbcm012 data) {

		try {
			String sql1 = "select * from Tbcm012 where cust_no_='" + custNo
					+ "' and defs01_='OK' and comp_id_='"
					+ UserUtil.getLoginCompanyId() + "'";
			Tbcm012 cm012 = (Tbcm012) this.getSession().createSQLQuery(sql1)
					.addEntity(Tbcm012.class).uniqueResult();

			cm012.setDefs01(null);

			this.getSession().update(cm012);
			data.setDefs01("OK");

			this.getSession().update(data);

			return null;

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();

			return "操作出错：" + e.getMessage();
		}
	}

	@Transactional
	@Expose
	public String doDef2(String custNo, Tbbs012 data) {

		try {
			String sql1 = "select * from Tbbs012 where cust_no_='" + custNo
					+ "' and memo_='OK' and comp_id_='"
					+ UserUtil.getLoginCompanyId() + "'";
			Tbbs012 cm012 = (Tbbs012) this.getSession().createSQLQuery(sql1)
					.addEntity(Tbbs012.class).uniqueResult();

			cm012.setMemo(null);

			this.getSession().update(cm012);
			data.setMemo("OK");

			this.getSession().update(data);

			return null;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();

			return "操作出错：" + e.getMessage();
		}
	}

	@Transactional
	@Expose
	public String doDef3(String custNo, Tbbs013 data) {

		try {
			String sql1 = "select * from Tbbs013 where cust_no_='" + custNo
					+ "' and memo_='OK' and comp_id_='"
					+ UserUtil.getLoginCompanyId() + "'";
			Tbbs013 cm012 = (Tbbs013) this.getSession().createSQLQuery(sql1)
					.addEntity(Tbbs013.class).uniqueResult();

			cm012.setMemo(null);

			this.getSession().update(cm012);
			data.setMemo("OK");

			this.getSession().update(data);

			return null;

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();

			return "操作出错：" + e.getMessage();
		}
	}

	@Transactional
	@Expose
	public String doDef4(String custNo, Tbbs015 data) {

		try {

			String sql1 = "select * from Tbbs015 where cust_no_='" + custNo
					+ "' and memo_='OK' and comp_id_='"
					+ UserUtil.getLoginCompanyId() + "'";
			Tbbs015 cm012 = (Tbbs015) this.getSession().createSQLQuery(sql1)
					.addEntity(Tbbs015.class).uniqueResult();

			cm012.setMemo(null);

			this.getSession().update(cm012);
			data.setMemo("OK");

			this.getSession().update(data);

			return null;

		} catch (Exception e) {
			return "操作出错：" + e.getMessage();
		}
	}

	/**
	 * 验证custNo
	 */
	@Expose
	public boolean getCustNo(String custNo) {

		String sql = "select cust_no_ from Tbcm011 where cust_no_='" + custNo + "'";

		String cust = (String) this.getSession().createSQLQuery(sql)
				.uniqueResult();

		if (AppUtils.isNotEmpty(cust)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证tanNumber
	 */
	@Expose
	public boolean getTaxNumber(String taxNumber) {

		String sql = "select cust_no_ from Tbcm011 where tax_number_='" + taxNumber + "'";

		String cust = (String) this.getSession().createSQLQuery(sql)
				.uniqueResult();

		if (AppUtils.isNotEmpty(cust)) {
			return true;
		}
		return false;
	}

	@Expose
	@Transactional
	public String doSynch(String pk) {

		/*try {
			Tbcm011 data = (Tbcm011) this.getSession().load(Tbcm011.class, pk);

			String taxNumber = data.getTaxNumber();
			String custNoOld = data.getCustNo();
			//String custNoNew = callController.searchCustNo(taxNumber);
			if (AppUtils.isNotEmpty(custNoNew)) {
				// 失效
				data.setDefs01("del");
				this.getSession().update(data);

				data.setCustNo(custNoNew);
				data.setPkCm011(AppUtils.getUUIDKey());
				data.setCreateDate(new Date());
				data.setCreateEmp(AppUtils.getLoginUserName());
				this.getSession().save(data);

				String sql1 = "update Tbcm012 set cust_no_='" + custNoNew
						+ "' where comp_id_='"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNoOld + "'";

				this.getSession().createSQLQuery(sql1).executeUpdate();

				String sql2 = "update TbBs012 set cust_no_='" + custNoNew
						+ "' where comp_id_='"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNoOld + "'";

				this.getSession().createSQLQuery(sql2).executeUpdate();

				String sql3 = "update TbBs013 set cust_no_='" + custNoNew
						+ "' where comp_id_='"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNoOld + "'";

				this.getSession().createSQLQuery(sql3).executeUpdate();

				String sql4 = "update TbBs015 set cust_no_='" + custNoNew
						+ "' where comp_id_='"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNoOld + "'";

				this.getSession().createSQLQuery(sql4).executeUpdate();

				String sql5 = "update TbBs016 set cust_no_='" + custNoNew
						+ "' where comp_id_='"
						+ UserUtil.getLoginCompanyId()
						+ "' and cust_no_='" + custNoOld + "'";

				this.getSession().createSQLQuery(sql5).executeUpdate();

				this.getSession().flush();
			} else {
				throw new RuntimeException("未找到对应的客户编码，不能完成同步！");
			}
		} catch (Exception e) {

			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			return "操作出错：" + e.getMessage();
		}*/

		return null;
	}
	
	
	
	@Expose
	public Boolean getMyCustNo(){
		String hql = " from Tbcm011 where DEFS02_ = 'Y'";
		List<Tbcm011> query = this.query(hql);
		if (query == null||query.size()==0) {
			return true;
		}
		//String custNo = query.get(0).getCustNo();
		return false;
	}
	
	@Expose
	public String  getCompanyId(){
		String sql = " select company_id_ from Bdf2_User where 1=1 ";
		String companyId = (String) this.getSession().createSQLQuery(sql).uniqueResult();
		return companyId;
	}
	
}
