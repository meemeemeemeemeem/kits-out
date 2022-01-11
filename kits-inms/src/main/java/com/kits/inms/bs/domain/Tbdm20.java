package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBDM20:钢种规格
 */
@Entity
@Table(name = "TBDM20")
public class Tbdm20 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * UUID:UUID
	 */
	@PropertyDef(label = "UUID", description = "UUID:UUID")
	private String pkDm02;

	/**
	 * 公司别:公司别
	 */
	@PropertyDef(label = "公司别", description = "公司别:公司别")
	private String compId;

	/**
	 * 钢种代号:钢种代号
	 */
	@PropertyDef(label = "钢种代号", description = "钢种代号:钢种代号")
	private String matNo;

	/**
	 * 代码:代码
	 */
	@PropertyDef(label = "代码", description = "代码:代码")
	private String matItem;

	/**
	 * 钢种名称:钢种名称
	 */
	@PropertyDef(label = "钢种名称", description = "钢种名称:钢种名称")
	private String matName;

	/**
	 * 分类简称:分类简称
	 */
	@PropertyDef(label = "分类简称", description = "分类简称:分类简称")
	private String matAbbrevName;

	/**
	 * 会计科目区分:会计科目区分
	 */
	@PropertyDef(label = "会计科目区分", description = "会计科目区分:会计科目区分")
	private String accClassify;

	/**
	 * 结案条件:结案条件
	 */
	@PropertyDef(label = "结案条件", description = "结案条件:结案条件")
	private String closeCond;

	/**
	 * 新增人员:新增人员
	 */
	@PropertyDef(label = "新增人员", description = "新增人员:新增人员")
	private String creEmpNo;

	/**
	 * 新增日期:新增日期
	 */
	@PropertyDef(label = "新增日期", description = "新增日期:新增日期")
	private Date creDate;

	/**
	 * 修改人员:修改人员
	 */
	@PropertyDef(label = "修改人员", description = "修改人员:修改人员")
	private String modifyEmpNo;

	/**
	 * 修改日期:修改日期
	 */
	@PropertyDef(label = "修改日期", description = "修改日期:修改日期")
	private Date modifyDate;

	/**
	 * 状态:状态
	 */
	@PropertyDef(label = "状态", description = "状态:状态")
	private String status;

	/**
	 * 产品种类:产品种类
	 */
	@PropertyDef(label = "产品种类", description = "产品种类:产品种类")
	private String prodKind;

	/**
	 * 钢种英文名称:钢种英文名称
	 */
	@PropertyDef(label = "钢种英文名称", description = "钢种英文名称:钢种英文名称")
	private String matEngName;

	/**
	 * 钢种中文名称:钢种中文名称
	 */
	@PropertyDef(label = "钢种中文名称", description = "钢种中文名称:钢种中文名称")
	private String matBigName;

	/**
	 * 自定义字符1:自定义字符1
	 */
	@PropertyDef(label = "自定义字符1", description = "自定义字符1:自定义字符1")
	private String defs01;

	/**
	 * 自定义字符2:自定义字符2
	 */
	@PropertyDef(label = "自定义字符2", description = "自定义字符2:自定义字符2")
	private String defs02;

	/**
	 * 自定义字符3:自定义字符3
	 */
	@PropertyDef(label = "自定义字符3", description = "自定义字符3:自定义字符3")
	private String defs03;

	/**
	 * 自定义字符4:自定义字符4
	 */
	@PropertyDef(label = "自定义字符4", description = "自定义字符4:自定义字符4")
	private String defs04;

	/**
	 * 自定义字符5:自定义字符5
	 */
	@PropertyDef(label = "自定义字符5", description = "自定义字符5:自定义字符5")
	private String defs05;

	/**
	 * 自定义数值1:自定义数值1
	 */
	@PropertyDef(label = "自定义数值1", description = "自定义数值1:自定义数值1")
	private BigDecimal defb01;

	/**
	 * 自定义数值2:自定义数值2
	 */
	@PropertyDef(label = "自定义数值2", description = "自定义数值2:自定义数值2")
	private BigDecimal defb02;

	/**
	 * 自定义数值3:自定义数值3
	 */
	@PropertyDef(label = "自定义数值3", description = "自定义数值3:自定义数值3")
	private BigDecimal defb03;

	/**
	 * 自定义数值4:自定义数值4
	 */
	@PropertyDef(label = "自定义数值4", description = "自定义数值4:自定义数值4")
	private BigDecimal defb04;

	/**
	 * 自定义数值5:自定义数值5
	 */
	@PropertyDef(label = "自定义数值5", description = "自定义数值5:自定义数值5")
	private BigDecimal defb05;

	/**
	 * 自定义备注1:自定义备注1
	 */
	@PropertyDef(label = "自定义备注1", description = "自定义备注1:自定义备注1")
	private String defm01;

	/**
	 * 自定义备注2:自定义备注2
	 */
	@PropertyDef(label = "自定义备注2", description = "自定义备注2:自定义备注2")
	private String defm02;

	public Tbdm20() {
		super();
	}

	public Tbdm20(String pkDm02, String compId, String matNo, String matItem,
			String matName, String matAbbrevName, String accClassify,
			String closeCond, String creEmpNo, Date creDate,
			String modifyEmpNo, Date modifyDate, String status,
			String prodKind, String matEngName, String matBigName,
			String defs01, String defs02, String defs03, String defs04,
			String defs05, BigDecimal defb01, BigDecimal defb02,
			BigDecimal defb03, BigDecimal defb04, BigDecimal defb05,
			String defm01, String defm02) {
		super();
		this.pkDm02 = pkDm02;
		this.compId = compId;
		this.matNo = matNo;
		this.matItem = matItem;
		this.matName = matName;
		this.matAbbrevName = matAbbrevName;
		this.accClassify = accClassify;
		this.closeCond = closeCond;
		this.creEmpNo = creEmpNo;
		this.creDate = creDate;
		this.modifyEmpNo = modifyEmpNo;
		this.modifyDate = modifyDate;
		this.status = status;
		this.prodKind = prodKind;
		this.matEngName = matEngName;
		this.matBigName = matBigName;
		this.defs01 = defs01;
		this.defs02 = defs02;
		this.defs03 = defs03;
		this.defs04 = defs04;
		this.defs05 = defs05;
		this.defb01 = defb01;
		this.defb02 = defb02;
		this.defb03 = defb03;
		this.defb04 = defb04;
		this.defb05 = defb05;
		this.defm01 = defm01;
		this.defm02 = defm02;
	}

	public void setPkDm02(String pkDm02) {
		this.pkDm02 = pkDm02;
	}

	@Id
	@Column(name = "PK_DM02_", length = 40, nullable = false)
	public String getPkDm02() {
		return pkDm02;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 10)
	public String getCompId() {
		return compId;
	}

	public void setMatNo(String matNo) {
		this.matNo = matNo;
	}

	@Column(name = "MAT_NO_", length = 5)
	public String getMatNo() {
		return matNo;
	}

	public void setMatItem(String matItem) {
		this.matItem = matItem;
	}

	@Column(name = "MAT_ITEM_", length = 2)
	public String getMatItem() {
		return matItem;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	@Column(name = "MAT_NAME_", length = 30)
	public String getMatName() {
		return matName;
	}

	public void setMatAbbrevName(String matAbbrevName) {
		this.matAbbrevName = matAbbrevName;
	}

	@Column(name = "MAT_ABBREV_NAME_", length = 90)
	public String getMatAbbrevName() {
		return matAbbrevName;
	}

	public void setAccClassify(String accClassify) {
		this.accClassify = accClassify;
	}

	@Column(name = "ACC_CLASSIFY_", length = 1)
	public String getAccClassify() {
		return accClassify;
	}

	public void setCloseCond(String closeCond) {
		this.closeCond = closeCond;
	}

	@Column(name = "CLOSE_COND_", length = 1)
	public String getCloseCond() {
		return closeCond;
	}

	public void setCreEmpNo(String creEmpNo) {
		this.creEmpNo = creEmpNo;
	}

	@Column(name = "CRE_EMP_NO_", length = 20)
	public String getCreEmpNo() {
		return creEmpNo;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRE_DATE_")
	public Date getCreDate() {
		return creDate;
	}

	public void setModifyEmpNo(String modifyEmpNo) {
		this.modifyEmpNo = modifyEmpNo;
	}

	@Column(name = "MODIFY_EMP_NO_", length = 20)
	public String getModifyEmpNo() {
		return modifyEmpNo;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE_")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS_", length = 1)
	public String getStatus() {
		return status;
	}

	public void setProdKind(String prodKind) {
		this.prodKind = prodKind;
	}

	@Column(name = "PROD_KIND_", length = 1)
	public String getProdKind() {
		return prodKind;
	}

	public void setMatEngName(String matEngName) {
		this.matEngName = matEngName;
	}

	@Column(name = "MAT_ENG_NAME_", length = 100)
	public String getMatEngName() {
		return matEngName;
	}

	public void setMatBigName(String matBigName) {
		this.matBigName = matBigName;
	}

	@Column(name = "MAT_BIG_NAME_", length = 100)
	public String getMatBigName() {
		return matBigName;
	}

	public void setDefs01(String defs01) {
		this.defs01 = defs01;
	}

	@Column(name = "DEFS_01_", length = 20)
	public String getDefs01() {
		return defs01;
	}

	public void setDefs02(String defs02) {
		this.defs02 = defs02;
	}

	@Column(name = "DEFS_02_", length = 20)
	public String getDefs02() {
		return defs02;
	}

	public void setDefs03(String defs03) {
		this.defs03 = defs03;
	}

	@Column(name = "DEFS_03_", length = 20)
	public String getDefs03() {
		return defs03;
	}

	public void setDefs04(String defs04) {
		this.defs04 = defs04;
	}

	@Column(name = "DEFS_04_", length = 20)
	public String getDefs04() {
		return defs04;
	}

	public void setDefs05(String defs05) {
		this.defs05 = defs05;
	}

	@Column(name = "DEFS_05_", length = 20)
	public String getDefs05() {
		return defs05;
	}

	public void setDefb01(BigDecimal defb01) {
		this.defb01 = defb01;
	}

	@Column(name = "DEFB_01_")
	public BigDecimal getDefb01() {
		return defb01;
	}

	public void setDefb02(BigDecimal defb02) {
		this.defb02 = defb02;
	}

	@Column(name = "DEFB_02_")
	public BigDecimal getDefb02() {
		return defb02;
	}

	public void setDefb03(BigDecimal defb03) {
		this.defb03 = defb03;
	}

	@Column(name = "DEFB_03_")
	public BigDecimal getDefb03() {
		return defb03;
	}

	public void setDefb04(BigDecimal defb04) {
		this.defb04 = defb04;
	}

	@Column(name = "DEFB_04_")
	public BigDecimal getDefb04() {
		return defb04;
	}

	public void setDefb05(BigDecimal defb05) {
		this.defb05 = defb05;
	}

	@Column(name = "DEFB_05_")
	public BigDecimal getDefb05() {
		return defb05;
	}

	public void setDefm01(String defm01) {
		this.defm01 = defm01;
	}

	@Column(name = "DEFM_01_", length = 200)
	public String getDefm01() {
		return defm01;
	}

	public void setDefm02(String defm02) {
		this.defm02 = defm02;
	}

	@Column(name = "DEFM_02_", length = 200)
	public String getDefm02() {
		return defm02;
	}

	public String toString() {
		return "Tbdm20 [pkDm02=" + pkDm02 + ",compId=" + compId + ",matNo="
				+ matNo + ",matItem=" + matItem + ",matName=" + matName
				+ ",matAbbrevName=" + matAbbrevName + ",accClassify="
				+ accClassify + ",closeCond=" + closeCond + ",creEmpNo="
				+ creEmpNo + ",creDate=" + creDate + ",modifyEmpNo="
				+ modifyEmpNo + ",modifyDate=" + modifyDate + ",status="
				+ status + ",prodKind=" + prodKind + ",matEngName="
				+ matEngName + ",matBigName=" + matBigName + ",defs01="
				+ defs01 + ",defs02=" + defs02 + ",defs03=" + defs03
				+ ",defs04=" + defs04 + ",defs05=" + defs05 + ",defb01="
				+ defb01 + ",defb02=" + defb02 + ",defb03=" + defb03
				+ ",defb04=" + defb04 + ",defb05=" + defb05 + ",defm01="
				+ defm01 + ",defm02=" + defm02 + "]";
	}

}
