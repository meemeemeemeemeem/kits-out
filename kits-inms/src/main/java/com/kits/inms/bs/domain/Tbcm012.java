package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBCM012:客户银行档
 */
@Entity
@Table(name = "TBCM012")
public class Tbcm012 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * PK_CM012_:
	 */
	@PropertyDef(label = "PK_CM012_", description = "PK_CM012_:")
	private String pkCm012;

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
	 * BANK_NO_:
	 */
	@PropertyDef(label = "BANK_NO_", description = "BANK_NO_:")
	private String bankNo;

	/**
	 * VERSION_:
	 */
	@PropertyDef(label = "VERSION_", description = "VERSION_:")
	private String version;

	/**
	 * BANK_HEAD_NO_:
	 */
	@PropertyDef(label = "BANK_HEAD_NO_", description = "BANK_HEAD_NO_:")
	private String bankHeadNo;

	/**
	 * BANK_HOUSE_NO_:
	 */
	@PropertyDef(label = "BANK_HOUSE_NO_", description = "BANK_HOUSE_NO_:")
	private String bankHouseNo;

	/**
	 * BANK_NAME_:
	 */
	@PropertyDef(label = "BANK_NAME_", description = "BANK_NAME_:")
	private String bankName;

	/**
	 * BANK_ACCOUNT_:
	 */
	@PropertyDef(label = "BANK_ACCOUNT_", description = "BANK_ACCOUNT_:")
	private String bankAccount;

	/**
	 * CREATE_EMP_:
	 */
	@PropertyDef(label = "CREATE_EMP_", description = "CREATE_EMP_:")
	private String createEmp;

	/**
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private Date createDate;

	/**
	 * UPD_EMP_:
	 */
	@PropertyDef(label = "UPD_EMP_", description = "UPD_EMP_:")
	private String updEmp;

	/**
	 * UPD_DATE_:
	 */
	@PropertyDef(label = "UPD_DATE_", description = "UPD_DATE_:")
	private Date updDate;

	/**
	 * VERSION_STUS_:
	 */
	@PropertyDef(label = "VERSION_STUS_", description = "VERSION_STUS_:")
	private String versionStus;

	/**
	 * DEFS01_:
	 */
	@PropertyDef(label = "DEFS01_", description = "DEFS01_:")
	private String defs01;

	/**
	 * DEFS02_:
	 */
	@PropertyDef(label = "DEFS02_", description = "DEFS02_:")
	private String defs02;

	/**
	 * DEFS03_:
	 */
	@PropertyDef(label = "DEFS03_", description = "DEFS03_:")
	private String defs03;

	/**
	 * DEFS04_:
	 */
	@PropertyDef(label = "DEFS04_", description = "DEFS04_:")
	private String defs04;

	/**
	 * DEFS05_:
	 */
	@PropertyDef(label = "DEFS05_", description = "DEFS05_:")
	private String defs05;

	/**
	 * DEFB01_:
	 */
	@PropertyDef(label = "DEFB01_", description = "DEFB01_:")
	private BigDecimal defb01;

	/**
	 * DEFB02_:
	 */
	@PropertyDef(label = "DEFB02_", description = "DEFB02_:")
	private BigDecimal defb02;

	/**
	 * DEFB03_:
	 */
	@PropertyDef(label = "DEFB03_", description = "DEFB03_:")
	private BigDecimal defb03;

	/**
	 * DEFB04_:
	 */
	@PropertyDef(label = "DEFB04_", description = "DEFB04_:")
	private BigDecimal defb04;

	/**
	 * DEFB05_:
	 */
	@PropertyDef(label = "DEFB05_", description = "DEFB05_:")
	private BigDecimal defb05;

	/**
	 * DEFM01_:
	 */
	@PropertyDef(label = "DEFM01_", description = "DEFM01_:")
	private String defm01;

	/**
	 * DEFM02_:
	 */
	@PropertyDef(label = "DEFM02_", description = "DEFM02_:")
	private String defm02;

	/**
	 * 银行户名:银行户名
	 */
	@PropertyDef(label = "银行户名", description = "银行户名:银行户名")
	private String accountId;

	public Tbcm012() {
		super();
	}

	public Tbcm012(String pkCm012, String compId, String custNo, String bankNo,
			String version, String bankHeadNo, String bankHouseNo,
			String bankName, String bankAccount, String createEmp,
			Date createDate, String updEmp, Date updDate, String versionStus,
			String defs01, String defs02, String defs03, String defs04,
			String defs05, BigDecimal defb01, BigDecimal defb02,
			BigDecimal defb03, BigDecimal defb04, BigDecimal defb05,
			String defm01, String defm02, String accountId) {
		super();
		this.pkCm012 = pkCm012;
		this.compId = compId;
		this.custNo = custNo;
		this.bankNo = bankNo;
		this.version = version;
		this.bankHeadNo = bankHeadNo;
		this.bankHouseNo = bankHouseNo;
		this.bankName = bankName;
		this.bankAccount = bankAccount;
		this.createEmp = createEmp;
		this.createDate = createDate;
		this.updEmp = updEmp;
		this.updDate = updDate;
		this.versionStus = versionStus;
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
		this.accountId = accountId;
	}

	public void setPkCm012(String pkCm012) {
		this.pkCm012 = pkCm012;
	}

	@Id
	@Column(name = "PK_CM012_", length = 40, nullable = false)
	public String getPkCm012() {
		return pkCm012;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 10)
	public String getCompId() {
		return compId;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	@Column(name = "CUST_NO_", length = 30)
	public String getCustNo() {
		return custNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	@Column(name = "BANK_NO_", length = 15)
	public String getBankNo() {
		return bankNo;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "VERSION_", length = 5)
	public String getVersion() {
		return version;
	}

	public void setBankHeadNo(String bankHeadNo) {
		this.bankHeadNo = bankHeadNo;
	}

	@Column(name = "BANK_HEAD_NO_", length = 5)
	public String getBankHeadNo() {
		return bankHeadNo;
	}

	public void setBankHouseNo(String bankHouseNo) {
		this.bankHouseNo = bankHouseNo;
	}

	@Column(name = "BANK_HOUSE_NO_", length = 100)
	public String getBankHouseNo() {
		return bankHouseNo;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "BANK_NAME_", length = 100)
	public String getBankName() {
		return bankName;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Column(name = "BANK_ACCOUNT_", length = 40)
	public String getBankAccount() {
		return bankAccount;
	}

	public void setCreateEmp(String createEmp) {
		this.createEmp = createEmp;
	}

	@Column(name = "CREATE_EMP_", length = 20)
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

	public void setUpdEmp(String updEmp) {
		this.updEmp = updEmp;
	}

	@Column(name = "UPD_EMP_", length = 20)
	public String getUpdEmp() {
		return updEmp;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPD_DATE_")
	public Date getUpdDate() {
		return updDate;
	}

	public void setVersionStus(String versionStus) {
		this.versionStus = versionStus;
	}

	@Column(name = "VERSION_STUS_", length = 1)
	public String getVersionStus() {
		return versionStus;
	}

	public void setDefs01(String defs01) {
		this.defs01 = defs01;
	}

	@Column(name = "DEFS01_", length = 20)
	public String getDefs01() {
		return defs01;
	}

	public void setDefs02(String defs02) {
		this.defs02 = defs02;
	}

	@Column(name = "DEFS02_", length = 20)
	public String getDefs02() {
		return defs02;
	}

	public void setDefs03(String defs03) {
		this.defs03 = defs03;
	}

	@Column(name = "DEFS03_", length = 20)
	public String getDefs03() {
		return defs03;
	}

	public void setDefs04(String defs04) {
		this.defs04 = defs04;
	}

	@Column(name = "DEFS04_", length = 20)
	public String getDefs04() {
		return defs04;
	}

	public void setDefs05(String defs05) {
		this.defs05 = defs05;
	}

	@Column(name = "DEFS05_", length = 20)
	public String getDefs05() {
		return defs05;
	}

	public void setDefb01(BigDecimal defb01) {
		this.defb01 = defb01;
	}

	@Column(name = "DEFB01_")
	public BigDecimal getDefb01() {
		return defb01;
	}

	public void setDefb02(BigDecimal defb02) {
		this.defb02 = defb02;
	}

	@Column(name = "DEFB02_")
	public BigDecimal getDefb02() {
		return defb02;
	}

	public void setDefb03(BigDecimal defb03) {
		this.defb03 = defb03;
	}

	@Column(name = "DEFB03_")
	public BigDecimal getDefb03() {
		return defb03;
	}

	public void setDefb04(BigDecimal defb04) {
		this.defb04 = defb04;
	}

	@Column(name = "DEFB04_")
	public BigDecimal getDefb04() {
		return defb04;
	}

	public void setDefb05(BigDecimal defb05) {
		this.defb05 = defb05;
	}

	@Column(name = "DEFB05_")
	public BigDecimal getDefb05() {
		return defb05;
	}

	public void setDefm01(String defm01) {
		this.defm01 = defm01;
	}

	@Column(name = "DEFM01_", length = 200)
	public String getDefm01() {
		return defm01;
	}

	public void setDefm02(String defm02) {
		this.defm02 = defm02;
	}

	@Column(name = "DEFM02_", length = 200)
	public String getDefm02() {
		return defm02;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "ACCOUNT_ID_", length = 100)
	public String getAccountId() {
		return accountId;
	}

	public String toString() {
		return "Tbcm012 [pkCm012=" + pkCm012 + ",compId=" + compId + ",custNo="
				+ custNo + ",bankNo=" + bankNo + ",version=" + version
				+ ",bankHeadNo=" + bankHeadNo + ",bankHouseNo=" + bankHouseNo
				+ ",bankName=" + bankName + ",bankAccount=" + bankAccount
				+ ",createEmp=" + createEmp + ",createDate=" + createDate
				+ ",updEmp=" + updEmp + ",updDate=" + updDate + ",versionStus="
				+ versionStus + ",defs01=" + defs01 + ",defs02=" + defs02
				+ ",defs03=" + defs03 + ",defs04=" + defs04 + ",defs05="
				+ defs05 + ",defb01=" + defb01 + ",defb02=" + defb02
				+ ",defb03=" + defb03 + ",defb04=" + defb04 + ",defb05="
				+ defb05 + ",defm01=" + defm01 + ",defm02=" + defm02
				+ ",accountId=" + accountId + "]";
	}

}
