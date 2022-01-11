package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TBDM11:仓库维护数据表
 */
@Entity
@Table(name = "TBDM11")
public class Tbdm11 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;

	/**
	 * STOCK_ID_:
	 */
	@PropertyDef(label = "STOCK_ID_", description = "STOCK_ID_:")
	private String stockId;

	/**
	 * CREATE_USER_:
	 */
	@PropertyDef(label = "CREATE_USER_", description = "CREATE_USER_:")
	private String createUser;

	/**
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private String createDate;

	/**
	 * MODIFY_USER_:
	 */
	@PropertyDef(label = "MODIFY_USER_", description = "MODIFY_USER_:")
	private String modifyUser;

	/**
	 * MODIFY_DATE_:
	 */
	@PropertyDef(label = "MODIFY_DATE_", description = "MODIFY_DATE_:")
	private String modifyDate;

	/**
	 * STOCK_NAME_:
	 */
	@PropertyDef(label = "STOCK_NAME_", description = "STOCK_NAME_:")
	private String stockName;

	/**
	 * AUTH_ID_:
	 */
	@PropertyDef(label = "AUTH_ID_", description = "AUTH_ID_:")
	private String authId;

	/**
	 * FAC_ID_:
	 */
	@PropertyDef(label = "FAC_ID_", description = "FAC_ID_:")
	private String facId;

	/**
	 * ZONE_ID_:
	 */
	@PropertyDef(label = "ZONE_ID_", description = "ZONE_ID_:")
	private String zoneId;

	/**
	 * STOCK_KEY_A_:
	 */
	@PropertyDef(label = "STOCK_KEY_A_", description = "STOCK_KEY_A_:")
	private String stockKeyA;

	/**
	 * STOCK_KEY_B_:
	 */
	@PropertyDef(label = "STOCK_KEY_B_", description = "STOCK_KEY_B_:")
	private String stockKeyB;

	/**
	 * STOCK_KEY_C_:
	 */
	@PropertyDef(label = "STOCK_KEY_C_", description = "STOCK_KEY_C_:")
	private String stockKeyC;

	/**
	 * DEF_A_:
	 */
	@PropertyDef(label = "DEF_A_", description = "DEF_A_:")
	private String defA;

	/**
	 * PK_DM11_:
	 */
	@PropertyDef(label = "PK_DM11_", description = "PK_DM11_:")
	private String pkDm11;

	/**
	 * 责任人:责任人
	 */
	@PropertyDef(label = "责任人", description = "责任人:责任人")
	private String dutyPerson;

	/**
	 * 电话:电话
	 */
	@PropertyDef(label = "电话", description = "电话:电话")
	private String phoneNum;

	/**
	 * 仓库地址:仓库地址
	 */
	@PropertyDef(label = "仓库地址", description = "仓库地址:仓库地址")
	private String address;

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

	public Tbdm11() {
		super();
	}

	public Tbdm11(String compId, String stockId, String createUser,
			String createDate, String modifyUser, String modifyDate,
			String stockName, String authId, String facId, String zoneId,
			String stockKeyA, String stockKeyB, String stockKeyC, String defA,
			String pkDm11, String dutyPerson, String phoneNum, String address,
			String defs01, String defs02, String defs03, String defs04,
			String defs05) {
		super();
		this.compId = compId;
		this.stockId = stockId;
		this.createUser = createUser;
		this.createDate = createDate;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.stockName = stockName;
		this.authId = authId;
		this.facId = facId;
		this.zoneId = zoneId;
		this.stockKeyA = stockKeyA;
		this.stockKeyB = stockKeyB;
		this.stockKeyC = stockKeyC;
		this.defA = defA;
		this.pkDm11 = pkDm11;
		this.dutyPerson = dutyPerson;
		this.phoneNum = phoneNum;
		this.address = address;
		this.defs01 = defs01;
		this.defs02 = defs02;
		this.defs03 = defs03;
		this.defs04 = defs04;
		this.defs05 = defs05;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 18)
	public String getCompId() {
		return compId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_ID_", length = 18)
	public String getStockId() {
		return stockId;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_USER_", length = 18)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_DATE_", length = 20)
	public String getCreateDate() {
		return createDate;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	@Column(name = "MODIFY_USER_", length = 18)
	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "MODIFY_DATE_", length = 20)
	public String getModifyDate() {
		return modifyDate;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Column(name = "STOCK_NAME_", length = 38)
	public String getStockName() {
		return stockName;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	@Column(name = "AUTH_ID_", length = 18)
	public String getAuthId() {
		return authId;
	}

	public void setFacId(String facId) {
		this.facId = facId;
	}

	@Column(name = "FAC_ID_", length = 1)
	public String getFacId() {
		return facId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	@Column(name = "ZONE_ID_", length = 1)
	public String getZoneId() {
		return zoneId;
	}

	public void setStockKeyA(String stockKeyA) {
		this.stockKeyA = stockKeyA;
	}

	@Column(name = "STOCK_KEY_A_", length = 1)
	public String getStockKeyA() {
		return stockKeyA;
	}

	public void setStockKeyB(String stockKeyB) {
		this.stockKeyB = stockKeyB;
	}

	@Column(name = "STOCK_KEY_B_", length = 1)
	public String getStockKeyB() {
		return stockKeyB;
	}

	public void setStockKeyC(String stockKeyC) {
		this.stockKeyC = stockKeyC;
	}

	@Column(name = "STOCK_KEY_C_", length = 1)
	public String getStockKeyC() {
		return stockKeyC;
	}

	public void setDefA(String defA) {
		this.defA = defA;
	}

	@Column(name = "DEF_A_", length = 18)
	public String getDefA() {
		return defA;
	}

	public void setPkDm11(String pkDm11) {
		this.pkDm11 = pkDm11;
	}

	@Id
	@Column(name = "PK_DM11_", length = 40, nullable = false)
	public String getPkDm11() {
		return pkDm11;
	}

	public void setDutyPerson(String dutyPerson) {
		this.dutyPerson = dutyPerson;
	}

	@Column(name = "DUTY_PERSON_", length = 20)
	public String getDutyPerson() {
		return dutyPerson;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "PHONE_NUM_", length = 20)
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ADDRESS_", length = 100)
	public String getAddress() {
		return address;
	}

	public void setDefs01(String defs01) {
		this.defs01 = defs01;
	}

	@Column(name = "DEFS01_", length = 40)
	public String getDefs01() {
		return defs01;
	}

	public void setDefs02(String defs02) {
		this.defs02 = defs02;
	}

	@Column(name = "DEFS02_", length = 40)
	public String getDefs02() {
		return defs02;
	}

	public void setDefs03(String defs03) {
		this.defs03 = defs03;
	}

	@Column(name = "DEFS03_", length = 40)
	public String getDefs03() {
		return defs03;
	}

	public void setDefs04(String defs04) {
		this.defs04 = defs04;
	}

	@Column(name = "DEFS04_", length = 40)
	public String getDefs04() {
		return defs04;
	}

	public void setDefs05(String defs05) {
		this.defs05 = defs05;
	}

	@Column(name = "DEFS05_", length = 40)
	public String getDefs05() {
		return defs05;
	}

	public String toString() {
		return "Tbdm11 [compId=" + compId + ",stockId=" + stockId
				+ ",createUser=" + createUser + ",createDate=" + createDate
				+ ",modifyUser=" + modifyUser + ",modifyDate=" + modifyDate
				+ ",stockName=" + stockName + ",authId=" + authId + ",facId="
				+ facId + ",zoneId=" + zoneId + ",stockKeyA=" + stockKeyA
				+ ",stockKeyB=" + stockKeyB + ",stockKeyC=" + stockKeyC
				+ ",defA=" + defA + ",pkDm11=" + pkDm11 + ",dutyPerson="
				+ dutyPerson + ",phoneNum=" + phoneNum + ",address=" + address
				+ ",defs01=" + defs01 + ",defs02=" + defs02 + ",defs03="
				+ defs03 + ",defs04=" + defs04 + ",defs05=" + defs05 + "]";
	}

}
