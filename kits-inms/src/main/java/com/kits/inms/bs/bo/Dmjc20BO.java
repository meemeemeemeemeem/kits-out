package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbdm20;
import com.kits.inms.bs.domain.Tbdm21;
import com.kits.inms.bs.domain.Tbdm22;
import com.kits.inms.utils.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author YangXuhui
 */
@Controller
public class Dmjc20BO extends HibernateDao {

	@SuppressWarnings("unchecked")
	@DataProvider
	public void queryTbdm22(Page<Tbdm22> page, Map<String, Object> map)
			throws Exception {
		String hql = " from Tbdm22 where 1=1 ";
		if (map != null) {
			String matNo = (String) map.get("matNo");
			String matItem = (String) map.get("matItem");
			String matName = (String) map.get("matName");
			if (matNo != null && !"".equals(matNo)) {
				hql += "and matNo = '" + matNo + "'";
			}
			if (matItem != null && !"".equals(matItem)) {
				hql += "and matItem = '" + matItem + "'";
			}
			if (matName != null && !"".equals(matName)) {
				hql += "and matName like '%" + matName + "%'";
			}
		}
		List<Tbdm22> list = (List<Tbdm22>) this.query(hql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(list);
		page.setEntityCount(this.query(hql).size());
	}

	@SuppressWarnings("unchecked")
	@DataResolver
	@Transactional(rollbackFor = Exception.class)
	public String saveTbdm20(Collection<Tbdm20> collection) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			for (Tbdm20 tbdm20 : collection) {
				EntityState entityState = EntityUtils.getState(tbdm20);
				tbdm20.setCompId("Knowledge");
				String hql = "from Tbdm20 where 1=1 and matNo = '"+ tbdm20.getMatNo() + "' and matItem = '"+ tbdm20.getMatItem() + "'" +
						"and compId = '" + tbdm20.getCompId() + "'";
				if(entityState.equals(EntityState.NEW)){
					if (this.query(hql).size() == 0) {
						tbdm20.setPkDm02(AppUtils.getUUIDKey());
						tbdm20.setCreDate(new Date());
						tbdm20.setCreEmpNo(AppUtils.getLoginUserName());
						tbdm20.setStatus("0");
						this.getSession().save(tbdm20);
						return null;
					}else{
						throw new RuntimeException("数据库已存在该钢种");
					}
				}else if(entityState.equals(EntityState.DELETED)){
					this.getSession().delete(tbdm20);
				}else if(entityState.equals(EntityState.MODIFIED)){
					tbdm20.setModifyDate(new Date());
					tbdm20.setModifyEmpNo(AppUtils.getLoginUserName());
					this.getSession().update(tbdm20);
				}
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@DataProvider
	public void queryTbdm20(Page<Tbdm20> page,Map<String,Object> map){
		String hql = " from Tbdm20 where 1=1 ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(map != null){
			String compId = "Knowledge";
			String matNo = (String)map.get("matNo");
			String matItem = (String)map.get("matItem");
			String matName = (String)map.get("matName");
			String matAbbrevName = (String)map.get("matAbbrevName");
			String accClassify = (String)map.get("accClassify");
			String closeCond = (String)map.get("closeCond");
			String creEmpNo = (String)map.get("creEmpNo");
			Date creDate = (Date) map.get("creDate");
			String modifyEmpNo = (String)map.get("modifyEmpNo");
			Date modifyDate = (Date) map.get("modifyDate");
			String status = (String)map.get("status");
			hql += "and compId = '" + compId + "' ";
			if(matNo != null){
				hql += "and matNo = '" + matNo + "' ";
			}
			if(matItem != null){
				hql += "and matItem = '" + matItem + "' ";
			}
			if(matName != null){
				hql += "and matName = '" + matName + "' ";
			}
			if(matAbbrevName != null){
				hql += "and matAbbrevName = '" + matAbbrevName + "' ";
			}
			if(accClassify != null){
				hql += "and accClassify = '" + accClassify + "' ";
			}
			if(closeCond != null){
				hql += "and closeCond = '" + closeCond + "' ";
			}
			if(creEmpNo != null){
				hql += "and creEmpNo = '" + creEmpNo + "' ";
			}
			if(creDate != null){
				hql += "and to_char(creDate,'yyyy-mm-dd') = '" + sdf.format(creDate) + "' ";
			}
			if(modifyEmpNo != null){
				hql += "and modifyEmpNo = '" + modifyEmpNo + "' ";
			}
			if(modifyDate != null){
				hql += "and to_char(modifyDate,'yyyy-MM-dd') = '" + sdf.format(modifyDate) + "' ";
			}
			if(status != null){
				hql += "and status = '" + status + "' ";
			}
		}
		List<Tbdm20> tbdm20 = (List<Tbdm20>)this.query(hql,null,page.getPageNo(),page.getPageSize());
		page.setEntities(tbdm20);
		page.setEntityCount(this.query(hql).size());
	}
	
	@SuppressWarnings("unchecked")
	@DataProvider
	public void queryTbdm21(Page<Tbdm21> page, Map<String, Object> map) {
		String hql = " from Tbdm21 where compId = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
		if (map != null) {
			String matNo = (String) map.get("matNo");
			String matItem = (String) map.get("matItem");
			String matName = (String) map.get("matName");
			String specCode = (String)map.get("specCode");
			String prodType = (String)map.get("prodType");

			if (matNo != null && !"".equals(matNo)) {
				hql += "and matNo = '" + matNo + "'";
			}
			if (matItem != null && !"".equals(matItem)) {
				hql += "and matItem = '" + matItem + "'";
			}
			if (matName != null && !"".equals(matName)) {
				hql += "and matName like '%" + matName + "%'";
			}
			if (specCode != null && !"".equals(specCode)) {
				hql += "and specCode like '%" + specCode + "%'";
			}
			if (prodType != null && !"".equals(prodType)) {
				hql += "and prodType like '%" + prodType + "%'";
			}
		}
		List<Tbdm21> list = (List<Tbdm21>) this.query(hql, null,page.getPageNo(), page.getPageSize());
		page.setEntities(list);
		page.setEntityCount(this.query(hql).size());
	}
	
	@SuppressWarnings("unchecked")
	@DataResolver
	@Transactional(rollbackFor = Exception.class)
	public String saveTbdm21(Collection<Tbdm21> collection) {
		try {
			for (Tbdm21 tbdm21 : collection) {
				EntityState entityState = EntityUtils.getState(tbdm21);
				tbdm21.setCompId("Knowledge");
				String sql = "SELECT MAX(CAST(SER_NO_ AS INT)) FROM TBDM21 WHERE COMP_ID_ = '" + tbdm21.getCompId() + "'" +
							 " AND MAT_NO_ = '" + tbdm21.getMatNo() + "' AND MAT_ITEM_ = '" + tbdm21.getMatItem() + "'";
				String hql = "from Tbdm21 where 1=1 and matNo = '"+ tbdm21.getMatNo() + "' and matItem = '" + tbdm21.getMatItem() + "'" +
						" and compId = '" + tbdm21.getCompId() + "' and specCode = '" + tbdm21.getSpecCode() + "' and prodType = '" + tbdm21.getProdType() + "'";
				if(entityState.equals(EntityState.NEW)){				
					if (this.query(hql).size() == 0) {
					List result = this.getSession().createSQLQuery(sql).list();
						if(result.get(0) != null){
							Integer num =  Integer.parseInt(result.get(0).toString()) + 1;
							tbdm21.setSerNo(String.format("%04d", num));
						}else{
							tbdm21.setSerNo("0000");
						}	
						this.getSession().save(tbdm21);
						return null;
					}else{
						throw new RuntimeException("数据库已存在该记录");
					}
				}else if(entityState.equals(EntityState.DELETED)){
					this.getSession().delete(tbdm21);
				}else if(entityState.equals(EntityState.MODIFIED)){
					this.getSession().update(tbdm21);
				}
			}
		} catch (RuntimeException e) {
			return e.getMessage();
		}
		return null;
	}

}
