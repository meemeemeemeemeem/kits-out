package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBBS016:客商工商信息表
 */
@Entity
@Table(name = "TBBS016")
public class Tbbs016 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * PK_BS016_:
	 */
	@PropertyDef(label = "PK_BS016_", description = "PK_BS016_:")
	private String pkBs016;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;

	/**
	 * CUST_NO_:
	 */
	@PropertyDef(label = "CUST_NO_", description = "CUST_NO_:")
	private String custNo;

	/**
	 * CUST_NAME_:
	 */
	@PropertyDef(label = "CUST_NAME_", description = "CUST_NAME_:")
	private String custName;

	/**
	 * INDUSTRY_CODE_:
	 */
	@PropertyDef(label = "INDUSTRY_CODE_", description = "INDUSTRY_CODE_:")
	private String industryCode;

	/**
	 * ORG_CODE_:
	 */
	@PropertyDef(label = "ORG_CODE_", description = "ORG_CODE_:")
	private String orgCode;

	/**
	 * CREDIT_CODE_:
	 */
	@PropertyDef(label = "CREDIT_CODE_", description = "CREDIT_CODE_:")
	private String creditCode;

	/**
	 * TAX_NUMBER_:
	 */
	@PropertyDef(label = "TAX_NUMBER_", description = "TAX_NUMBER_:")
	private String taxNumber;

	/**
	 * COMP_TYPE_:
	 */
	@PropertyDef(label = "COMP_TYPE_", description = "COMP_TYPE_:")
	private String compType;

	/**
	 * INDUSTRY_:
	 */
	@PropertyDef(label = "INDUSTRY_", description = "INDUSTRY_:")
	private String industry;

	/**
	 * MANAGE_TERM_:
	 */
	@PropertyDef(label = "MANAGE_TERM_", description = "MANAGE_TERM_:")
	private String manageTerm;

	/**
	 * APPRO_DATE_:
	 */
	@PropertyDef(label = "APPRO_DATE_", description = "APPRO_DATE_:")
	private Date approDate;

	/**
	 * REGIS_AUTH_:
	 */
	@PropertyDef(label = "REGIS_AUTH_", description = "REGIS_AUTH_:")
	private String regisAuth;

	/**
	 * ENG_NAME_:
	 */
	@PropertyDef(label = "ENG_NAME_", description = "ENG_NAME_:")
	private String engName;

	/**
	 * OPERATE_SCOPE_:
	 */
	@PropertyDef(label = "OPERATE_SCOPE_", description = "OPERATE_SCOPE_:")
	private String operateScope;

	/**
	 * REGISTER_ADDR_:
	 */
	@PropertyDef(label = "REGISTER_ADDR_", description = "REGISTER_ADDR_:")
	private String registerAddr;

	/**
	 * MEMO_:
	 */
	@PropertyDef(label = "MEMO_", description = "MEMO_:")
	private String memo;

	/**
	 * 创建人员:创建人员
	 */
	@PropertyDef(label = "创建人员", description = "创建人员:创建人员")
	private String createEmp;

	/**
	 * 创建日期:创建日期
	 */
	@PropertyDef(label = "创建日期", description = "创建日期:创建日期")
	private Date createDate;

	/**
	 * 修改人员:修改人员
	 */
	@PropertyDef(label = "修改人员", description = "修改人员:修改人员")
	private String modifyEmp;

	/**
	 * 修改日期:修改日期
	 */
	@PropertyDef(label = "修改日期", description = "修改日期:修改日期")
	private Date modifyDate;

	/**
	 * DEFS01:
	 */
	@PropertyDef(label = "DEFS01", description = "DEFS01:")
	private String defs01;

	/**
	 * DEFS02:
	 */
	@PropertyDef(label = "DEFS02", description = "DEFS02:")
	private String defs02;

	/**
	 * DEFS03:
	 */
	@PropertyDef(label = "DEFS03", description = "DEFS03:")
	private String defs03;

	/**
	 * DEFS04:
	 */
	@PropertyDef(label = "DEFS04", description = "DEFS04:")
	private String defs04;

	/**
	 * DEFS05:
	 */
	@PropertyDef(label = "DEFS05", description = "DEFS05:")
	private String defs05;

	/**
	 * DEFB01:
	 */
	@PropertyDef(label = "DEFB01", description = "DEFB01:")
	private BigDecimal defb01;

	/**
	 * DEFB02:
	 */
	@PropertyDef(label = "DEFB02", description = "DEFB02:")
	private BigDecimal defb02;

	/**
	 * DEFB03:
	 */
	@PropertyDef(label = "DEFB03", description = "DEFB03:")
	private BigDecimal defb03;

	/**
	 * DEFB04:
	 */
	@PropertyDef(label = "DEFB04", description = "DEFB04:")
	private BigDecimal defb04;

	/**
	 * DEFB05:
	 */
	@PropertyDef(label = "DEFB05", description = "DEFB05:")
	private BigDecimal defb05;

	/**
	 * DEFM01:
	 */
	@PropertyDef(label = "DEFM01", description = "DEFM01:")
	private String defm01;

	/**
	 * DEFM02:
	 */
	@PropertyDef(label = "DEFM02", description = "DEFM02:")
	private String defm02;

	public Tbbs016() {
		super();
	}

	public Tbbs016(String pkBs016, String compId, String custNo,
			String custName, String industryCode, String orgCode,
			String creditCode, String taxNumber, String compType,
			String industry, String manageTerm, Date approDate,
			String regisAuth, String engName, String operateScope,
			String registerAddr, String memo, String createEmp,
			Date createDate, String modifyEmp, Date modifyDate, String defs01,
			String defs02, String defs03, String defs04, String defs05,
			BigDecimal defb01, BigDecimal defb02, BigDecimal defb03,
			BigDecimal defb04, BigDecimal defb05, String defm01, String defm02) {
		super();
		this.pkBs016 = pkBs016;
		this.compId = compId;
		this.custNo = custNo;
		this.custName = custName;
		this.industryCode = industryCode;
		this.orgCode = orgCode;
		this.creditCode = creditCode;
		this.taxNumber = taxNumber;
		this.compType = compType;
		this.industry = industry;
		this.manageTerm = manageTerm;
		this.approDate = approDate;
		this.regisAuth = regisAuth;
		this.engName = engName;
		this.operateScope = operateScope;
		this.registerAddr = registerAddr;
		this.memo = memo;
		this.createEmp = createEmp;
		this.createDate = createDate;
		this.modifyEmp = modifyEmp;
		this.modifyDate = modifyDate;
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

	public void setPkBs016(String pkBs016) {
		this.pkBs016 = pkBs016;
	}

	@Id
	@Column(name = "PK_BS016_", length = 40, nullable = false)
	public String getPkBs016() {
		return pkBs016;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 40)
	public String getCompId() {
		return compId;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	@Column(name = "CUST_NO_", length = 40)
	public String getCustNo() {
		return custNo;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "CUST_NAME_", length = 40)
	public String getCustName() {
		return custName;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	@Column(name = "INDUSTRY_CODE_", length = 40)
	public String getIndustryCode() {
		return industryCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "ORG_CODE_", length = 40)
	public String getOrgCode() {
		return orgCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	@Column(name = "CREDIT_CODE_", length = 40)
	public String getCreditCode() {
		return creditCode;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	@Column(name = "TAX_NUMBER_", length = 40)
	public String getTaxNumber() {
		return taxNumber;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	@Column(name = "COMP_TYPE_", length = 40)
	public String getCompType() {
		return compType;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "INDUSTRY_", length = 40)
	public String getIndustry() {
		return industry;
	}

	public void setManageTerm(String manageTerm) {
		this.manageTerm = manageTerm;
	}

	@Column(name = "MANAGE_TERM_", length = 40)
	public String getManageTerm() {
		return manageTerm;
	}

	public void setApproDate(Date approDate) {
		this.approDate = approDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPRO_DATE_")
	public Date getApproDate() {
		return approDate;
	}

	public void setRegisAuth(String regisAuth) {
		this.regisAuth = regisAuth;
	}

	@Column(name = "REGIS_AUTH_", length = 40)
	public String getRegisAuth() {
		return regisAuth;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	@Column(name = "ENG_NAME_", length = 40)
	public String getEngName() {
		return engName;
	}

	public void setOperateScope(String operateScope) {
		this.operateScope = operateScope;
	}

	@Column(name = "OPERATE_SCOPE_", length = 400)
	public String getOperateScope() {
		return operateScope;
	}

	public void setRegisterAddr(String registerAddr) {
		this.registerAddr = registerAddr;
	}

	@Column(name = "REGISTER_ADDR_", length = 200)
	public String getRegisterAddr() {
		return registerAddr;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "MEMO_", length = 100)
	public String getMemo() {
		return memo;
	}

	public void setCreateEmp(String createEmp) {
		this.createEmp = createEmp;
	}

	@Column(name = "CREATE_EMP_", length = 40)
	public String getCreateEmp() {
		return createEmp;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setModifyEmp(String modifyEmp) {
		this.modifyEmp = modifyEmp;
	}

	@Column(name = "MODIFY_EMP_", length = 40)
	public String getModifyEmp() {
		return modifyEmp;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE_")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setDefs01(String defs01) {
		this.defs01 = defs01;
	}

	@Column(name = "DEFS01", length = 40)
	public String getDefs01() {
		return defs01;
	}

	public void setDefs02(String defs02) {
		this.defs02 = defs02;
	}

	@Column(name = "DEFS02", length = 40)
	public String getDefs02() {
		return defs02;
	}

	public void setDefs03(String defs03) {
		this.defs03 = defs03;
	}

	@Column(name = "DEFS03", length = 40)
	public String getDefs03() {
		return defs03;
	}

	public void setDefs04(String defs04) {
		this.defs04 = defs04;
	}

	@Column(name = "DEFS04", length = 40)
	public String getDefs04() {
		return defs04;
	}

	public void setDefs05(String defs05) {
		this.defs05 = defs05;
	}

	@Column(name = "DEFS05", length = 40)
	public String getDefs05() {
		return defs05;
	}

	public void setDefb01(BigDecimal defb01) {
		this.defb01 = defb01;
	}

	@Column(name = "DEFB01")
	public BigDecimal getDefb01() {
		return defb01;
	}

	public void setDefb02(BigDecimal defb02) {
		this.defb02 = defb02;
	}

	@Column(name = "DEFB02")
	public BigDecimal getDefb02() {
		return defb02;
	}

	public void setDefb03(BigDecimal defb03) {
		this.defb03 = defb03;
	}

	@Column(name = "DEFB03")
	public BigDecimal getDefb03() {
		return defb03;
	}

	public void setDefb04(BigDecimal defb04) {
		this.defb04 = defb04;
	}

	@Column(name = "DEFB04")
	public BigDecimal getDefb04() {
		return defb04;
	}

	public void setDefb05(BigDecimal defb05) {
		this.defb05 = defb05;
	}

	@Column(name = "DEFB05")
	public BigDecimal getDefb05() {
		return defb05;
	}

	public void setDefm01(String defm01) {
		this.defm01 = defm01;
	}

	@Column(name = "DEFM01", length = 200)
	public String getDefm01() {
		return defm01;
	}

	public void setDefm02(String defm02) {
		this.defm02 = defm02;
	}

	@Column(name = "DEFM02", length = 200)
	public String getDefm02() {
		return defm02;
	}

	public String toString() {
		return "Tbbs016 [pkBs016=" + pkBs016 + ",compId=" + compId + ",custNo="
				+ custNo + ",custName=" + custName + ",industryCode="
				+ industryCode + ",orgCode=" + orgCode + ",creditCode="
				+ creditCode + ",taxNumber=" + taxNumber + ",compType="
				+ compType + ",industry=" + industry + ",manageTerm="
				+ manageTerm + ",approDate=" + approDate + ",regisAuth="
				+ regisAuth + ",engName=" + engName + ",operateScope="
				+ operateScope + ",registerAddr=" + registerAddr + ",memo="
				+ memo + ",createEmp=" + createEmp + ",createDate="
				+ createDate + ",modifyEmp=" + modifyEmp + ",modifyDate="
				+ modifyDate + ",defs01=" + defs01 + ",defs02=" + defs02
				+ ",defs03=" + defs03 + ",defs04=" + defs04 + ",defs05="
				+ defs05 + ",defb01=" + defb01 + ",defb02=" + defb02
				+ ",defb03=" + defb03 + ",defb04=" + defb04 + ",defb05="
				+ defb05 + ",defm01=" + defm01 + ",defm02=" + defm02 + "]";
	}

}
