package com.kits.inms.df.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBDF02:基础信息维护参数表
 */
@Entity
@Table(name = "TBDF02")
public class Tbdf02 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * PK_DF02_:
	 */
	@PropertyDef(label = "PK_DF02_", description = "PK_DF02_:")
	private String pkDf02;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;

	/**
	 * REF_ID_:
	 */
	@PropertyDef(label = "REF_ID_", description = "REF_ID_:")
	private String refId;

	/**
	 * VALUE_A_:
	 */
	@PropertyDef(label = "VALUE_A_", description = "VALUE_A_:")
	private String valueA;

	/**
	 * VALUE_B_:
	 */
	@PropertyDef(label = "VALUE_B_", description = "VALUE_B_:")
	private String valueB;

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
	 * 页面类型:页面类型
	 */
	@PropertyDef(label = "页面类型", description = "页面类型:页面类型")
	private String type;

	/**
	 * 排序:排序
	 */
	@PropertyDef(label = "排序", description = "排序:排序")
	private BigDecimal orderNum;

	public Tbdf02() {
		super();
	}

	public Tbdf02(String pkDf02, String compId, String refId, String valueA, String valueB, String def1, String def2,
			String def3, String def4, String def5, String createEmp, Date createDate, String updEmp, Date updDate,
			String type, BigDecimal orderNum) {
		super();
		this.pkDf02 = pkDf02;
		this.compId = compId;
		this.refId = refId;
		this.valueA = valueA;
		this.valueB = valueB;
		this.def1 = def1;
		this.def2 = def2;
		this.def3 = def3;
		this.def4 = def4;
		this.def5 = def5;
		this.createEmp = createEmp;
		this.createDate = createDate;
		this.updEmp = updEmp;
		this.updDate = updDate;
		this.type = type;
		this.orderNum = orderNum;
	}

	public void setPkDf02(String pkDf02) {
		this.pkDf02 = pkDf02;
	}

	@Id
	@Column(name = "PK_DF02_", length = 40, nullable = false)
	public String getPkDf02() {
		return pkDf02;
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

	@Column(name = "REF_ID_", length = 20)
	public String getRefId() {
		return refId;
	}

	public void setValueA(String valueA) {
		this.valueA = valueA;
	}

	@Column(name = "VALUE_A_", length = 200)
	public String getValueA() {
		return valueA;
	}

	public void setValueB(String valueB) {
		this.valueB = valueB;
	}

	@Column(name = "VALUE_B_", length = 200)
	public String getValueB() {
		return valueB;
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

	@Column(name = "DEF4_", length = 200)
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

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "TYPE_", length = 10)
	public String getType() {
		return type;
	}

	public void setOrderNum(BigDecimal orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "ORDER_NUM_")
	public BigDecimal getOrderNum() {
		return orderNum;
	}

	public String toString() {
		return "Tbdf02 [pkDf02=" + pkDf02 + ",compId=" + compId + ",refId=" + refId + ",valueA=" + valueA + ",valueB="
				+ valueB + ",def1=" + def1 + ",def2=" + def2 + ",def3=" + def3 + ",def4=" + def4 + ",def5=" + def5
				+ ",createEmp=" + createEmp + ",createDate=" + createDate + ",updEmp=" + updEmp + ",updDate=" + updDate
				+ ",type=" + type + ",orderNum=" + orderNum + "]";
	}

}
