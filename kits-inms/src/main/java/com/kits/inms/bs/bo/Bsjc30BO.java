package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.dao.NewNoDao;
import com.kits.inms.bs.domain.Tbdf03;
import com.kits.inms.bs.domain.Tbdf04;
import com.kits.inms.bs.domain.Tbdf05;
import com.kits.inms.bs.domain.Tbdf06;
import com.kits.inms.utils.AppUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Controller
public class Bsjc30BO extends HibernateDao {
	@SuppressWarnings("unused")
	@Autowired
	private NewNoDao dao;
	// private NewNoDao dao = new NewNoDaoImp();

	/**
	 * 根据单号代码参数加载Tbdf03表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void loadTbdf03(Page<Tbdf03> page, Map<String, Object> map) throws Exception {
		String hql = " from Tbdf03 where 1=1 ";
		// if(!map.isEmpty()){
		if (map != null) {
			String compId = (String) map.get("compId") == null ? "" : (String) map.get("compId");
			String noId = (String) map.get("noId") == null ? "" : (String) map.get("noId");
			String noDesc = (String) map.get("noDesc") == null ? "" : (String) map.get("noDesc");
			if (StringUtils.isNotBlank(compId)) {
				hql += " and COMP_ID_ = '" + compId + "'";
			} else {
				hql += " and COMP_ID_ = '" + AppUtils.getLoginUser().getCompanyId() + "'";
			}
			if (StringUtils.isNotBlank(noId)) {
				hql += " and NO_ID_ = '" + noId + "'";
			}
			if (StringUtils.isNotBlank(noDesc)) {
				hql += " and NO_DESC_ = '" + noDesc + "'";
			}
		}

		hql += " order by MODIFY_DATE_ desc,CREATE_DATE_ desc";// 根据修改日期和新增日期排序(先后注意顺序)
		List<Tbdf03> list = (List<Tbdf03>) this.query(hql, null, page.getPageNo(), page.getPageSize());
		page.setEntities(list);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 根据公司别和单号代码参数加载Tbdf04表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void loadTbdf04(Page<Tbdf04> page, Map<String, Object> map) throws Exception {
		String hql = " from Tbdf04 where 1=1";
		if (!map.isEmpty()) {
			String compId = (String) map.get("compId") == null ? "" : (String) map.get("compId");
			String noId = (String) map.get("noId") == null ? "" : (String) map.get("noId");
			String ruleId = (String) map.get("ruleId") == null ? "" : (String) map.get("ruleId");
			if (StringUtils.isNotBlank(compId)) {
				hql += " and COMP_ID_ = '" + compId + "'";
			}
			if (StringUtils.isNotBlank(noId)) {
				hql += " and NO_ID_ = '" + noId + "'";
			}
			if (StringUtils.isNotBlank(ruleId)) {
				hql += " and RULE_ID_ = '" + ruleId + "'";
			}
		}

		hql += " order by CREATE_DATE_";
		List<Tbdf04> list = (List<Tbdf04>) this.query(hql, null, page.getPageNo(), page.getPageSize());
		page.setEntities(list);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 根据公司别和单号代码参数加载Tbdf05表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void loadTbdf05(Page<Tbdf05> page, Map<String, Object> map) throws Exception {
		String hql = " from Tbdf05 where 1=1";
		if (!map.isEmpty()) {
			String compId = (String) map.get("compId") == null ? "" : (String) map.get("compId");
			String noId = (String) map.get("noId") == null ? "" : (String) map.get("noId");
			String noStyle = (String) map.get("noStyle") == null ? "" : (String) map.get("noStyle");
			if (StringUtils.isNotBlank(compId)) {
				hql += " and COMP_ID_ = '" + compId + "'";
			}
			if (StringUtils.isNotBlank(noId)) {
				hql += " and NO_ID_ = '" + noId + "'";
			}
			if (StringUtils.isNotBlank(noStyle)) {
				hql += " and NO_STYLE_ = '" + noStyle + "'";
			}
		}

		hql += " order by CREATE_DATE_ desc";
		List<Tbdf05> list = (List<Tbdf05>) this.query(hql, null, page.getPageNo(), page.getPageSize());
		page.setEntities(list);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 保存数据到表Tbdf03
	 * 
	 * @param collection
	 * @throws Exception
	 */
	@DataResolver
	@Transactional
	public void saveTbdf03(Collection<Tbdf03> collection) throws Exception {
		Session session = this.getSession();
		for (Tbdf03 tbdf03 : collection) {
			EntityState entityState = EntityUtils.getState(tbdf03);
			/* 新增 */
			if (entityState.equals(EntityState.NEW)) {
				tbdf03.setCompId(AppUtils.getLoginUser().getCompanyId()); // 公司别
				tbdf03.setCreateEmpNo(AppUtils.getLoginUserName()); // 创建者
				tbdf03.setCreateDate(new Date()); // 创建时间
				tbdf03.setModifyEmpNo(null); // 修改者
				tbdf03.setModifyDate(null); // 修改时间

				session.save(tbdf03);
				/* 删除 */
			} else if (entityState.equals(EntityState.DELETED)) {
				session.delete(tbdf03);
				/* 修改 */
			} else if (entityState.equals(EntityState.MODIFIED)) {
				// EntityUtils.get

				tbdf03.setModifyEmpNo(AppUtils.getLoginUserName()); // 修改者
				tbdf03.setModifyDate(new Date()); // 修改时间

				session.update(tbdf03);
			}
		}
	}

