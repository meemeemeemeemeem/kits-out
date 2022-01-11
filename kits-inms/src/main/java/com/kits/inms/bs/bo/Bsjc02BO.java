package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbdm01;
import com.kits.inms.bs.util.MatrlNoInterface;
import com.kits.inms.utils.AppDbUtils;
import com.kits.inms.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 料号信息的维护
 * 
 * @author chengxiaoLong
 * 
 */
@Controller
public class Bsjc02BO extends HibernateDao {

	@Autowired
	private MatrlNoInterface matrlDao;
	
	/*@Autowired
	private Iaji051 iajc051;*/

	/**
	 * 获取映射的值
	 * 
	 * @return
	 */
	@DataProvider
	public Map<String, Object> getIventoryMappings(Map<String, Object> map) {

		String refId = (String) map.get("refId");
		Map<String, Object> mapValue = AppDbUtils.getMappings(AppUtils
				.getLoginUser().getCompanyId(), refId, this.getSession());

		return mapValue;
	}

	/**
	 * 查询料号信息
	 * 
	 * @param page
	 * @param parameter
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@DataProvider
	public void queryDm01(Page<Tbdm01> page, Map<String, Object> parameter)
			throws Exception {

		String hql = " from Tbdm01 where 1=1";
		if (parameter != null) {
			// 材质
			String materialName = (String) (parameter.get("materailName") == null ? ""
					: parameter.get("materailName"));

			if (AppUtils.isNotEmpty(materialName)) {
				hql += " and materail_name_ like '%" + materialName + "%'";
			}
			// 品名
			String prodeName = (String) (parameter.get("prodeName") == null ? ""
					: parameter.get("prodeName"));

			if (AppUtils.isNotEmpty(prodeName)) {
				hql += " and prodeName like '%" + prodeName + "%'";
			}

			// 料号
			String matrlNo = (String) parameter.get("matrlNo");
			if (AppUtils.isNotEmpty(matrlNo)) {

				matrlNo = matrlNo.toUpperCase();
				hql += " and matrl_no_ like'%" + matrlNo + "%'";
			}
			// 料别
			String inventoryType = (String) parameter.get("inventoryType");
			if (AppUtils.isNotEmpty(inventoryType)) {

				hql += " and inventoryType ='" + inventoryType + "'";
			}

			// 外观
			String appearance = (String) parameter.get("appearance");
			if (AppUtils.isNotEmpty(appearance)) {

				hql += " and appearance ='" + appearance + "'";
			}

			// 用途
			String pdType = (String) parameter.get("pdType");
			if (AppUtils.isNotEmpty(pdType)) {

				hql += " and pdType ='" + pdType + "'";
			}

			// 生产标准
			String grade = (String) parameter.get("grade");
			if (AppUtils.isNotEmpty(grade)) {

				hql += " and grade ='" + grade + "'";
			}

			// 生产类型
			String prodeCode = (String) parameter.get("prodeCode");
			if (AppUtils.isNotEmpty(prodeCode)) {

				hql += " and prodeCode ='" + prodeCode + "'";
			}
			if (AppUtils.isNotEmpty(prodeCode)) {

				hql += " and prodeCode ='" + prodeCode + "'";
			}
			// 产地
			String materailSrc = (String) parameter.get("materailSrc");
			if (AppUtils.isNotEmpty(materailSrc)) {

				hql += " and materailSrc ='" + materailSrc + "'";
			}
		}
		hql += " and compId ='" + AppUtils.getLoginUser().getCompanyId() + "'";
		hql += " order by update_date_ desc,create_date_ asc ";

		List<Tbdm01> dataList = (List<Tbdm01>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());

		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 原料料号
	 * 
	 * @param page
	 * @param parameter
	 * @throws Exception
	 */
	@DataProvider
	public void queryDm011(Page<Tbdm01> page, Map<String, Object> parameter)
			throws Exception {

		String hql = " from Tbdm01 where 1=1";
		if (parameter != null) {
			// 材质
			String materialName = (String) (parameter.get("materailName") == null ? ""
					: parameter.get("materailName"));

			if (AppUtils.isNotEmpty(materialName)) {
				hql += " and materail_name_ like '%" + materialName + "%'";
			}
			// 品名
			String prodeName = (String) (parameter.get("prodeName") == null ? ""
					: parameter.get("prodeName"));

			if (AppUtils.isNotEmpty(materialName)) {
				hql += " and prodeName like '%" + prodeName + "%'";
			}
			// 料别
			String inventoryType = (String) parameter.get("inventoryType");
			if (AppUtils.isNotEmpty(inventoryType)) {

				hql += " and inventoryType ='" + inventoryType + "'";
			}
			// 外观
			String appearance = (String) parameter.get("appearance");
			if (AppUtils.isNotEmpty(appearance)) {

				hql += " and appearance ='" + appearance + "'";
			}
			// 产地
			String materailSrc = (String) parameter.get("materailSrc");
			if (AppUtils.isNotEmpty(materailSrc)) {

				hql += " and materailSrc ='" + materailSrc + "'";
			}
		}

		hql += " and compId ='" + AppUtils.getLoginUser().getCompanyId()
				+ "' and  inventoryType not in('A','M')";
		hql += " order by update_date_ desc,create_date_ asc ";

		@SuppressWarnings("unchecked")
		List<Tbdm01> dataList = (List<Tbdm01>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());

		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 物料料号
	 * 
	 * @param page
	 * @param parameter
	 * @throws Exception
	 */
	@DataProvider
	public void queryDm012(Page<Tbdm01> page, Map<String, Object> parameter)
			throws Exception {

		String hql = " from Tbdm01 where 1=1";
		if (parameter != null) {
			// 品名
			String prodeName = (String) (parameter.get("prodeName") == null ? ""
					: parameter.get("prodeName"));

			if (AppUtils.isNotEmpty(prodeName)) {
				hql += " and prodeName like '%" + prodeName + "%'";
			}

			// 料别
			String inventoryType = (String) parameter.get("inventoryType");
			if (AppUtils.isNotEmpty(inventoryType)) {

				hql += " and inventoryType ='" + inventoryType + "'";
			}else{
				hql += " and  inventoryType  in('A','M')";
			}
			// 外观
			String appearance = (String) parameter.get("appearance");
			if (AppUtils.isNotEmpty(appearance)) {

				hql += " and appearance ='" + appearance + "'";
			}

		}else{
			hql += " and  inventoryType  in('A','M')";
		}
		hql += " and compId ='" + AppUtils.getLoginUser().getCompanyId()
				+ "' order by matrlNo desc ";

		@SuppressWarnings("unchecked")
		List<Tbdm01> dataList = (List<Tbdm01>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());

		page.setEntities(dataList);
		page.setEntityCount(this.query(hql).size());
	}

	/**
	 * 维护料号信息
	 * 
	 * @param tblh
	 */
	@Transactional
	@DataResolver
	public String updateDm01(Collection<Tbdm01> tblhColl) {
		
		try {
			for (Tbdm01 dm : tblhColl) {
				EntityState state = EntityUtils.getState(dm);
				if (state.equals(EntityState.NEW)) {
					// 新增
					matrlDao.getMatrlNo(dm);

				} else if (state.equals(EntityState.DELETED)) {
					// 删除
					this.getSession().delete(dm);

				} else if (state.equals(EntityState.MODIFIED)) {
					// 修改
					this.getSession().delete(dm);
					// 新增
					matrlDao.getMatrlNo(dm);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return "操作出错："+e.getMessage();
		}
		return null;
	}
	/**
	 * 料号汇入信息
	 */
	@DataResolver
	public String saveExcelIn(Collection<Tbdm01> tblhColl) {
		for (Tbdm01 dm : tblhColl) {
			try {
				if(dm.getTrick()!=null){
					StringBuffer sb = new StringBuffer(dm.getTrick().toString());
					if(dm.getWidth()!=null){
						sb.append("*"+dm.getWidth());
					}else{
						sb.append("*"+"W");
					}
					
					if(dm.getLengthA()!=null){
						sb.append("*"+dm.getLengthA());
					}else{
						sb.append("*"+"L");
					}
					
					dm.setDefn01(sb.toString());
				}
				// 新增
				matrlDao.getMatrlNo(dm);
			} catch (Exception e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}
		return null;
	}

	/**
	 * 获取料号
	 * 
	 * @param prodeType
	 * @return
	 */
	public String getMatrlNo(String prodeType) {

		String sql = "select max(substr(matrl_no_,6,10)) from tbdm01 where matrl_no_ like '"
				+ prodeType
				+ "%' and comp_id_='"
				+ AppUtils.getLoginUser().getCompanyId() + "'";

		String matrlNo = (String) this.getSession().createSQLQuery(sql)
				.uniqueResult();

		if (matrlNo != null && !"".equals(matrlNo)) {
			int i = Integer.parseInt(matrlNo);
			NumberFormat nf = NumberFormat.getInstance();
			// 设置是否使用分组
			nf.setGroupingUsed(false);
			// 设置最大整数位数
			nf.setMaximumIntegerDigits(5);
			// 设置最小整数位数
			nf.setMinimumIntegerDigits(5);

			String s1 = nf.format(i + 1);
			return s1;
		}
		return "00001";
	}

	/**
	 * 组成料号中文描述信息
	 * 
	 * @param dm01
	 * @return
	 */
	public String makeMatrlDesc(Tbdm01 dm01) {

		Map<String, Object> map1 = AppDbUtils.getValue(AppUtils.getLoginUser()
				.getCompanyId(), "inventoryType",

		dm01.getInventoryType(), this.getSession());
		String inventoryType = (String) map1.get("value");

		Map<String, Object> map2 = AppDbUtils.getValue(AppUtils.getLoginUser()
				.getCompanyId(), "appearance", dm01.getAppearance(), this
				.getSession());
		String appearance = (String) map2.get("value");

		Map<String, Object> map3 = AppDbUtils.getValue(AppUtils.getLoginUser()
				.getCompanyId(), "prodeCode", dm01.getProdeCode(), this
				.getSession());
		String prodeCode1 = (String) map3.get("value");

		String materailSrc = null;
		if (AppUtils.isNotEmpty(dm01.getMaterailSrc())) {
			Map<String, Object> map4 = AppDbUtils.getValue(AppUtils
					.getLoginUser().getCompanyId(), "materailSrc", dm01
					.getMaterailSrc(), this.getSession());
			materailSrc = (String) map4.get("value");
		}

		StringBuffer sb = new StringBuffer(inventoryType + "_" + prodeCode1
				+ "_" + appearance);

		//用途
		if (AppUtils.isNotEmpty(dm01.getPdType())) {
			
			//String pdType = iajc051.getAccountItemName(dm01.getPdType());
			//sb.append("_" + pdType);
		}
		if (AppUtils.isNotEmpty(materailSrc)) {
			sb.append("_" + materailSrc);
		}
		if (AppUtils.isNotEmpty(dm01.getMaterailName())) {
			sb.append("_" + dm01.getMaterailName());
		}

		if (AppUtils.isNotEmpty(dm01.getGrade())) {

			Map<String, Object> map4 = AppDbUtils.getValue(AppUtils
					.getLoginUser().getCompanyId(), "grade", dm01.getGrade(),
					this.getSession());
			String grade = (String) map4.get("value");

			sb.append("_" + grade);
		}
		if (AppUtils.isNotEmpty(dm01.getPriceMethod())) {
			Map<String, Object> map5 = AppDbUtils.getValue(AppUtils
					.getLoginUser().getCompanyId(), "priceMethod", dm01
					.getPriceMethod(), this.getSession());
			String shape = (String) map5.get("value");
			sb.append("_" + shape);
		}

		if (AppUtils.isNotEmpty(dm01.getDefn01())) {
			sb.append("_" + dm01.getDefn01());
		}
		return sb.toString();
	}
}
