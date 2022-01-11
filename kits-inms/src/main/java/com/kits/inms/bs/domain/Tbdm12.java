package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBDM12:仓库详细数据表
 */
@Entity
@Table(name = "TBDM12")
public class Tbdm12 implements Serializable {

	private static final long serialVersionUID = 1L;

	@PropertyDef(label = "PK_DM12_", description = "PK_DM12_:")
	private String pkDm12;
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
	 * LOC_NO_:
	 */
	@PropertyDef(label = "LOC_NO_", description = "LOC_NO_:")
	private String locNo;

	/**
	 * CREATE_USER_:
	 */
	@PropertyDef(label = "CREATE_USER_", description = "CREATE_USER_:")
	private String createUser;

	/**
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private Date createDate;

	/**
	 * MODIFY_USER_:
	 */
	@PropertyDef(label = "MODIFY_USER_", description = "MODIFY_USER_:")
	private String modifyUser;

	/**
	 * MODIFY_DATE_:
	 */
	@PropertyDef(label = "MODIFY_DATE_", description = "MODIFY_DATE_:")
	private Date modifyDate;

	/**
	 * LOC_NAME_:
	 */
	@PropertyDef(label = "LOC_NAME_", description = "LOC_NAME_:")
	private String locName;

	/**
	 * AUTH_ID_:
	 */
	@PropertyDef(label = "AUTH_ID_", description = "AUTH_ID_:")
	private String authId;

	/**
	 * KEEPER_:
	 */
	@PropertyDef(label = "KEEPER_", description = "KEEPER_:")
	private String keeper;

	/**
	 * CAP_:
	 */
	@PropertyDef(label = "CAP_", description = "CAP_:")
	private BigDecimal cap;

	/**
	 * LOC_LAYER_:
	 */
	@PropertyDef(label = "LOC_LAYER_", description = "LOC_LAYER_:")
	private BigDecimal locLayer;

	/**
	 * LOC_1F_:
	 */
	@PropertyDef(label = "LOC_1F_", description = "LOC_1F_:")
	private String loc1f;

	/**
	 * LOC_2F_:
	 */
	@PropertyDef(label = "LOC_2F_", description = "LOC_2F_:")
	private String loc2f;

	/**
	 * LOC_3F_:
	 */
	@PropertyDef(label = "LOC_3F_", description = "LOC_3F_:")
	private String loc3f;

	/**
	 * LOC_4F_:
	 */
	@PropertyDef(label = "LOC_4F_", description = "LOC_4F_:")
	private String loc4f;

	public Tbdm12() {
		super();
	}

	public Tbdm12(String compId, String stockId, String locNo,
			String createUser, Date createDate, String modifyUser,
			Date modifyDate, String locName, String authId, String keeper,
			BigDecimal cap, BigDecimal locLayer, String loc1f, String loc2f,
			String loc3f, String loc4f,String pkDm12) {
		super();
		this.pkDm12 = pkDm12;
		this.compId = compId;
		this.stockId = stockId;
		this.locNo = locNo;
		this.createUser = createUser;
		this.createDate = createDate;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.locName = locName;
		this.authId = authId;
		this.keeper = keeper;
		this.cap = cap;
		this.locLayer = locLayer;
		this.loc1f = loc1f;
		this.loc2f = loc2f;
		this.loc3f = loc3f;
		this.loc4f = loc4f;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 18, nullable = false)
	public String getCompId() {
		return compId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_ID_", length = 18, nullable = false)
	public String getStockId() {
		return stockId;
	}

	public void setLocNo(String locNo) {
		this.locNo = locNo;
	}

	@Column(name = "LOC_NO_", length = 18, nullable = false)
	public String getLocNo() {
		return locNo;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_USER_", length = 18)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	@Column(name = "MODIFY_USER_", length = 18)
	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE_")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	@Column(name = "LOC_NAME_", length = 60)
	public String getLocName() {
		return locName;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	@Column(name = "AUTH_ID_", length = 18)
	public String getAuthId() {
		return authId;
	}

	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}

	@Column(name = "KEEPER_", length = 18)
	public String getKeeper() {
		return keeper;
	}

	public void setCap(BigDecimal cap) {
		this.cap = cap;
	}

	@Column(name = "CAP_")
	public BigDecimal getCap() {
		return cap;
	}

	public void setLocLayer(BigDecimal locLayer) {
		this.locLayer = locLayer;
	}

	@Column(name = "LOC_LAYER_")
	public BigDecimal getLocLayer() {
		return locLayer;
	}

	public void setLoc1f(String loc1f) {
		this.loc1f = loc1f;
	}

	@Column(name = "LOC_1F_", length = 18)
	public String getLoc1f() {
		return loc1f;
	}

	public void setLoc2f(String loc2f) {
		this.loc2f = loc2f;
	}

	@Column(name = "LOC_2F_", length = 18)
	public String getLoc2f() {
		return loc2f;
	}

	public void setLoc3f(String loc3f) {
		this.loc3f = loc3f;
	}

	@Column(name = "LOC_3F_", length = 18)
	public String getLoc3f() {
		return loc3f;
	}

	public void setLoc4f(String loc4f) {
		this.loc4f = loc4f;
	}

	@Column(name = "LOC_4F_", length = 18)
	public String getLoc4f() {
		return loc4f;
	}

	public String toString() {
		return "Tbdm12 [compId=" + compId + ",stockId=" + stockId + ",locNo="
				+ locNo + ",createUser=" + createUser + ",createDate="
				+ createDate + ",modifyUser=" + modifyUser + ",modifyDate="
				+ modifyDate + ",locName=" + locName + ",authId=" + authId
				+ ",keeper=" + keeper + ",cap=" + cap + ",locLayer=" + locLayer
				+ ",loc1f=" + loc1f + ",loc2f=" + loc2f + ",loc3f=" + loc3f
				+ ",loc4f=" + loc4f + "]";
	}

	@Id
	@Column(name = "PK_DM12_", length = 40)
	public String getPkDm12() {
		return pkDm12;
	}

	public void setPkDm12(String pkDm12) {
		this.pkDm12 = pkDm12;
	}

}
