package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBPROCESSROUTE:工艺路线主档
 */
@Entity
@Table(name = "TBPROCESSROUTE")
public class Tbprocessroute implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 工艺路线主档键值:工艺路线主档键值
	 */
	@PropertyDef(label = "工艺路线主档键值", description = "工艺路线主档键值:工艺路线主档键值")
	private String pkProcessRoute;

	/**
	 * 公司别:公司别
	 */
	@PropertyDef(label = "公司别", description = "公司别:公司别")
	private String compId;

	/**
	 * 工艺路线类别:工艺路线类别
	 */
	@PropertyDef(label = "工艺路线类别", description = "工艺路线类别:工艺路线类别")
	private String processRouteType;

	/**
	 * 工艺路线编码:工艺路线编码
	 */
	@PropertyDef(label = "工艺路线编码", description = "工艺路线编码:工艺路线编码")
	private String processRouteNo;

	/**
	 * 工艺路线说明:工艺路线说明
	 */
	@PropertyDef(label = "工艺路线说明", description = "工艺路线说明:工艺路线说明")
	private String processRouteDesc;

	/**
	 * 创建人员:创建人员
	 */
	@PropertyDef(label = "创建人员", description = "创建人员:创建人员")
	private String createEmpNo;

	/**
	 * 创建日期:创建日期
	 */
	@PropertyDef(label = "创建日期", description = "创建日期:创建日期")
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

	public Tbprocessroute() {
		super();
	}

	public Tbprocessroute(Object[] args){
		super();
		this.setPkProcessRoute((String) args[1]);
		this.setCompId((String) args[2]);
		this.setProcessRouteType((String) args[3]);
		this.setProcessRouteNo((String) args[4]);
		this.setProcessRouteDesc((String) args[5]);
		this.setCreateEmpNo((String) args[6]);
		this.setCreateDate((Date) args[7]);
		this.setModifyEmpNo((String) args[8]);
		this.setModifyDate((Date) args[9]);
		this.setDefs01((String) args[10]);
		this.setDefs02((String) args[11]);
		this.setDefs03((String) args[12]);
		this.setDefs04((String) args[13]);
		this.setDefs05((String) args[14]);
		this.setDefb01((BigDecimal) args[15]);
		this.setDefb02((BigDecimal) args[16]);
		this.setDefb03((BigDecimal) args[17]);
		this.setDefb04((BigDecimal) args[18]);
		this.setDefb05((BigDecimal) args[19]);
		this.setDefm01((String) args[20]);
		this.setDefm02((String) args[21]);
	}

	public Tbprocessroute(String pkProcessRoute, String compId,
			String processRouteType, String processRouteNo,
			String processRouteDesc, String createEmpNo, Date createDate,
			String modifyEmpNo, Date modifyDate, String defs01, String defs02,
			String defs03, String defs04, String defs05, BigDecimal defb01,
			BigDecimal defb02, BigDecimal defb03, BigDecimal defb04,
			BigDecimal defb05, String defm01, String defm02) {
		super();
		this.pkProcessRoute = pkProcessRoute;
		this.compId = compId;
		this.processRouteType = processRouteType;
		this.processRouteNo = processRouteNo;
		this.processRouteDesc = processRouteDesc;
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

	public void setPkProcessRoute(String pkProcessRoute) {
		this.pkProcessRoute = pkProcessRoute;
	}

	@Id
	@Column(name = "PK_PROCESS_ROUTE_", length = 40, nullable = false)
	public String getPkProcessRoute() {
		return pkProcessRoute;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 10)
	public String getCompId() {
		return compId;
	}

	public void setProcessRouteType(String processRouteType) {
		this.processRouteType = processRouteType;
	}

	@Column(name = "PROCESS_ROUTE_TYPE_", length = 2)
	public String getProcessRouteType() {
		return processRouteType;
	}

	public void setProcessRouteNo(String processRouteNo) {
		this.processRouteNo = processRouteNo;
	}

	@Column(name = "PROCESS_ROUTE_NO_", length = 5)
	public String getProcessRouteNo() {
		return processRouteNo;
	}

	public void setProcessRouteDesc(String processRouteDesc) {
		this.processRouteDesc = processRouteDesc;
	}

	@Column(name = "PROCESS_ROUTE_DESC_", length = 100)
	public String getProcessRouteDesc() {
		return processRouteDesc;
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
		return "Tbprocessroute [pkProcessRoute=" + pkProcessRoute + ",compId="
				+ compId + ",processRouteType=" + processRouteType
				+ ",processRouteNo=" + processRouteNo + ",processRouteDesc="
				+ processRouteDesc + ",createEmpNo=" + createEmpNo
				+ ",createDate=" + createDate + ",modifyEmpNo=" + modifyEmpNo
				+ ",modifyDate=" + modifyDate + ",defs01=" + defs01
				+ ",defs02=" + defs02 + ",defs03=" + defs03 + ",defs04="
				+ defs04 + ",defs05=" + defs05 + ",defb01=" + defb01
				+ ",defb02=" + defb02 + ",defb03=" + defb03 + ",defb04="
				+ defb04 + ",defb05=" + defb05 + ",defm01=" + defm01
				+ ",defm02=" + defm02 + "]";
	}

}
