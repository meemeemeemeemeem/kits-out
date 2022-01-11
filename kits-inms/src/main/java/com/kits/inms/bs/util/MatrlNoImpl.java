package com.kits.inms.bs.util;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.kits.inms.bs.bo.Bsjc021BO;
import com.kits.inms.bs.bo.Bsjc02BO;
import com.kits.inms.bs.domain.Tbbs022;
import com.kits.inms.bs.domain.Tbbs023;
import com.kits.inms.bs.domain.Tbdm01;
import com.kits.inms.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Controller
public class MatrlNoImpl extends HibernateDao implements MatrlNoInterface {

	@Autowired
	Bsjc02BO matrlBo;

	@Autowired
	Bsjc021BO matBO;

	/**
	 * 处理料号相关信息
	 */
	@Transactional
	@Override
	public String getMatrlNo(Tbdm01 dm01) {
		try {
			//品名 尺寸 材质 质量 维护
			if(!dm01.getInventoryType().equals("A") && !dm01.getInventoryType().equals("M")&& !dm01.getInventoryType().equals("X")){
				
				String pid = dm01.getBak1();
				if(AppUtils.isNotEmpty(pid)){
					if (AppUtils.isNotEmpty(dm01.getProdeName())) {
						// 品名不为空 品名代码不能为空 通过品名代码 关联 尺寸 材质 质量信息
						// 维护尺寸信息
						String size = dm01.getDefs01();
						if (AppUtils.isNotEmpty(size)) {
							if (AppUtils.isNotEmpty(pid)) {
								Tbbs022 data1 = new Tbbs022();
								data1.setPid(pid);
								data1.setProdeName(size);
								data1.setTyp("01");
								this.getSizeInfo(data1);
							}
						}
						String matNo = null;
						// 维护材质信息
						String mat = dm01.getMaterailName();
						if (AppUtils.isNotEmpty(mat)) {
							if (AppUtils.isNotEmpty(pid)) {
								Tbbs022 data2 = new Tbbs022();
								data2.setPid(pid);
								data2.setProdeName(mat);
								data2.setTyp("02");
								matNo = this.getMatInfo(data2);
							}
						}
						// 维护质量信息
						String quliName = dm01.getDefs03();
						if (AppUtils.isNotEmpty(quliName)) {
							if (AppUtils.isNotEmpty(matNo)) {
								Tbbs023 data3 = new Tbbs023();
								data3.setPid(matNo);
								data3.setProdeName(quliName);
								this.getQualityInfo(data3);
							} 
						}
					}
				}
			}
					
		// 查询料号是否存在，根据料别 外观 生产类别 品名 材质 规格 质量信息 用途
		String sql = "select matrl_no_ from Tbdm01 where INVENTORY_TYPE_='"
					+ dm01.getInventoryType() + "' and APPEARANCE_='"
					+ dm01.getAppearance() + "' and PRODE_CODE_='"
					+ dm01.getProdeCode() + "' and comp_id_='"
					+ AppUtils.getLoginUser().getCompanyId() + "'";

			StringBuffer sb = new StringBuffer(sql);
			// 品名
			if (AppUtils.isNotEmpty(dm01.getProdeName())) {
				sb.append(" and prode_name_='" + dm01.getProdeName() + "'");
			} else {
				sb.append(" and prode_name_ is null");
			}

			// 材质
			if (AppUtils.isNotEmpty(dm01.getMaterailName())) {
				sb.append(" and materail_name_='" + dm01.getMaterailName()
						+ "'");
			} else {
				sb.append(" and materail_name_ is null");
			}
			
			String inventory = dm01.getInventoryType();
			if(!inventory.equals("A") && !inventory.equals("M")&& !inventory.equals("X")){
				
				if(dm01.getDefb01()!=null){
					StringBuffer sb1 = new StringBuffer(dm01.getDefb01().stripTrailingZeros().toPlainString());
					if(dm01.getDefb02()!=null){
						sb.append("*"+dm01.getDefb02().stripTrailingZeros().toPlainString());
					}else{
						sb.append("*"+"W");
					}
					
					if(dm01.getDefb03()!=null){
						sb.append("*"+dm01.getDefb03().stripTrailingZeros().toPlainString());
					}else{
						sb.append("*"+"L");
					}
					
					dm01.setDefn01(sb1.toString());
				}
				
				if(AppUtils.isNotEmpty(dm01.getDefn01())){
					sb.append(" and DEFN01='"+dm01.getDefn01()+"'");
				
				}else{
					//厚
					sb.append(" and DEFN01 is null");
				}
			}else if(inventory.equals("A") || inventory.equals("M") || inventory.equals("X")){
				
				//物料
				if(dm01.getDefn01()!=null && !dm01.getDefn01().equals("")){
					sb.append(" and DEFN01='"+dm01.getDefn01()+"'");
				}else{
					sb.append( " and DEFN01 is null");
				}
			}
			// 用途
			if (AppUtils.isNotEmpty(dm01.getPdType())) {
				sb.append(" and PD_TYPE_='" + dm01.getPdType() + "'");
			} else {
				sb.append(" and PD_TYPE_ is null");
			}

			// 质量信息
			if (AppUtils.isNotEmpty(dm01.getDefs03())) {
				sb.append(" and DEFS03_='" + dm01.getDefs03() + "'");
			} else {
				sb.append(" and DEFS03_ is null");
			}

			// 质量信息
			/*if (AppUtils.isNotEmpty(dm01.getMaterailSrc())) {
				sb.append(" and MATERAIL_SRC_='" + dm01.getMaterailSrc() + "'");
			} else {
				sb.append(" and MATERAIL_SRC_ is null");
			}*/

			List<String> list = this.getSession().createSQLQuery(sb.toString()).list();
			
			if (!list.isEmpty()  && AppUtils.isNotEmpty(list.get(0))) {
				return list.get(0);
			} else {
				// 新增料号
				/**
				 * String inventoryType 料别 String appearance 外观 String prodeCode
				 * 生产类型
				 */
				// 料别
				String inventoryType = dm01.getInventoryType();
				if(!AppUtils.isNotEmpty(inventoryType)){
					throw new RuntimeException("料别为空，不能新增料号！");
				}
				// 外观
				String appearance = dm01.getAppearance();
				if(!AppUtils.isNotEmpty(appearance)){
					throw new RuntimeException("外观为空，不能新增料号！");
				}
				// 生产类型
				String prodeCode = dm01.getProdeCode();
				if(!AppUtils.isNotEmpty(prodeCode)){
					throw new RuntimeException("生产类型为空，不能新增料号！");
				}
				
				// 料号
				String param = inventoryType + appearance + prodeCode;
				String matrlNo1 = param + matrlBo.getMatrlNo(param);
				// 规格
				dm01.setMatrlNo(matrlNo1);
				dm01.setMatrlDesc(matrlBo.makeMatrlDesc(dm01));

				dm01.setCompId(AppUtils.getLoginUser().getCompanyId());
				dm01.setPkDm01(AppUtils.getUUIDKey());
				dm01.setCreateEmp(AppUtils.getLoginUserName());
				dm01.setCreateDate(new Date());
				this.getSession().save(dm01);
				this.getSession().flush();
				/**
				 * 保存料号的同时保存品名材质信息
				 */
				return matrlNo1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取料号失败：" + e.getMessage());
		}
	}

	@Override
	public String getSizeInfo(Tbbs022 bs022) {

		String pid = bs022.getPid();
		String prodeName = bs022.getProdeName();

		String hql = " from Tbbs022 where PID_='" + pid + "' and PRODE_NAME_='"
				+ prodeName + "' and compId='"
				+ AppUtils.getLoginUser().getCompanyId() + "' and TYP_='01'";

		List<Tbbs022> list = this.query(hql);
		if (list.isEmpty()) {
			// 不存在 新增
			this.saveBs022(bs022);
		}
		return null;
	}

	@Override
	public String getMatInfo(Tbbs022 bs022) {

		String pid = bs022.getPid();
		String prodeName = bs022.getProdeName();

		String hql = " from Tbbs022 where PID_='" + pid + "' and PRODE_NAME_='"
				+ prodeName + "' and compId='"
				+ AppUtils.getLoginUser().getCompanyId() + "' and TYP_='02'";

		List<Tbbs022> list = this.query(hql);
		if (list.isEmpty()) {
			// 不存在 新增
			this.saveBs022(bs022);
			return bs022.getProdeNo();
		}
		return list.get(0).getProdeNo();
	}

	@Override
	public String getQualityInfo(Tbbs023 bs023) {
		String pid = bs023.getPid();
		String prodeName = bs023.getProdeName();

		String hql = " from Tbbs023 where PID_='" + pid + "' and PRODE_NAME_='"
				+ prodeName + "' and compId='"
				+ AppUtils.getLoginUser().getCompanyId() + "'";

		List<Tbbs022> list = this.query(hql);
		if (list.isEmpty()) {
			// 不存在 新增
			this.saveBs023(bs023);
		}
		return null;
	}

	/**
	 * 保存 尺寸 材质信息
	 * 
	 * @param data
	 */
	private void saveBs022(Tbbs022 ch01) {

		ch01.setPkBs022(AppUtils.getUUIDKey());
		ch01.setProdeNo(ch01.getPkBs022());
		ch01.setCompId(AppUtils.getLoginUser().getCompanyId());
		ch01.setCreateDate(new Date());
		ch01.setCreateEmp(AppUtils.getLoginUserName());
		this.getSession().save(ch01);
	}

	/**
	 * 保存质量信息
	 * 
	 */
	private void saveBs023(Tbbs023 ch01) {
		ch01.setPkBs023(AppUtils.getUUIDKey());
		ch01.setProdeNo(ch01.getPkBs023());
		ch01.setCompId(AppUtils.getLoginUser().getCompanyId());
		ch01.setCreateDate(new Date());
		ch01.setCreateEmp(AppUtils.getLoginUserName());
		this.getSession().save(ch01);
	}
}
