package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TBDF06:币别管理档
 */
@Entity
@Table(name = "TBDF06")
public class Tbdf06 implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * PK_DF06_:
	 */
	@PropertyDef(label = "PK_DF06_", description = "PK_DF06_:")
	private String pkDf06;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;

	/**
	 * CURRENCY_:
	 */
	@PropertyDef(label = "CURRENCY_", description = "CURRENCY_:")
	private String currency;

	/**
	 * CURRENCY_ABB_:
	 */
	@PropertyDef(label = "CURRENCY_ABB_", description = "CURRENCY_ABB_:")
	private String currencyAbb;

	/**
	 * CURRENCY_NAME_EN_:
	 */
	@PropertyDef(label = "CURRENCY_NAME_EN_", description = "CURRENCY_NAME_EN_:")
	private String currencyNameEn;

	/**
	 * CURRENCY_NAME_LOCAL_:
	 */
	@PropertyDef(label = "CURRENCY_NAME_LOCAL_", description = "CURRENCY_NAME_LOCAL_:")
	private String currencyNameLocal;

	/**
	 * CURRENCY_SYMBOL_:
	 */
	@PropertyDef(label = "CURRENCY_SYMBOL_", description = "CURRENCY_SYMBOL_:")
	private String currencySymbol;

	/**
	 * CURRENCY_DEF_:
	 */
	@PropertyDef(label = "CURRENCY_DEF_", description = "CURRENCY_DEF_:")
	private String currencyDef;

	/**
	 * CURRENCY_PICTURE_URL_:
	 */
	@PropertyDef(label = "CURRENCY_PICTURE_URL_", description = "CURRENCY_PICTURE_URL_:")
	private String currencyPictureUrl;

	/**
	 * CREATE_EMP_NO_:
	 */
	@PropertyDef(label = "CREATE_EMP_NO_", description = "CREATE_EMP_NO_:")
	private String createEmpNo;

	/**
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private Date createDate;

	/**
	 * MODIFY_EMP_NO_:
	 */
	@PropertyDef(label = "MODIFY_EMP_NO_", description = "MODIFY_EMP_NO_:")
	private String modifyEmpNo;

	/**
	 * MODIFY_DATE_:
	 */
	@PropertyDef(label = "MODIFY_DATE_", description = "MODIFY_DATE_:")
	private Date modifyDate;

	public Tbdf06() {
		super();
	}
	public Tbdf06(String pkDf06, String compId, String currency,
			String currencyAbb, String currencyNameEn,
			String currencyNameLocal, String currencySymbol,
			String currencyDef, String currencyPictureUrl, String createEmpNo,
			Date createDate, String modifyEmpNo, Date modifyDate) {
		super();
		this.pkDf06 = pkDf06;
		this.compId = compId;
		this.currency = currency;
		this.currencyAbb = currencyAbb;
		this.currencyNameEn = currencyNameEn;
		this.currencyNameLocal = currencyNameLocal;
		this.currencySymbol = currencySymbol;
		this.currencyDef = currencyDef;
		this.currencyPictureUrl = currencyPictureUrl;
		this.createEmpNo = createEmpNo;
		this.createDate = createDate;
		this.modifyEmpNo = modifyEmpNo;
		this.modifyDate = modifyDate;
	}

	public void setPkDf06(String pkDf06) {
		this.pkDf06 = pkDf06;
	}
	@Id
	@Column(name = "PK_DF06_", length = 40, nullable = false)
	public String getPkDf06() {
		return pkDf06;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}
	@Column(name = "COMP_ID_", length = 10)
	public String getCompId() {
		return compId;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Column(name = "CURRENCY_", length = 4)
	public String getCurrency() {
		return currency;
	}

	public void setCurrencyAbb(String currencyAbb) {
		this.currencyAbb = currencyAbb;
	}
	@Column(name = "CURRENCY_ABB_", length = 5)
	public String getCurrencyAbb() {
		return currencyAbb;
	}

	public void setCurrencyNameEn(String currencyNameEn) {
		this.currencyNameEn = currencyNameEn;
	}
	@Column(name = "CURRENCY_NAME_EN_", length = 50)
	public String getCurrencyNameEn() {
		return currencyNameEn;
	}

	public void setCurrencyNameLocal(String currencyNameLocal) {
		this.currencyNameLocal = currencyNameLocal;
	}
	@Column(name = "CURRENCY_NAME_LOCAL_", length = 50)
	public String getCurrencyNameLocal() {
		return currencyNameLocal;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	@Column(name = "CURRENCY_SYMBOL_", length = 20)
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencyDef(String currencyDef) {
		this.currencyDef = currencyDef;
	}
	@Column(name = "CURRENCY_DEF_", length = 1)
	public String getCurrencyDef() {
		return currencyDef;
	}

	public void setCurrencyPictureUrl(String currencyPictureUrl) {
		this.currencyPictureUrl = currencyPictureUrl;
	}
	@Column(name = "CURRENCY_PICTURE_URL_", length = 100)
	public String getCurrencyPictureUrl() {
		return currencyPictureUrl;
	}

	public void setCreateEmpNo(String createEmpNo) {
		this.createEmpNo = createEmpNo;
	}
	@Column(name = "CREATE_EMP_NO_", length = 20)
	public String getCreateEmpNo() {
		return createEmpNo;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE_")
	public Date getCreateDate() {
		return createDate;
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

	public String toString() {
		return "Tbdf06 [pkDf06=" + pkDf06 + ",compId=" + compId + ",currency="
				+ currency + ",currencyAbb=" + currencyAbb + ",currencyNameEn="
				+ currencyNameEn + ",currencyNameLocal=" + currencyNameLocal
				+ ",currencySymbol=" + currencySymbol + ",currencyDef="
				+ currencyDef + ",currencyPictureUrl=" + currencyPictureUrl
				+ ",createEmpNo=" + createEmpNo + ",createDate=" + createDate
				+ ",modifyEmpNo=" + modifyEmpNo + ",modifyDate=" + modifyDate
				+ "]";
	}

}
