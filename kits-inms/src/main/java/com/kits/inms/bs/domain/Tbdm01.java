package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBDM01:料号信息管理数据表
 */
@Entity
@Table(name = "TBDM01")
public class Tbdm01 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;

	/**
	 * 料号:料号
	 */
	@PropertyDef(label = "料号", description = "料号:料号")
	private String matrlNo;

	/**
	 * 料别:料别
	 */
	@PropertyDef(label = "料别", description = "料别:料别")
	private String inventoryType;

	/**
	 * 外观:外观
	 */
	@PropertyDef(label = "外观", description = "外观:外观")
	private String appearance;

	/**
	 * 计价方式:计价方式
	 */
	@PropertyDef(label = "计价方式", description = "计价方式:计价方式")
	private String priceMethod;

	/**
	 * PRODE_TYPE_:
	 */
	@PropertyDef(label = "PRODE_TYPE_", description = "PRODE_TYPE_:")
	private String prodeType;

	/**
	 * 材质:材质
	 */
	@PropertyDef(label = "材质", description = "材质:材质")
	private String materailName;

	/**
	 * 质量标准:质量标准
	 */
	@PropertyDef(label = "质量标准", description = "质量标准:质量标准")
	private String grade;

	/**
	 * 厚:厚
	 */
	@PropertyDef(label = "厚", description = "厚:厚")
	private BigDecimal trick;

	/**
	 * 宽:宽
	 */
	@PropertyDef(label = "宽", description = "宽:宽")
	private BigDecimal width;

	/**
	 * 长:长
	 */
	@PropertyDef(label = "长", description = "长:长")
	private BigDecimal lengthA;

	/**
	 * LENGTH_B_:
	 */
	@PropertyDef(label = "LENGTH_B_", description = "LENGTH_B_:")
	private BigDecimal lengthB;

	/**
	 * 外径:外径
	 */
	@PropertyDef(label = "外径", description = "外径:外径")
	private BigDecimal diameter;

	/**
	 * 生产类型:生产类型
	 */
	@PropertyDef(label = "生产类型", description = "生产类型:生产类型")
	private String prodeCode;

	/**
	 * 货源:货源
	 */
	@PropertyDef(label = "货源", description = "货源:货源")
	private String materailSrc;

	/**
	 * 用途:用途
	 */
	@PropertyDef(label = "用途", description = "用途:用途")
	private String pdType;

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
	 * UPDATE_EMP_:
	 */
	@PropertyDef(label = "UPDATE_EMP_", description = "UPDATE_EMP_:")
	private String updateEmp;

	/**
	 * UPDATE_DATE_:
	 */
	@PropertyDef(label = "UPDATE_DATE_", description = "UPDATE_DATE_:")
	private Date updateDate;

	/**
	 * VERSION:
	 */
	@PropertyDef(label = "VERSION", description = "VERSION:")
	private BigDecimal version;

	/**
	 * 品名代码:品名代码
	 */
	@PropertyDef(label = "品名代码", description = "品名代码:品名代码")
	private String bak1;

	/**
	 * BAK2_:
	 */
	@PropertyDef(label = "BAK2_", description = "BAK2_:")
	private String bak2;

	/**
	 * BAK3_:
	 */
	@PropertyDef(label = "BAK3_", description = "BAK3_:")
	private String bak3;

	/**
	 * PK_DM01_:
	 */
	@PropertyDef(label = "PK_DM01_", description = "PK_DM01_:")
	private String pkDm01;

	/**
	 * THICK_TOLERANCE_:
	 */
	@PropertyDef(label = "THICK_TOLERANCE_", description = "THICK_TOLERANCE_:")
	private BigDecimal thickTolerance;

	/**
	 * LENGTH_TOLERANCE_:
	 */
	@PropertyDef(label = "LENGTH_TOLERANCE_", description = "LENGTH_TOLERANCE_:")
	private BigDecimal lengthTolerance;

	/**
	 * WIDTH_TOLERANCE_:
	 */
	@PropertyDef(label = "WIDTH_TOLERANCE_", description = "WIDTH_TOLERANCE_:")
	private BigDecimal widthTolerance;

	/**
	 * DIAMETER_OUT_TOLERANCE_:
	 */
	@PropertyDef(label = "DIAMETER_OUT_TOLERANCE_", description = "DIAMETER_OUT_TOLERANCE_:")
	private BigDecimal diameterOutTolerance;

	/**
	 * DIAMETER_IN_TOLERANCE_:
	 */
	@PropertyDef(label = "DIAMETER_IN_TOLERANCE_", description = "DIAMETER_IN_TOLERANCE_:")
	private BigDecimal diameterInTolerance;

	/**
	 * 内径:内径
	 */
	@PropertyDef(label = "内径", description = "内径:内径")
	private BigDecimal diameterIn;

	/**
	 * 描述:描述
	 */
	@PropertyDef(label = "描述", description = "描述:描述")
	private String matrlDesc;

	/**
	 * 品名:品名
	 */
	@PropertyDef(label = "品名", description = "品名:品名")
	private String prodeName;

	/**
	 * 尺寸信息:尺寸信息
	 */
	@PropertyDef(label = "尺寸信息", description = "尺寸信息:尺寸信息")
	private String defs01;

	/**
	 * 质量信息:质量信息
	 */
	@PropertyDef(label = "质量信息", description = "质量信息:质量信息")
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
	 * 规格:规格
	 */
	@PropertyDef(label = "规格", description = "规格:规格")
	private String defn01;

	/**
	 * DEFN02:
	 */
	@PropertyDef(label = "DEFN02", description = "DEFN02:")
	private String defn02;

	/**
	 * SHAPE_:
	 */
	@PropertyDef(label = "SHAPE_", description = "SHAPE_:")
	private String shape;

	/**
	 * PRODE_NO_:
	 */
	@PropertyDef(label = "PRODE_NO_", description = "PRODE_NO_:")
	private String prodeNo;

	/**
	 * DEFS11_:
	 */
	@PropertyDef(label = "DEFS11_", description = "DEFS11_:")
	private String defs11;

	/**
	 * DEFS12_:
	 */
	@PropertyDef(label = "DEFS12_", description = "DEFS12_:")
	private String defs12;

	/**
	 * DEFS13_:
	 */
	@PropertyDef(label = "DEFS13_", description = "DEFS13_:")
	private String defs13;

	/**
	 * DEFS14_:
	 */
	@PropertyDef(label = "DEFS14_", description = "DEFS14_:")
	private String defs14;

	/**
	 * DEFS15_:
	 */
	@PropertyDef(label = "DEFS15_", description = "DEFS15_:")
	private String defs15;

	/**
	 * DEFB11_:
	 */
	@PropertyDef(label = "DEFB11_", description = "DEFB11_:")
	private BigDecimal defb11;

	/**
	 * DEFB12_:
	 */
	@PropertyDef(label = "DEFB12_", description = "DEFB12_:")
	private BigDecimal defb12;

	/**
	 * DEFB13_:
	 */
	@PropertyDef(label = "DEFB13_", description = "DEFB13_:")
	private BigDecimal defb13;

	/**
	 * DEFB14_:
	 */
	@PropertyDef(label = "DEFB14_", description = "DEFB14_:")
	private BigDecimal defb14;

	/**
	 * DEFB15_:
	 */
	@PropertyDef(label = "DEFB15_", description = "DEFB15_:")
	private BigDecimal defb15;

	public Tbdm01() {
		super();
	}

	public Tbdm01(String compId, String matrlNo, String inventoryType,
			String appearance, String priceMethod, String prodeType,
			String materailName, String grade, BigDecimal trick,
			BigDecimal width, BigDecimal lengthA, BigDecimal lengthB,
			BigDecimal diameter, String prodeCode, String materailSrc,
			String pdType, String createEmp, Date createDate, String updateEmp,
			Date updateDate, BigDecimal version, String bak1, String bak2,
			String bak3, String pkDm01, BigDecimal thickTolerance,
			BigDecimal lengthTolerance, BigDecimal widthTolerance,
			BigDecimal diameterOutTolerance, BigDecimal diameterInTolerance,
			BigDecimal diameterIn, String matrlDesc, String prodeName,
			String defs01, String defs03, String defs04, String defs05,
			BigDecimal defb01, BigDecimal defb02, BigDecimal defb03,
			BigDecimal defb04, BigDecimal defb05, String defn01, String defn02,
			String shape, String prodeNo, String defs11, String defs12,
			String defs13, String defs14, String defs15, BigDecimal defb11,
			BigDecimal defb12, BigDecimal defb13, BigDecimal defb14,
			BigDecimal defb15) {
		super();
		this.compId = compId;
		this.matrlNo = matrlNo;
		this.inventoryType = inventoryType;
		this.appearance = appearance;
		this.priceMethod = priceMethod;
		this.prodeType = prodeType;
		this.materailName = materailName;
		this.grade = grade;
		this.trick = trick;
		this.width = width;
		this.lengthA = lengthA;
		this.lengthB = lengthB;
		this.diameter = diameter;
		this.prodeCode = prodeCode;
		this.materailSrc = materailSrc;
		this.pdType = pdType;
		this.createEmp = createEmp;
		this.createDate = createDate;
		this.updateEmp = updateEmp;
		this.updateDate = updateDate;
		this.version = version;
		this.bak1 = bak1;
		this.bak2 = bak2;
		this.bak3 = bak3;
		this.pkDm01 = pkDm01;
		this.thickTolerance = thickTolerance;
		this.lengthTolerance = lengthTolerance;
		this.widthTolerance = widthTolerance;
		this.diameterOutTolerance = diameterOutTolerance;
		this.diameterInTolerance = diameterInTolerance;
		this.diameterIn = diameterIn;
		this.matrlDesc = matrlDesc;
		this.prodeName = prodeName;
		this.defs01 = defs01;
		this.defs03 = defs03;
		this.defs04 = defs04;
		this.defs05 = defs05;
		this.defb01 = defb01;
		this.defb02 = defb02;
		this.defb03 = defb03;
		this.defb04 = defb04;
		this.defb05 = defb05;
		this.defn01 = defn01;
		this.defn02 = defn02;
		this.shape = shape;
		this.prodeNo = prodeNo;
		this.defs11 = defs11;
		this.defs12 = defs12;
		this.defs13 = defs13;
		this.defs14 = defs14;
		this.defs15 = defs15;
		this.defb11 = defb11;
		this.defb12 = defb12;
		this.defb13 = defb13;
		this.defb14 = defb14;
		this.defb15 = defb15;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 10)
	public String getCompId() {
		return compId;
	}

	public void setMatrlNo(String matrlNo) {
		this.matrlNo = matrlNo;
	}

	@Column(name = "MATRL_NO_", length = 30)
	public String getMatrlNo() {
		return matrlNo;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	@Column(name = "INVENTORY_TYPE_", length = 4)
	public String getInventoryType() {
		return inventoryType;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	@Column(name = "APPEARANCE_", length = 4)
	public String getAppearance() {
		return appearance;
	}

	public void setPriceMethod(String priceMethod) {
		this.priceMethod = priceMethod;
	}

	@Column(name = "PRICE_METHOD_", length = 4)
	public String getPriceMethod() {
		return priceMethod;
	}

	public void setProdeType(String prodeType) {
		this.prodeType = prodeType;
	}

	@Column(name = "PRODE_TYPE_", length = 4)
	public String getProdeType() {
		return prodeType;
	}

	public void setMaterailName(String materailName) {
		this.materailName = materailName;
	}

	@Column(name = "MATERAIL_NAME_", length = 100)
	public String getMaterailName() {
		return materailName;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "GRADE_", length = 4)
	public String getGrade() {
		return grade;
	}

	public void setTrick(BigDecimal trick) {
		this.trick = trick;
	}

	@Column(name = "TRICK_")
	public BigDecimal getTrick() {
		return trick;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	@Column(name = "WIDTH_")
	public BigDecimal getWidth() {
		return width;
	}

	public void setLengthA(BigDecimal lengthA) {
		this.lengthA = lengthA;
	}

	@Column(name = "LENGTH_A_")
	public BigDecimal getLengthA() {
		return lengthA;
	}

	public void setLengthB(BigDecimal lengthB) {
		this.lengthB = lengthB;
	}

	@Column(name = "LENGTH_B_")
	public BigDecimal getLengthB() {
		return lengthB;
	}

	public void setDiameter(BigDecimal diameter) {
		this.diameter = diameter;
	}

	@Column(name = "DIAMETER_")
	public BigDecimal getDiameter() {
		return diameter;
	}

	public void setProdeCode(String prodeCode) {
		this.prodeCode = prodeCode;
	}

	@Column(name = "PRODE_CODE_", length = 4)
	public String getProdeCode() {
		return prodeCode;
	}

	public void setMaterailSrc(String materailSrc) {
		this.materailSrc = materailSrc;
	}

	@Column(name = "MATERAIL_SRC_", length = 10)
	public String getMaterailSrc() {
		return materailSrc;
	}

	public void setPdType(String pdType) {
		this.pdType = pdType;
	}

	@Column(name = "PD_TYPE_", length = 40)
	public String getPdType() {
		return pdType;
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

	public void setUpdateEmp(String updateEmp) {
		this.updateEmp = updateEmp;
	}

	@Column(name = "UPDATE_EMP_", length = 40)
	public String getUpdateEmp() {
		return updateEmp;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE_")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	@Column(name = "BAK1_", length = 50)
	public String getBak1() {
		return bak1;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	@Column(name = "BAK2_", length = 50)
	public String getBak2() {
		return bak2;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	@Column(name = "BAK3_", length = 50)
	public String getBak3() {
		return bak3;
	}

	public void setPkDm01(String pkDm01) {
		this.pkDm01 = pkDm01;
	}
	@Id
	@Column(name = "PK_DM01_", length = 40)
	public String getPkDm01() {
		return pkDm01;
	}

	public void setThickTolerance(BigDecimal thickTolerance) {
		this.thickTolerance = thickTolerance;
	}

	@Column(name = "THICK_TOLERANCE_")
	public BigDecimal getThickTolerance() {
		return thickTolerance;
	}

	public void setLengthTolerance(BigDecimal lengthTolerance) {
		this.lengthTolerance = lengthTolerance;
	}

	@Column(name = "LENGTH_TOLERANCE_")
	public BigDecimal getLengthTolerance() {
		return lengthTolerance;
	}

	public void setWidthTolerance(BigDecimal widthTolerance) {
		this.widthTolerance = widthTolerance;
	}

	@Column(name = "WIDTH_TOLERANCE_")
	public BigDecimal getWidthTolerance() {
		return widthTolerance;
	}

	public void setDiameterOutTolerance(BigDecimal diameterOutTolerance) {
		this.diameterOutTolerance = diameterOutTolerance;
	}

	@Column(name = "DIAMETER_OUT_TOLERANCE_")
	public BigDecimal getDiameterOutTolerance() {
		return diameterOutTolerance;
	}

	public void setDiameterInTolerance(BigDecimal diameterInTolerance) {
		this.diameterInTolerance = diameterInTolerance;
	}

	@Column(name = "DIAMETER_IN_TOLERANCE_")
	public BigDecimal getDiameterInTolerance() {
		return diameterInTolerance;
	}

	public void setDiameterIn(BigDecimal diameterIn) {
		this.diameterIn = diameterIn;
	}

	@Column(name = "DIAMETER_IN_")
	public BigDecimal getDiameterIn() {
		return diameterIn;
	}

	public void setMatrlDesc(String matrlDesc) {
		this.matrlDesc = matrlDesc;
	}

	@Column(name = "MATRL_DESC_", length = 200)
	public String getMatrlDesc() {
		return matrlDesc;
	}

	public void setProdeName(String prodeName) {
		this.prodeName = prodeName;
	}

	@Column(name = "PRODE_NAME_", length = 100)
	public String getProdeName() {
		return prodeName;
	}

	public void setDefs01(String defs01) {
		this.defs01 = defs01;
	}

	@Column(name = "DEFS01_", length = 20)
	public String getDefs01() {
		return defs01;
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

	@Column(name = "DEFS04", length = 20)
	public String getDefs04() {
		return defs04;
	}

	public void setDefs05(String defs05) {
		this.defs05 = defs05;
	}

	@Column(name = "DEFS05", length = 20)
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

	public void setDefn01(String defn01) {
		this.defn01 = defn01;
	}

	@Column(name = "DEFN01_", length = 200)
	public String getDefn01() {
		return defn01;
	}

	public void setDefn02(String defn02) {
		this.defn02 = defn02;
	}

	@Column(name = "DEFN02", length = 200)
	public String getDefn02() {
		return defn02;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Column(name = "SHAPE_", length = 4)
	public String getShape() {
		return shape;
	}

	public void setProdeNo(String prodeNo) {
		this.prodeNo = prodeNo;
	}

	@Column(name = "PRODE_NO_", length = 20)
	public String getProdeNo() {
		return prodeNo;
	}

	public void setDefs11(String defs11) {
		this.defs11 = defs11;
	}

	@Column(name = "DEFS11_", length = 40)
	public String getDefs11() {
		return defs11;
	}

	public void setDefs12(String defs12) {
		this.defs12 = defs12;
	}

	@Column(name = "DEFS12_", length = 40)
	public String getDefs12() {
		return defs12;
	}

	public void setDefs13(String defs13) {
		this.defs13 = defs13;
	}

	@Column(name = "DEFS13_", length = 40)
	public String getDefs13() {
		return defs13;
	}

	public void setDefs14(String defs14) {
		this.defs14 = defs14;
	}

	@Column(name = "DEFS14_", length = 40)
	public String getDefs14() {
		return defs14;
	}

	public void setDefs15(String defs15) {
		this.defs15 = defs15;
	}

	@Column(name = "DEFS15_", length = 40)
	public String getDefs15() {
		return defs15;
	}

	public void setDefb11(BigDecimal defb11) {
		this.defb11 = defb11;
	}

	@Column(name = "DEFB11_")
	public BigDecimal getDefb11() {
		return defb11;
	}

	public void setDefb12(BigDecimal defb12) {
		this.defb12 = defb12;
	}

	@Column(name = "DEFB12_")
	public BigDecimal getDefb12() {
		return defb12;
	}

	public void setDefb13(BigDecimal defb13) {
		this.defb13 = defb13;
	}

	@Column(name = "DEFB13_")
	public BigDecimal getDefb13() {
		return defb13;
	}

	public void setDefb14(BigDecimal defb14) {
		this.defb14 = defb14;
	}

	@Column(name = "DEFB14_")
	public BigDecimal getDefb14() {
		return defb14;
	}

	public void setDefb15(BigDecimal defb15) {
		this.defb15 = defb15;
	}

	@Column(name = "DEFB15_")
	public BigDecimal getDefb15() {
		return defb15;
	}

	public String toString() {
		return "Tbdm01 [compId=" + compId + ",matrlNo=" + matrlNo
				+ ",inventoryType=" + inventoryType + ",appearance="
				+ appearance + ",priceMethod=" + priceMethod + ",prodeType="
				+ prodeType + ",materailName=" + materailName + ",grade="
				+ grade + ",trick=" + trick + ",width=" + width + ",lengthA="
				+ lengthA + ",lengthB=" + lengthB + ",diameter=" + diameter
				+ ",prodeCode=" + prodeCode + ",materailSrc=" + materailSrc
				+ ",pdType=" + pdType + ",createEmp=" + createEmp
				+ ",createDate=" + createDate + ",updateEmp=" + updateEmp
				+ ",updateDate=" + updateDate + ",version=" + version
				+ ",bak1=" + bak1 + ",bak2=" + bak2 + ",bak3=" + bak3
				+ ",pkDm01=" + pkDm01 + ",thickTolerance=" + thickTolerance
				+ ",lengthTolerance=" + lengthTolerance + ",widthTolerance="
				+ widthTolerance + ",diameterOutTolerance="
				+ diameterOutTolerance + ",diameterInTolerance="
				+ diameterInTolerance + ",diameterIn=" + diameterIn
				+ ",matrlDesc=" + matrlDesc + ",prodeName=" + prodeName
				+ ",defs01=" + defs01 + ",defs03=" + defs03 + ",defs04="
				+ defs04 + ",defs05=" + defs05 + ",defb01=" + defb01
				+ ",defb02=" + defb02 + ",defb03=" + defb03 + ",defb04="
				+ defb04 + ",defb05=" + defb05 + ",defn01=" + defn01
				+ ",defn02=" + defn02 + ",shape=" + shape + ",prodeNo="
				+ prodeNo + ",defs11=" + defs11 + ",defs12=" + defs12
				+ ",defs13=" + defs13 + ",defs14=" + defs14 + ",defs15="
				+ defs15 + ",defb11=" + defb11 + ",defb12=" + defb12
				+ ",defb13=" + defb13 + ",defb14=" + defb14 + ",defb15="
				+ defb15 + "]";
	}

}
