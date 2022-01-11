package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBPRODUCTIONMILL:机组维护
 */
@Entity
@Table(name = "TBPRODUCTIONMILL")
public class Tbproductionmill implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机组维护主键:机组维护主键
	 */
	@PropertyDef(label = "机组维护主键", description = "机组维护主键:机组维护主键")
	private String pkProductionMill;

	/**
	 * 公司别:公司别
	 */
	@PropertyDef(label = "公司别", description = "公司别:公司别")
	private String compId;

	/**
	 * 机组编号:机组编号
	 */
	@PropertyDef(label = "机组编号", description = "机组编号:机组编号")
	private String pdMillNo;

	/**
	 * 机组名称:机组名称
	 */
	@PropertyDef(label = "机组名称", description = "机组名称:机组名称")
	private String pdMillName;

	/**
	 * 机组类别:机组类别
	 */
	@PropertyDef(label = "机组类别", description = "机组类别:机组类别")
	private String pdMillType;

	/**
	 * 负责人:负责人
	 */
	@PropertyDef(label = "负责人", description = "负责人:负责人")
	private String responsibleEmp;

	/**
	 * 联系电话:联系电话
	 */
	@PropertyDef(label = "联系电话", description = "联系电话:联系电话")
	private String constactNumber;

	/**
	 * 新增人员:新增人员
	 */
	@PropertyDef(label = "新增人员", description = "新增人员:新增人员")
	private String createEmpNo;

	/**
	 * 新增日期:新增日期
	 */
	@PropertyDef(label = "新增日期", description = "新增日期:新增日期")
	private Date createDate;

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

	public Tbproductionmill() {
		super();
	}

	public Tbproductionmill(String pkProductionMill, String compId,
			String pdMillNo, String pdMillName, String pdMillType,
			String responsibleEmp, String constactNumber, String createEmpNo,
			Date createDate, String modifyEmpNo, Date modifyDate,
			String defs01, String defs02, String defs03, String defs04,
			String defs05, BigDecimal defb01, BigDecimal defb02,
			BigDecimal defb03, BigDecimal defb04, BigDecimal defb05,
			String defm01, String defm02) {
		super();
		this.pkProductionMill = pkProductionMill;
		this.compId = compId;
		this.pdMillNo = pdMillNo;
		this.pdMillName = pdMillName;
		this.pdMillType = pdMillType;
		this.responsibleEmp = responsibleEmp;
		this.constactNumber = constactNumber;
		this.createEmpNo = createEmpNo;
		this.createDate = createDate;
		this.modifyEmpNo = modifyEmpNo;
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

	public void setPkProductionMill(String pkProductionMill) {
		this.pkProductionMill = pkProductionMill;
	}

	@Id
	@Column(name = "PK_PRODUCTION_MILL_", length = 40, nullable = false)
	public String getPkProductionMill() {
		return pkProductionMill;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 10)
	public String getCompId() {
		return compId;
	}

	public void setPdMillNo(String pdMillNo) {
		this.pdMillNo = pdMillNo;
	}

	@Column(name = "PD_MILL_NO_", length = 10)
	public String getPdMillNo() {
		return pdMillNo;
	}

	public void setPdMillName(String pdMillName) {
		this.pdMillName = pdMillName;
	}

	@Column(name = "PD_MILL_NAME_", length = 100)
	public String getPdMillName() {
		return pdMillName;
	}

	public void setPdMillType(String pdMillType) {
		this.pdMillType = pdMillType;
	}

	@Column(name = "PD_MILL_TYPE_", length = 4)
	public String getPdMillType() {
		return pdMillType;
	}

	public void setResponsibleEmp(String responsibleEmp) {
		this.responsibleEmp = responsibleEmp;
	}

	@Column(name = "RESPONSIBLE_EMP_", length = 20)
	public String getResponsibleEmp() {
		return responsibleEmp;
	}

	public void setConstactNumber(String constactNumber) {
		this.constactNumber = constactNumber;
	}

	@Column(name = "CONSTACT_NUMBER_", length = 20)
	public String getConstactNumber() {
		return constactNumber;
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
		return "Tbproductionmill [pkProductionMill=" + pkProductionMill
				+ ",compId=" + compId + ",pdMillNo=" + pdMillNo
				+ ",pdMillName=" + pdMillName + ",pdMillType=" + pdMillType
				+ ",responsibleEmp=" + responsibleEmp + ",constactNumber="
				+ constactNumber + ",createEmpNo=" + createEmpNo
				+ ",createDate=" + createDate + ",modifyEmpNo=" + modifyEmpNo
				+ ",modifyDate=" + modifyDate + ",defs01=" + defs01
				+ ",defs02=" + defs02 + ",defs03=" + defs03 + ",defs04="
				+ defs04 + ",defs05=" + defs05 + ",defb01=" + defb01
				+ ",defb02=" + defb02 + ",defb03=" + defb03 + ",defb04="
				+ defb04 + ",defb05=" + defb05 + ",defm01=" + defm01
				+ ",defm02=" + defm02 + "]";
	}

}
