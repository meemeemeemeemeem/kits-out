package com.kits.inms.df.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TBDF01:基础资料维护主档信息
 */
@Entity
@Table(name = "TBDF01")
public class Tbdf01 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * PK_DF01_:
	 */
	@PropertyDef(label = "PK_DF01_", description = "PK_DF01_:")
	private String pkDf01;

	/**
	 * 公司别:公司别
	 */
	@PropertyDef(label = "公司别", description = "公司别:公司别")
	private String compId;

	/**
	 * REF_ID_:
	 */
	@PropertyDef(label = "REF_ID_", description = "REF_ID_:")
	private String refId;

	/**
	 * REF_NAME_:
	 */
	@PropertyDef(label = "REF_NAME_", description = "REF_NAME_:")
	private String refName;

	/**
	 * REF_A_:
	 */
	@PropertyDef(label = "REF_A_", description = "REF_A_:")
	private String refA;

	/**
	 * REF_B_:
	 */
	@PropertyDef(label = "REF_B_", description = "REF_B_:")
	private String refB;

	/**
	 * DEF1_:
	 */
	@PropertyDef(label = "DEF1_", description = "DEF1_:")
	private String def1;

	/**
	 * DEF2_:
	 */
	@PropertyDef(label = "DEF2_", description = "DEF2_:")
	private String def2;

	/**
	 * DEF3_:
	 */
	@PropertyDef(label = "DEF3_", description = "DEF3_:")
	private String def3;

	/**
	 * DEF4_:
	 */
	@PropertyDef(label = "DEF4_", description = "DEF4_:")
	private String def4;

	/**
	 * DEF5_:
	 */
	@PropertyDef(label = "DEF5_", description = "DEF5_:")
	private String def5;

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
	 * REF_PID_:
	 */
	@PropertyDef(label = "REF_PID_", description = "REF_PID_:")
	private String refPid;

	/**
	 * 页面类型:页面类型
	 */
	@PropertyDef(label = "页面类型", description = "页面类型:页面类型")
	private String type;

	public Tbdf01() {
		super();
	}

	public Tbdf01(String pkDf01, String compId, String refId, String refName, String refA, String refB, String def1,
			String def2, String def3, String def4, String def5, String createEmp, Date createDate, String updEmp,
			Date updDate, String refPid, String type) {
		super();
		this.pkDf01 = pkDf01;
		this.compId = compId;
		this.refId = refId;
		this.refName = refName;
		this.refA = refA;
		this.refB = refB;
		this.def1 = def1;
		this.def2 = def2;
		this.def3 = def3;
		this.def4 = def4;
		this.def5 = def5;
		this.createEmp = createEmp;
		this.createDate = createDate;
		this.updEmp = updEmp;
		this.updDate = updDate;
		this.refPid = refPid;
		this.type = type;
	}

	public void setPkDf01(String pkDf01) {
		this.pkDf01 = pkDf01;
	}

	@Id
	@Column(name = "PK_DF01_", length = 40, nullable = false)
	public String getPkDf01() {
		return pkDf01;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 20)
	public String getCompId() {
		return compId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	@Column(name = "REF_ID_", length = 30)
	public String getRefId() {
		return refId;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	@Column(name = "REF_NAME_", length = 40)
	public String getRefName() {
		return refName;
	}

	public void setRefA(String refA) {
		this.refA = refA;
	}

	@Column(name = "REF_A_", length = 5)
	public String getRefA() {
		return refA;
	}

	public void setRefB(String refB) {
		this.refB = refB;
	}

	@Column(name = "REF_B_", length = 5)
	public String getRefB() {
		return refB;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	@Column(name = "DEF1_", length = 50)
	public String getDef1() {
		return def1;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	@Column(name = "DEF2_", length = 50)
	public String getDef2() {
		return def2;
	}

	public void setDef3(String def3) {
		this.def3 = def3;
	}

	@Column(name = "DEF3_", length = 50)
	public String getDef3() {
		return def3;
	}

	public void setDef4(String def4) {
		this.def4 = def4;
	}

	@Column(name = "DEF4_", length = 50)
	public String getDef4() {
		return def4;
	}

	public void setDef5(String def5) {
		this.def5 = def5;
	}

	@Column(name = "DEF5_", length = 50)
	public String getDef5() {
		return def5;
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

	public void setRefPid(String refPid) {
		this.refPid = refPid;
	}

	@Column(name = "REF_PID_", length = 40)
	public String getRefPid() {
		return refPid;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "TYPE_", length = 10)
	public String getType() {
		return type;
	}

	public String toString() {
		return "Tbdf01 [pkDf01=" + pkDf01 + ",compId=" + compId + ",refId=" + refId + ",refName=" + refName + ",refA="
				+ refA + ",refB=" + refB + ",def1=" + def1 + ",def2=" + def2 + ",def3=" + def3 + ",def4=" + def4
				+ ",def5=" + def5 + ",createEmp=" + createEmp + ",createDate=" + createDate + ",updEmp=" + updEmp
				+ ",updDate=" + updDate + ",refPid=" + refPid + ",type=" + type + "]";
	}

}
