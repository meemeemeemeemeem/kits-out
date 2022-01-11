package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBCM011:客户基础档
 */
@Entity
@Table(name = "TBCM011")
public class Tbcm011 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * PK_CM011_:
	 */
	@PropertyDef(label = "PK_CM011_", description = "PK_CM011_:")
	private String pkCm011;

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
	 * VERSION_:
	 */
	@PropertyDef(label = "VERSION_", description = "VERSION_:")
	private String version;

	/**
	 * NATIONNALITY_:
	 */
	@PropertyDef(label = "NATIONNALITY_", description = "NATIONNALITY_:")
	private String nationnality;

	/**
	 * CUST_CATEGERY_:
	 */
	@PropertyDef(label = "CUST_CATEGERY_", description = "CUST_CATEGERY_:")
	private String custCategery;

	/**
	 * YONGYOU_CUST_NO_:
	 */
	@PropertyDef(label = "YONGYOU_CUST_NO_", description = "YONGYOU_CUST_NO_:")
	private String yongyouCustNo;

	/**
	 * CUST_NAME_:
	 */
	@PropertyDef(label = "CUST_NAME_", description = "CUST_NAME_:")
	private String custName;

	/**
	 * DUTY_PERSON_:
	 */
	@PropertyDef(label = "DUTY_PERSON_", description = "DUTY_PERSON_:")
	private String dutyPerson;

	/**
	 * ASSOCIATED_:
	 */
	@PropertyDef(label = "ASSOCIATED_", description = "ASSOCIATED_:")
	private String associated;

	/**
	 * ASSO_DATE_:
	 */
	@PropertyDef(label = "ASSO_DATE_", description = "ASSO_DATE_:")
	private Date assoDate;

	/**
	 * COMP_CHIN_:
	 */
	@PropertyDef(label = "COMP_CHIN_", description = "COMP_CHIN_:")
	private String compChin;

	/**
	 * COMP_EMG_:
	 */
	@PropertyDef(label = "COMP_EMG_", description = "COMP_EMG_:")
	private String compEmg;

	/**
	 * REGISTER_AMT_:
	 */
	@PropertyDef(label = "REGISTER_AMT_", description = "REGISTER_AMT_:")
	private BigDecimal registerAmt;

	/**
	 * REG_CNY_:
	 */
	@PropertyDef(label = "REG_CNY_", description = "REG_CNY_:")
	private String regCny;

	/**
	 * TURN_OVER_:
	 */
	@PropertyDef(label = "TURN_OVER_", description = "TURN_OVER_:")
	private BigDecimal turnOver;

	/**
	 * TUR_CNY_:
	 */
	@PropertyDef(label = "TUR_CNY_", description = "TUR_CNY_:")
	private String turCny;

	/**
	 * ZIP_CODE_:
	 */
	@PropertyDef(label = "ZIP_CODE_", description = "ZIP_CODE_:")
	private String zipCode;

	/**
	 * MAIL_ADDRESS_:
	 */
	@PropertyDef(label = "MAIL_ADDRESS_", description = "MAIL_ADDRESS_:")
	private String mailAddress;

	/**
	 * COMP_WEB_:
	 */
	@PropertyDef(label = "COMP_WEB_", description = "COMP_WEB_:")
	private String compWeb;

	/**
	 * LOAD_LINE_:
	 */
	@PropertyDef(label = "LOAD_LINE_", description = "LOAD_LINE_:")
	private String loadLine;

	/**
	 * PHONE_NUMBER_:
	 */
	@PropertyDef(label = "PHONE_NUMBER_", description = "PHONE_NUMBER_:")
	private String phoneNumber;

	/**
	 * FAX_NUMBER_:
	 */
	@PropertyDef(label = "FAX_NUMBER_", description = "FAX_NUMBER_:")
	private String faxNumber;

	/**
	 * EMAIL_:
	 */
	@PropertyDef(label = "EMAIL_", description = "EMAIL_:")
	private String email;

	/**
	 * QQ_:
	 */
	@PropertyDef(label = "QQ_", description = "QQ_:")
	private String qq;

	/**
	 * WE_CHAT_:
	 */
	@PropertyDef(label = "WE_CHAT_", description = "WE_CHAT_:")
	private String weChat;

	/**
	 * FACEBOOK_:
	 */
	@PropertyDef(label = "FACEBOOK_", description = "FACEBOOK_:")
	private String facebook;

	/**
	 * TWITTER_:
	 */
	@PropertyDef(label = "TWITTER_", description = "TWITTER_:")
	private String twitter;

	/**
	 * BLOG_:
	 */
	@PropertyDef(label = "BLOG_", description = "BLOG_:")
	private String blog;

	/**
	 * INVOICE_NAME_:
	 */
	@PropertyDef(label = "INVOICE_NAME_", description = "INVOICE_NAME_:")
	private String invoiceName;

	/**
	 * INVOICE_BANK_:
	 */
	@PropertyDef(label = "INVOICE_BANK_", description = "INVOICE_BANK_:")
	private String invoiceBank;

	/**
	 * ACCOUNT_NO_:
	 */
	@PropertyDef(label = "ACCOUNT_NO_", description = "ACCOUNT_NO_:")
	private String accountNo;

	/**
	 * TAX_NUMBER_:
	 */
	@PropertyDef(label = "TAX_NUMBER_", description = "TAX_NUMBER_:")
	private String taxNumber;

	/**
	 * INVOICE_ADDRESS_:
	 */
	@PropertyDef(label = "INVOICE_ADDRESS_", description = "INVOICE_ADDRESS_:")
	private String invoiceAddress;

	/**
	 * INVOICE_PHONE_:
	 */
	@PropertyDef(label = "INVOICE_PHONE_", description = "INVOICE_PHONE_:")
	private String invoicePhone;

	/**
	 * BELONG_ORG_:
	 */
	@PropertyDef(label = "BELONG_ORG_", description = "BELONG_ORG_:")
	private String belongOrg;

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

	public Tbcm011() {
		super();
	}

	public Tbcm011(String pkCm011, String compId, String custNo,
			String version, String nationnality, String custCategery,
			String yongyouCustNo, String custName, String dutyPerson,
			String associated, Date assoDate, String compChin, String compEmg,
			BigDecimal registerAmt, String regCny, BigDecimal turnOver,
			String turCny, String zipCode, String mailAddress, String compWeb,
			String loadLine, String phoneNumber, String faxNumber,
			String email, String qq, String weChat, String facebook,
			String twitter, String blog, String invoiceName,
			String invoiceBank, String accountNo, String taxNumber,
			String invoiceAddress, String invoicePhone, String belongOrg,
			String createEmp, Date createDate, String updEmp, Date updDate,
			String versionStus, String defs01, String defs02, String defs03,
			String defs04, String defs05, BigDecimal defb01, BigDecimal defb02,
			BigDecimal defb03, BigDecimal defb04, BigDecimal defb05,
			String defm01, String defm02) {
		super();
		this.pkCm011 = pkCm011;
		this.compId = compId;
		this.custNo = custNo;
		this.version = version;
		this.nationnality = nationnality;
		this.custCategery = custCategery;
		this.yongyouCustNo = yongyouCustNo;
		this.custName = custName;
		this.dutyPerson = dutyPerson;
		this.associated = associated;
		this.assoDate = assoDate;
		this.compChin = compChin;
		this.compEmg = compEmg;
		this.registerAmt = registerAmt;
		this.regCny = regCny;
		this.turnOver = turnOver;
		this.turCny = turCny;
		this.zipCode = zipCode;
		this.mailAddress = mailAddress;
		this.compWeb = compWeb;
		this.loadLine = loadLine;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.email = email;
		this.qq = qq;
		this.weChat = weChat;
		this.facebook = facebook;
		this.twitter = twitter;
		this.blog = blog;
		this.invoiceName = invoiceName;
		this.invoiceBank = invoiceBank;
		this.accountNo = accountNo;
		this.taxNumber = taxNumber;
		this.invoiceAddress = invoiceAddress;
		this.invoicePhone = invoicePhone;
		this.belongOrg = belongOrg;
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
	}

	public void setPkCm011(String pkCm011) {
		this.pkCm011 = pkCm011;
	}

	@Id
	@Column(name = "PK_CM011_", length = 40, nullable = false)
	public String getPkCm011() {
		return pkCm011;
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

	@Column(name = "CUST_NO_", length = 20)
	public String getCustNo() {
		return custNo;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "VERSION_", length = 5)
	public String getVersion() {
		return version;
	}

	public void setNationnality(String nationnality) {
		this.nationnality = nationnality;
	}

	@Column(name = "NATIONNALITY_", length = 10)
	public String getNationnality() {
		return nationnality;
	}

	public void setCustCategery(String custCategery) {
		this.custCategery = custCategery;
	}

	@Column(name = "CUST_CATEGERY_", length = 4)
	public String getCustCategery() {
		return custCategery;
	}

	public void setYongyouCustNo(String yongyouCustNo) {
		this.yongyouCustNo = yongyouCustNo;
	}

	@Column(name = "YONGYOU_CUST_NO_", length = 30)
	public String getYongyouCustNo() {
		return yongyouCustNo;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "CUST_NAME_", length = 100)
	public String getCustName() {
		return custName;
	}

	public void setDutyPerson(String dutyPerson) {
		this.dutyPerson = dutyPerson;
	}

	@Column(name = "DUTY_PERSON_", length = 100)
	public String getDutyPerson() {
		return dutyPerson;
	}

	public void setAssociated(String associated) {
		this.associated = associated;
	}

	@Column(name = "ASSOCIATED_", length = 4)
	public String getAssociated() {
		return associated;
	}

	public void setAssoDate(Date assoDate) {
		this.assoDate = assoDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ASSO_DATE_")
	public Date getAssoDate() {
		return assoDate;
	}

	public void setCompChin(String compChin) {
		this.compChin = compChin;
	}

	@Column(name = "COMP_CHIN_", length = 200)
	public String getCompChin() {
		return compChin;
	}

	public void setCompEmg(String compEmg) {
		this.compEmg = compEmg;
	}

	@Column(name = "COMP_EMG_", length = 200)
	public String getCompEmg() {
		return compEmg;
	}

	public void setRegisterAmt(BigDecimal registerAmt) {
		this.registerAmt = registerAmt;
	}

	@Column(name = "REGISTER_AMT_")
	public BigDecimal getRegisterAmt() {
		return registerAmt;
	}

	public void setRegCny(String regCny) {
		this.regCny = regCny;
	}

	@Column(name = "REG_CNY_", length = 10)
	public String getRegCny() {
		return regCny;
	}

	public void setTurnOver(BigDecimal turnOver) {
		this.turnOver = turnOver;
	}

	@Column(name = "TURN_OVER_")
	public BigDecimal getTurnOver() {
		return turnOver;
	}

	public void setTurCny(String turCny) {
		this.turCny = turCny;
	}

	@Column(name = "TUR_CNY_", length = 10)
	public String getTurCny() {
		return turCny;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "ZIP_CODE_", length = 20)
	public String getZipCode() {
		return zipCode;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Column(name = "MAIL_ADDRESS_", length = 400)
	public String getMailAddress() {
		return mailAddress;
	}

	public void setCompWeb(String compWeb) {
		this.compWeb = compWeb;
	}

	@Column(name = "COMP_WEB_", length = 200)
	public String getCompWeb() {
		return compWeb;
	}

	public void setLoadLine(String loadLine) {
		this.loadLine = loadLine;
	}

	@Column(name = "LOAD_LINE_", length = 20)
	public String getLoadLine() {
		return loadLine;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "PHONE_NUMBER_", length = 20)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	@Column(name = "FAX_NUMBER_", length = 20)
	public String getFaxNumber() {
		return faxNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "EMAIL_", length = 50)
	public String getEmail() {
		return email;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "QQ_", length = 20)
	public String getQq() {
		return qq;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	@Column(name = "WE_CHAT_", length = 30)
	public String getWeChat() {
		return weChat;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	@Column(name = "FACEBOOK_", length = 30)
	public String getFacebook() {
		return facebook;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Column(name = "TWITTER_", length = 30)
	public String getTwitter() {
		return twitter;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	@Column(name = "BLOG_", length = 30)
	public String getBlog() {
		return blog;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	@Column(name = "INVOICE_NAME_", length = 200)
	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceBank(String invoiceBank) {
		this.invoiceBank = invoiceBank;
	}

	@Column(name = "INVOICE_BANK_", length = 200)
	public String getInvoiceBank() {
		return invoiceBank;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Column(name = "ACCOUNT_NO_", length = 30)
	public String getAccountNo() {
		return accountNo;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	@Column(name = "TAX_NUMBER_", length = 30)
	public String getTaxNumber() {
		return taxNumber;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	@Column(name = "INVOICE_ADDRESS_", length = 400)
	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoicePhone(String invoicePhone) {
		this.invoicePhone = invoicePhone;
	}

	@Column(name = "INVOICE_PHONE_", length = 20)
	public String getInvoicePhone() {
		return invoicePhone;
	}

	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}

	@Column(name = "BELONG_ORG_", length = 20)
	public String getBelongOrg() {
		return belongOrg;
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

	public String toString() {
		return "Tbcm011 [pkCm011=" + pkCm011 + ",compId=" + compId + ",custNo="
				+ custNo + ",version=" + version + ",nationnality="
				+ nationnality + ",custCategery=" + custCategery
				+ ",yongyouCustNo=" + yongyouCustNo + ",custName=" + custName
				+ ",dutyPerson=" + dutyPerson + ",associated=" + associated
				+ ",assoDate=" + assoDate + ",compChin=" + compChin
				+ ",compEmg=" + compEmg + ",registerAmt=" + registerAmt
				+ ",regCny=" + regCny + ",turnOver=" + turnOver + ",turCny="
				+ turCny + ",zipCode=" + zipCode + ",mailAddress="
				+ mailAddress + ",compWeb=" + compWeb + ",loadLine=" + loadLine
				+ ",phoneNumber=" + phoneNumber + ",faxNumber=" + faxNumber
				+ ",email=" + email + ",qq=" + qq + ",weChat=" + weChat
				+ ",facebook=" + facebook + ",twitter=" + twitter + ",blog="
				+ blog + ",invoiceName=" + invoiceName + ",invoiceBank="
				+ invoiceBank + ",accountNo=" + accountNo + ",taxNumber="
				+ taxNumber + ",invoiceAddress=" + invoiceAddress
				+ ",invoicePhone=" + invoicePhone + ",belongOrg=" + belongOrg
				+ ",createEmp=" + createEmp + ",createDate=" + createDate
				+ ",updEmp=" + updEmp + ",updDate=" + updDate + ",versionStus="
				+ versionStus + ",defs01=" + defs01 + ",defs02=" + defs02
				+ ",defs03=" + defs03 + ",defs04=" + defs04 + ",defs05="
				+ defs05 + ",defb01=" + defb01 + ",defb02=" + defb02
				+ ",defb03=" + defb03 + ",defb04=" + defb04 + ",defb05="
				+ defb05 + ",defm01=" + defm01 + ",defm02=" + defm02 + "]";
	}

}