	/**
	 * 保存数据到表Tbdf04
	 * 
	 * @param collection
	 * @throws Exception
	 */
	@DataResolver
	@Transactional
	public void saveTbdf04(Collection<Tbdf04> collection) throws Exception {
		Session session = this.getSession();
		for (Tbdf04 tbdf04 : collection) {
			EntityState entityState = EntityUtils.getState(tbdf04);
			/* 新增 */
			if (entityState.equals(EntityState.NEW)) {
				tbdf04.setCreateEmpNo(AppUtils.getLoginUserName()); // 创建者
				tbdf04.setCreateDate(new Date()); // 创建时间
				tbdf04.setModifyEmpNo(null); // 修改者
				tbdf04.setModifyDate(null); // 修改时间

				session.save(tbdf04);
				/* 删除 */
			} else if (entityState.equals(EntityState.DELETED)) {
				session.delete(tbdf04);
				/* 修改 */
			} else if (entityState.equals(EntityState.MODIFIED)) {
				tbdf04.setModifyEmpNo(AppUtils.getLoginUserName()); // 修改者
				tbdf04.setModifyDate(new Date()); // 修改时间

				session.update(tbdf04);
			}
		}
	}

	/**
	 * 保存数据到表Tbdf05
	 * 
	 * @param collection
	 * @throws Exception
	 */
	@DataResolver
	@Transactional
	public void saveTbdf05(Collection<Tbdf05> collection) throws Exception {
		Session session = this.getSession();
		// SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		for (Tbdf05 tbdf05 : collection) {
			EntityState entityState = EntityUtils.getState(tbdf05);
			/* 新增 */
			if (entityState.equals(EntityState.NEW)) {
				tbdf05.setCreateEmpNo(AppUtils.getLoginUserName()); // 创建者
				tbdf05.setCreateDate(new Date()); // 创建时间
				tbdf05.setModifyEmpNo(null); // 修改者
				tbdf05.setModifyDate(null); // 修改时间
				// tbdf05.setModifyDate(sdf.format(new Date()));

				session.save(tbdf05);

				// c:字串常数;p:变量;y:西洋年;m:月份;d:日;s:流水号
				// dao.ruleNoDef("xyt","SO01","c2#p2#y2#m2#d2#s3","SO");
				// dao.ruleNoDef("xyt","mwjc081BO","p2#s5","B");
				// String no = dao.getNewNo("mwjc081BO","FR");
				// System.out.println(no);

				/* 删除 */
			} else if (entityState.equals(EntityState.DELETED)) {
				session.delete(tbdf05);
				/* 修改 */
			} else if (entityState.equals(EntityState.MODIFIED)) {
				tbdf05.setModifyEmpNo(AppUtils.getLoginUserName()); // 修改者
				tbdf05.setModifyDate(new Date()); // 修改时间

				session.update(tbdf05);
			}
		}
	}

	/**
	 * 根据参数加载Tbdf06表中的数据
	 * 
	 * @param page
	 * @param map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void loadTbdf06(Page<Tbdf06> page, Map<String, Object> map) throws Exception {
		String hql = " from Tbdf06 where 1=1";

		if (map != null) {
			String compId = (String) map.get("compId");
			String currency0 = (String) map.get("currency0");

			if (compId != null && !compId.equals("")) {
				hql += " and compId = '" + compId + "'";
			}
			if (currency0 != null && !currency0.equals("")) {
				hql += " and currencyAbb = '" + currency0 + "'";
			}

			/*
			 * if(currency0!=null && !currency0.equals("")){ String[] strs =
			 * currency0.split(","); if(strs[0]!=null && !strs[0].equals("")){
			 * hql += " and currencyAbb = '"+strs[0]+"'"; } }
			 */
		}

		hql += " order by createDate desc ";
		List<Tbdf06> tbdf06 = (List<Tbdf06>) this.query(hql, null, page.getPageNo(), page.getPageSize());
		page.setEntities(tbdf06);
		page.setEntityCount(this.query(hql).size());
	}

	@SuppressWarnings("unchecked")
	@DataProvider
	public void searchTbdf06a(Page<Tbdf06> page, Map<String, Object> map) throws Exception {
		String hql = "select currencyAbb,currencyNameLocal from Tbdf06 where 1=1 ";
		hql += "order by createDate desc ";
		List<Tbdf06> tbdf06 = (List<Tbdf06>) this.query(hql, null, page.getPageNo(), page.getPageSize());
		page.setEntities(tbdf06);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 保存数据到表Tbdf06
	 * 
	 * @param collection
	 * @throws Exception
	 */
	@DataResolver
	@Transactional
	public void saveTbdf06(Collection<Tbdf06> collection) {
		for (Tbdf06 tbdf06 : collection) {
			EntityState entityState = EntityUtils.getState(tbdf06); // 抓取当前行状态
			if (entityState.equals(EntityState.NEW)) { // 新增
				// tbfrc1.setFrc1Id(R.getUUIDKey());//设置ID
				this.getSession().save(tbdf06);
			} else if (entityState.equals(EntityState.DELETED)) { // 删除
				this.getSession().delete(tbdf06);
			} else if (entityState.equals(EntityState.MODIFIED)) { // 修改

				this.getSession().update(tbdf06);
			}
		}
	}

	/***************************************** 单号规则创建与单号生成 *************************************/
	@Expose
	// 调用该方法需传入参数：公司别，单号代码，规则组合字串，字串常数
	public void ruleNoDef(String compId, String noId, String ruleString, String ruleConstant) throws Exception { // 产生单号规则
		String sql = "select * from Tbdf03 where COMP_ID_ = '" + compId + "' and NO_ID_ = '" + noId + "' ";
		Object[] df03s = this.getSession().createSQLQuery(sql).list().toArray();
		// List<Object[]> list = this.getSession().createSQLQuery(sql).list();

		if (df03s.length <= 0) {
			// if(df03s.length<=0){
			// 字串常数：c,变数：p,西洋年：y,月份：m,日：d,流水号：s;例如：c2#p1#y2#m2#s3(流水号影响计数)
			String[] rules = ruleString.split("#");

			int i = 1;
			String ruleId = null; // 规则序号
			String ruleDesc = null; // 规则说明
			String ruleType = null; // 规则类别
			int ruleLength = 0; // 规则长度
			// String ruleConstant = null; //字串常数
			String ruleRenew = "N"; // 规则计数影响
			String createEmpNo = AppUtils.getLoginUserName(); // 创建者
			// Date createDate = null; //创建日期
			// String modifyEmpNo = AppUtils.getLoginUserName(); //修改者
			// Date modifyDate = null; //修改日期

			String df03sql = "insert into tbdf03 (COMP_ID_,NO_ID_,NO_DESC_,GROUP_ID_,CREATE_EMP_NO_,CREATE_DATE_,MODIFY_EMP_NO_,MODIFY_DATE_) values('"
					+ compId + "','" + noId + "',null,null,'" + createEmpNo + "',sysdate,null,null)";
			this.getSession().createSQLQuery(df03sql).executeUpdate();

			for (String rule : rules) {
				ruleId = i + "";
				if (rule.charAt(0) == 'c') {
					int length = Integer.parseInt(rule.substring(1));
					if (ruleConstant.length() == length) {
						ruleDesc = "字串常数(c)";
						ruleType = "c";
						ruleLength = length;
						// ruleConstant = rule.substring(1);
						ruleRenew = "N";
					} else {
						return;
					}
				} else if (rule.charAt(0) == 'p') {
					ruleDesc = "变数(p)";
					ruleType = "p";
					ruleLength = Integer.parseInt(rule.substring(1));
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'y') {
					ruleDesc = "西洋年(y)";
					ruleType = "y";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2 && ruleLength != 4) {
						System.out.println("年份y后只能是2或者4");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'm') {
					ruleDesc = "月份(m)";
					ruleType = "m";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2) {
						System.out.println("月份m后只能是2");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'd') {
					ruleDesc = "日(d)";
					ruleType = "d";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2) {
						System.out.println("具体日d后只能是2");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 's') {
					ruleDesc = "流水号(s)";
					ruleType = "s";
					ruleLength = Integer.parseInt(rule.substring(1));
					ruleConstant = "";
					ruleRenew = "Y";
				}

				String df04sql = "insert into tbdf04 (COMP_ID_,NO_ID_,RULE_ID_,RULE_DESC_,RULE_TYPE_,RULE_LENGTH_,RULE_CONSTANT_,RULE_RENEW_,CREATE_EMP_NO_,CREATE_DATE_,MODIFY_EMP_NO_,MODIFY_DATE_) values('"
						+ compId + "','" + noId + "','" + ruleId + "','" + ruleDesc + "','" + ruleType + "',"
						+ ruleLength + ",'" + ruleConstant + "','" + ruleRenew + "','" + createEmpNo
						+ "',sysdate,null,null)";
				this.getSession().createSQLQuery(df04sql).executeUpdate();
				i++;
			}
		} else {
			return;
		}
	}

	@Expose
	// 调用该方法需传入参数：公司别，单号代码，规则组合字串，字串常数，操作人
	public void ruleNoDef(String compId, String noId, String ruleString, String constant, String operator)
			throws Exception { // 产生单号规则
		String sql = "select * from Tbdf03 where COMP_ID_ = '" + compId + "' and NO_ID_ = '" + noId + "' ";
		Object[] df03s = this.getSession().createSQLQuery(sql).list().toArray();
		// String hql = " from Tbdf03 where compId='"+compId+"' and
		// noId='"+noId+"' ";
		// List<Tbdf03> list = this.query(hql);

		if (df03s.length <= 0) {
			/* 新建单号主档TBDF03 */
			String df03sql = "insert into tbdf03 values('" + compId + "','" + noId + "',null,null,'" + operator
					+ "',sysdate,null,null)";
			this.getSession().createSQLQuery(df03sql).executeUpdate();

			/* 新建单号规则档TBDF04 */
			// c:字串常数,p:变数,y:西洋年,m:月份,d:日,s流水号(影响计数);例如：c2#p1#y2#m2#s3
			String[] rules = ruleString.split("#");
			int i = 1;
			String ruleId = null; // 规则序号
			String ruleDesc = null; // 规则说明
			String ruleType = null; // 规则类别
			int ruleLength = 0; // 规则长度
			String ruleConstant = null; // 字串常数
			String ruleRenew = "N"; // 规则计数影响
			// String createEmpNo = operator; //创建人员
			// Date createDate = null; //创建日期
			// String modifyEmpNo = operator; //修改人员
			// Date modifyDate = null; //修改日期
			for (String rule : rules) {
				if (i < 10) {
					ruleId = i + "";
				} else {
					System.out.println("规则序号超标！");
				}
				if (rule.charAt(0) == 'c') {
					int length = Integer.parseInt(rule.substring(1));
					if (constant.length() == length) {
						ruleDesc = "字串常数(c)";
						ruleType = "c";
						ruleLength = length;
						ruleConstant = constant;
						ruleRenew = "N";
					} else {
						System.out.println("字串常数长度与规则长度不符！");
						return;
					}
				} else if (rule.charAt(0) == 'p') {
					ruleDesc = "变数(p)";
					ruleType = "p";
					ruleLength = Integer.parseInt(rule.substring(1));
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'y') {
					ruleDesc = "西洋年(y)";
					ruleType = "y";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2 && ruleLength != 4) {
						System.out.println("规则字串中年份y后只能是2或者4");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'm') {
					ruleDesc = "月份(m)";
					ruleType = "m";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2) {
						System.out.println("规则字串中月份m后只能是2");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'd') {
					ruleDesc = "日(d)";
					ruleType = "d";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2) {
						System.out.println("规则字串中日d后只能是2");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 's') {
					ruleDesc = "流水号(s)";
					ruleType = "s";
					ruleLength = Integer.parseInt(rule.substring(1));
					ruleConstant = "";
					ruleRenew = "Y";
				}

				String df04sql = "insert into tbdf04 values('" + compId + "','" + noId + "','" + ruleId + "','"
						+ ruleDesc + "','" + ruleType + "'," + ruleLength + ",'" + ruleConstant + "','" + ruleRenew
						+ "','" + operator + "',sysdate,null,null)";
				this.getSession().createSQLQuery(df04sql).executeUpdate();
				i++;
			}
		} else {
			return;
		}
	}

	@Expose
	// 调用该方法需传入参数：公司别，单号代码，单号名称，资料授权群组，规则字串，字串常数，操作人
	public void ruleNoDef(String compId, String noId, String noDesc, String groupId, String ruleString, String constant,
			String operator) throws Exception { // 产生单号规则
		String sql = "select * from Tbdf03 where COMP_ID_ = '" + compId + "' and NO_ID_ = '" + noId + "' ";
		Object[] df03s = this.getSession().createSQLQuery(sql).list().toArray();
		// String hql = " from Tbdf03 where compId='"+compId+"' and
		// noId='"+noId+"' ";
		// List<Tbdf03> list = this.query(hql);

		if (df03s.length <= 0) {
			/* 新建单号主档TBDF03 */
			String df03sql = "insert into tbdf03 values('" + compId + "','" + noId + "','" + noDesc + "','" + groupId
					+ "','" + operator + "',sysdate,null,null)";
			this.getSession().createSQLQuery(df03sql).executeUpdate();

			/* 新建单号规则档TBDF04 */
			// c:字串常数,p:变数,y:西洋年,m:月份,d:日,s流水号(影响计数);例如：c2#p1#y2#m2#s3
			String[] rules = ruleString.split("#");
			int i = 1;
			String ruleId = null; // 规则序号
			String ruleDesc = null; // 规则说明
			String ruleType = null; // 规则类别
			int ruleLength = 0; // 规则长度
			String ruleConstant = null; // 字串常数
			String ruleRenew = null; // 规则计数影响
			// String createEmpNo = operator; //创建人员
			// Date createDate = null; //创建时间
			// String modifyEmpNo = operator; //修改人员
			// Date modifyDate = null; //修改时间
			for (String rule : rules) {
				// ruleId = i+"";
				if (i < 100) {
					ruleId = ("0" + i).substring(("0" + i).length() - 2);
				} else {
					System.out.println("规则序号超标！");
				}

				if (rule.charAt(0) == 'c') {
					int length = Integer.parseInt(rule.substring(1));
					if (constant.length() == length) {
						ruleDesc = "字串常数(c)";
						ruleType = "c";
						ruleLength = length;
						ruleConstant = constant;
						ruleRenew = "N";
					} else {
						System.out.println("字串常数长度与规则长度不符！");
						return;
					}
				} else if (rule.charAt(0) == 'p') {
					ruleDesc = "变数(p)";
					ruleType = "p";
					ruleLength = Integer.parseInt(rule.substring(1));
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'y') {
					ruleDesc = "西洋年(y)";
					ruleType = "y";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2 && ruleLength != 4) {
						System.out.println("规则字串中年份y后只能是2或者4");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'm') {
					ruleDesc = "月份(m)";
					ruleType = "m";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2) {
						System.out.println("规则字串中月份m后只能是2");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 'd') {
					ruleDesc = "日(d)";
					ruleType = "d";
					ruleLength = Integer.parseInt(rule.substring(1));
					if (ruleLength != 2) {
						System.out.println("规则字串中日d后只能是2");
						return;
					}
					ruleConstant = "";
					ruleRenew = "N";
				} else if (rule.charAt(0) == 's') {
					ruleDesc = "流水号(s)";
					ruleType = "s";
					ruleLength = Integer.parseInt(rule.substring(1));
					ruleConstant = "";
					ruleRenew = "Y";
				}

				String df04sql = "insert into tbdf04 values('" + compId + "','" + noId + "','" + ruleId + "','"
						+ ruleDesc + "','" + ruleType + "'," + ruleLength + ",'" + ruleConstant + "','" + ruleRenew
						+ "','" + operator + "',sysdate,null,null)";
				this.getSession().createSQLQuery(df04sql).executeUpdate();
				i++;
			}
		} else {
			return;
		}
	}

	/**
	 * Tbdf05单号主键生成策略
	 * 
	 * @param noId
	 *            单号代码
	 * @param variable
	 *            变量
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Expose
	public Tbdf05 generateNoStyle(Map<String, Object> mapIn) throws Exception { // 产生单号格式
		String noId = (String) mapIn.get("noId"); // 单号代码
		String variable = (String) mapIn.get("variable"); // 变数
		String flag = (String) mapIn.get("flag"); // 增/减号

		// 先根据输入的单号代码去查询对应的单号规则
		// 公司别 规则序号 规则说明 规则类别 规则长度 字串常数 规则计数影响 单号代码 规则序号
		String sql1 = "select COMP_ID_,RULE_ID_,RULE_DESC_,RULE_TYPE_,RULE_LENGTH_,RULE_CONSTANT_,RULE_RENEW_ from Tbdf04 where NO_ID_ = '"
				+ noId + "' order by RULE_ID_";
		List<Object[]> list1 = this.getSession().createSQLQuery(sql1).list();
		// List<Object[]> list1 = this.query(sql1);

		StringBuffer orderNo = new StringBuffer(); // 组装单号到tbdf05中进行模糊查询
		int totalLength = 0; // 单号总长度
		int serialNumberLength = 0; // 流水号规则长度(组装时用"_"代替)
		String compId = ""; // 公司别

		for (Object[] tbdf04 : list1) { // 遍历结果集
			compId = tbdf04[0].toString();
			/* 规则类别为c(字串常数) */
			if (tbdf04[3].toString().equals("c")) {
				orderNo.append(tbdf04[5].toString()); // 加上字串常数
				totalLength += Integer.parseInt(tbdf04[4].toString());
				continue;
			}
			/* 规则类别为p(变数) */
			if (tbdf04[3].toString().equals("p")) {
				if (StringUtils.isNumeric(tbdf04[4].toString())) { // 判断规则长度是不是一个数
					if (variable != null && variable != "") {
						if (variable.length() == Integer.parseInt(tbdf04[4].toString())) {
							orderNo.append(variable); // 变数
							// totalLength +=
							// ((BigDecimal)tbdf04[4]).intValue();
							totalLength += Integer.parseInt(tbdf04[4].toString());
							continue; // 结束本次循环
						} else {
							System.out.println("变量值实际长度与规则长度不符！");
							continue;
						}
					} else {
						System.out.println("变量值不能为空！");
						continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不正确！");
					continue;
				}
			}
			/* 规则类别为y(西洋年) */
			if (tbdf04[3].toString().equals("y")) {
				if (StringUtils.isNumeric(tbdf04[4].toString())) { // 判断规则长度是不是一个数
					if (Integer.parseInt(tbdf04[4].toString()) == 4) {
						orderNo.append(Calendar.getInstance().get(Calendar.YEAR) + "");
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加4
						continue;
					} else if (Integer.parseInt(tbdf04[4].toString()) == 2) {
						orderNo.append((Calendar.getInstance().get(Calendar.YEAR) + "").substring(2, 4));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						continue;
					} else {
						System.out.println(tbdf04[3].toString() + "的规则长度只能是2和4！");
						continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不正确！");
					continue;
				}
			}
			/* 规则类别为m(月份) */
			if (tbdf04[3].toString().equals("m")) {
				if (Integer.parseInt(tbdf04[4].toString()) == 2) {
					if ((Calendar.getInstance().get(Calendar.MONTH) + 1) < 10) { // 判断当前月份数的位数,若为1位则补0
						orderNo.append("0" + (Calendar.getInstance().get(Calendar.MONTH) + 1));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						continue;
					} else {
						orderNo.append((Calendar.getInstance().get(Calendar.MONTH) + 1));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不正确！");
					continue;
				}
			}
			/* 规则类别为d(日) */
			if (tbdf04[3].toString().equals("d")) {
				if (Integer.parseInt(tbdf04[4].toString()) == 2) {
					if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 10) { // 判断当前日的位数,若为1位则前面补0
						orderNo.append("0" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						continue;
					} else {
						orderNo.append(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不正确！");
					continue;
				}
			}
			/* 规则类别为s(流水号) */
			if (tbdf04[3].toString().equals("s")) {
				if (StringUtils.isNumeric(tbdf04[4].toString())) { // 判断规则长度是不是一个数
					// System.out.println(StringUtils.isNumeric("ac")); //false
					serialNumberLength += Integer.parseInt(tbdf04[4].toString()); // (流水号)规则长度
					for (int i = 0; i < serialNumberLength; i++) {
						orderNo.append("_");
					}
					totalLength += serialNumberLength;
					continue;
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不正确！");
					continue;
				}
			}
		}

		// 将组装好的单号放入tbdf05使用 like进行模糊查询
		// 单号格式 当前计数
		String sql2 = "select NO_STYLE_,NO_COUNT_ from tbdf05 where NO_STYLE_ like '" + orderNo.toString()
				+ "%' and NO_COUNT_=(select MAX (NO_COUNT_) from tbdf05 where NO_STYLE_ like '" + orderNo.toString()
				+ "%')";
		List<Object[]> list2 = this.getSession().createSQLQuery(sql2).list();
		// List<Object[]> list2 = this.query(sql2);
		String noStyle = ""; // 单号格式
		String noCount = ""; // 当前计数
		for (Object[] tbdf05 : list2) {
			noStyle = tbdf05[0].toString() == null ? "" : tbdf05[0].toString();
			noCount = tbdf05[1].toString() == null ? "" : tbdf05[1].toString();
		}

		Tbdf05 df05 = new Tbdf05();
		StringBuffer returnNo = new StringBuffer();
		// 判断是否有记录,如果有那么更新当前计数+1,并返回新的单号,返回单号的流水号部分要和当前计数对应
		if (StringUtils.isNotBlank(noStyle)) {
			Integer number = Integer.parseInt(noCount);
			if (flag.equals("-1")) {
				number -= 1;
				if (number < 1) {
					number = 1;
				}
			} else {
				number += 1;
			}

			returnNo.append(orderNo.substring(0, totalLength - serialNumberLength).toString()); // 截取流水号以前的部分
			for (int i = 0; i < serialNumberLength - number.toString().length(); i++) {
				returnNo.append(0 + "");
			}
			returnNo.append(number + "");

			/*
			 * String sql3 = "update tbdf05 set NO_STYLE_ = '" +
			 * returnNoStyle.toString() + "',NO_COUNT_ = " + number +
			 * " where NO_STYLE_ = '" + noStyle + "'"; int message =
			 * this.getSession().createSQLQuery(sql3).executeUpdate();
			 * //返回影响的行数,单号代码对应的单号只有唯一一条记录 if(message == 1){
			 * System.out.println("更新成功！"); }
			 */
			df05.setNoStyle(returnNo.toString());
			df05.setNoCount(new BigDecimal(number));

			// 没有记录则新生成单号主键，对应的当前计数从1开始，返回单号的流水号部分要和当前计数对应
		} else {
			returnNo.append(orderNo.substring(0, totalLength - serialNumberLength).toString()); // 截取流水号以前的部分
			for (int i = 0; i < serialNumberLength - 1; i++) {
				returnNo.append(0 + "");
			}
			returnNo.append(1 + "");

			/*
			 * String sql4 =
			 * "insert into tbdf05 (COMP_ID_,NO_ID_,NO_STYLE_,NO_COUNT_) values ('"
			 * + compId + "','" + noId + "','" + returnNoStyle.toString() +
			 * "','" + 1 + "')";//注册单号 int message2
			 * =this.getSession().createSQLQuery(sql4).executeUpdate();
			 * if(message2 == 1){ System.out.println("注册成功！"); }else if(message2
			 * == -1){ System.out.println("注册失败！"); }
			 */

			df05.setNoStyle(returnNo.toString());
			df05.setNoCount(new BigDecimal(1));
		}

		// System.out.println(df05);
		return df05;
	}

	@SuppressWarnings("unchecked")
	@Expose
	public Tbdf05 getNew(Map<String, Object> mapIn) throws Exception { // 产生单号格式
		String noId = (String) mapIn.get("noId"); // 单号代码
		String variable = (String) mapIn.get("variable"); // 变数
		// String flag = (String)mapIn.get("flag"); //增/减号
		String operator = (String) mapIn.get("operator"); // 操作人

		// 先根据输入的单号代码去查询对应的单号规则
		// 公司别 规则序号 规则说明 规则类别 规则长度 字串常数 规则计数影响 单号代码 规则序号
		String sql1 = "select COMP_ID_,RULE_ID_,RULE_DESC_,RULE_TYPE_,RULE_LENGTH_,RULE_CONSTANT_,RULE_RENEW_ from Tbdf04 where NO_ID_ = '"
				+ noId + "' order by RULE_ID_";
		List<Object[]> list1 = this.getSession().createSQLQuery(sql1).list();
		// List<Object[]> list1 = this.query(sql1);

		StringBuffer orderNo = new StringBuffer(); // 组装单号到tbdf05中进行模糊查询
		int totalLength = 0; // 单号总长度
		int serialNumberLength = 0; // 流水号规则长度(组装时用"9"代替)
		String compId = ""; // 公司别

		for (Object[] tbdf04 : list1) { // 遍历结果集
			compId = tbdf04[0].toString();
			/* 规则类别为c(字串常数) */
			if (tbdf04[3].toString().equals("c")) {
				orderNo.append(tbdf04[5].toString()); // 加上字串常数
				totalLength += Integer.parseInt(tbdf04[4].toString());
				// totalLength += ((BigDecimal)tbdf04[4]).intValue();
				// continue; //结束本次循环
			}
			/* 规则类别为p(变数) */
			else if (tbdf04[3].toString().equals("p")) {
				if (StringUtils.isNumeric(tbdf04[4].toString())) { // 判断规则长度是不是一个数
					if (variable != null && variable != "") {
						if (variable.length() == Integer.parseInt(tbdf04[4].toString())) {
							// for(int i=0;i<variable.length();i++){
							// orderNo.append("_");
							// }
							orderNo.append(variable); // 变数
							totalLength += Integer.parseInt(tbdf04[4].toString());
							// continue;
						} else {
							System.out.println("变量值实际长度与规则长度不符！");
							// continue;
						}
					} else {
						System.out.println("变量值不能为空！");
						// continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不是一个数！");
					// continue;
				}
			}
			/* 规则类别为y(西洋年) */
			else if (tbdf04[3].toString().equals("y")) {
				if (StringUtils.isNumeric(tbdf04[4].toString())) { // 判断规则长度是不是一个数
					if (Integer.parseInt(tbdf04[4].toString()) == 4) {
						orderNo.append(Calendar.getInstance().get(Calendar.YEAR) + "");
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加4
						// continue;
					} else if (Integer.parseInt(tbdf04[4].toString()) == 2) {
						orderNo.append((Calendar.getInstance().get(Calendar.YEAR) + "").substring(2, 4));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						// continue;
					} else {
						System.out.println(tbdf04[3].toString() + "的规则长度只能是2或4！");
						// continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不是一个数！");
					// continue;
				}
			}
			/* 规则类别为m(月份) */
			else if (tbdf04[3].toString().equals("m")) {
				if (Integer.parseInt(tbdf04[4].toString()) == 2) {
					if ((Calendar.getInstance().get(Calendar.MONTH) + 1) < 10) { // 判断当前月份数的位数,若为1位则补0
						orderNo.append("0" + (Calendar.getInstance().get(Calendar.MONTH) + 1));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						// continue;
					} else {
						orderNo.append((Calendar.getInstance().get(Calendar.MONTH) + 1));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						// continue;
					}
				} else {
					System.out.println(tbdf04[3] + "的规则长度只能是2！");
					// continue;
				}
			}
			/* 规则类别为d(日) */
			else if (tbdf04[3].toString().equals("d")) {
				if (Integer.parseInt(tbdf04[4].toString()) == 2) {
					if ((Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1) < 10) { // 判断当前日的位数,若为1位则前面补0
						orderNo.append("0" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						// continue;
					} else {
						orderNo.append(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
						totalLength += Integer.parseInt(tbdf04[4].toString()); // 加2
						// continue;
					}
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度只能是2！");
					// continue;
				}
			}
			/* 规则类别为s(流水号) */
			else if (tbdf04[3].toString().equals("s")) {
				if (StringUtils.isNumeric(tbdf04[4].toString())) { // 判断规则长度是不是一个数
					// System.out.println(StringUtils.isNumeric("ac")); //false
					serialNumberLength += Integer.parseInt(tbdf04[4].toString()); // (流水号)规则长度
					for (int i = 0; i < serialNumberLength; i++) {
						orderNo.append("9");
					}
					totalLength += serialNumberLength;
					// continue;
				} else {
					System.out.println(tbdf04[3].toString() + "的规则长度不是一个数！");
					// continue;
				}
			}
		}

		// 将组装好的单号放入tbdf05使用 like进行模糊查询
		// 单号格式 当前计数
		String sql2 = "select NO_STYLE_,NO_COUNT_ from tbdf05 where NO_ID_='" + noId + "' and NO_STYLE_ like '"
				+ orderNo.toString() + "%'";
		List<Object[]> list2 = this.getSession().createSQLQuery(sql2).list();

		String noStyle = ""; // 单号格式
		String noCount = ""; // 当前计数
		for (Object[] tbdf05 : list2) {
			noStyle = tbdf05[0].toString() == null ? "" : tbdf05[0].toString();
			noCount = tbdf05[1].toString() == null ? "" : tbdf05[1].toString();
		}

		Tbdf05 df05 = new Tbdf05();
		StringBuffer returnNo = new StringBuffer();
		String createUser = null;
		if (mapIn.get("operator") == "undefined" || mapIn.get("operator") == null || "".equals(mapIn.get("operator"))) {
			createUser = AppUtils.getLoginUserName(); // 创建者
		} else {
			createUser = operator;
		}
		String sql3 = "";
		// 判断是否有记录,如果有那么更新当前计数+1,并返回新的单号,返回单号的流水号部分要和当前计数对应
		if (StringUtils.isNotBlank(noStyle)) {
			Integer number = Integer.parseInt(noCount) + 1;

			returnNo.append(orderNo.substring(0, totalLength - serialNumberLength).toString()); // 截取流水号以前的部分
			for (int i = 0; i < serialNumberLength - number.toString().length(); i++) {
				returnNo.append(0 + "");
			}
			returnNo.append(number + "");

			df05.setNoStyle(returnNo.toString());
			df05.setNoCount(new BigDecimal(number));
			sql3 = "update TBDF05 " + "set NO_COUNT_=" + df05.getNoCount().intValue() + "," + "	MODIFY_EMP_NO_='"
					+ createUser + "'," + "	MODIFY_DATE_=sysdate " + "where COMP_ID_='" + compId + "' and NO_ID_='"
					+ noId + "' and NO_STYLE_='" + orderNo.toString() + "'";
			// 没有记录则新生成单号主键，对应的当前计数从1开始，返回单号的流水号部分要和当前计数对应
		} else {
			returnNo.append(orderNo.substring(0, totalLength - serialNumberLength).toString()); // 截取流水号以前的部分
			for (int i = 0; i < serialNumberLength - 1; i++) {
				returnNo.append(0 + "");
			}
			returnNo.append(1 + "");

			df05.setNoStyle(returnNo.toString());
			df05.setNoCount(new BigDecimal(1));
			sql3 = "insert into TBDF05 (COMP_ID_,NO_ID_,NO_STYLE_,NO_COUNT_,CREATE_EMP_NO_,CREATE_DATE_) values('"
					+ compId + "','" + noId + "','" + orderNo.toString() + "'," + df05.getNoCount().intValue() + ",'"
					+ createUser + "',sysdate)";
		}
		// 将新的单号数据持久化
		// String sql3 = "insert into TBDF05
		// (COMP_ID_,NO_ID_,NO_STYLE_,NO_COUNT_,CREATE_EMP_NO_,CREATE_DATE_)
		// values('" + compId + "','" + noId + "','" + df05.getNoStyle() + "',"
		// + df05.getNoCount().intValue() + ",'" + createUser + "',sysdate)";
		// String sql3 = "update TBDF05
		// (COMP_ID_,NO_ID_,NO_STYLE_,NO_COUNT_,CREATE_EMP_NO_,CREATE_DATE_)
		// values('" + compId + "','" + noId + "','" + orderNo.toString() + "',"
		// + df05.getNoCount().intValue() + ",'" + createUser + "',sysdate)";
		this.getSession().createSQLQuery(sql3).executeUpdate();

		return df05;
	}

	/*
	 * System.out.println(Calendar.getInstance().get(Calendar.DATE)); //16
	 * System.out.println(Calendar.getInstance().get(Calendar.MONTH)); //4 +1
	 * System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	 * //16
	 * System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)); //4
	 * -1 System.out.println(Calendar.getInstance().get(Calendar.
	 * DAY_OF_WEEK_IN_MONTH)); //3
	 * System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
	 * //136
	 */

}
