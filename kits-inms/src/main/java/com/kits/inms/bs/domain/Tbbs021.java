package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBBS021:品名维护数据表
 */
@Entity
@Table(name = "TBBS021")
public class Tbbs021 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * PK_BS021_:
	 */
	@PropertyDef(label = "PK_BS021_", description = "PK_BS021_:")
	private String pkBs021;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;

	/**
	 * 代码:代码
	 */
	@PropertyDef(label = "代码", description = "代码:代码")
	private String prodeNo;

	/**
	 * 名称:名称
	 */
	@PropertyDef(label = "名称", description = "名称:名称")
	private String prodeName;

	/**
	 * 描述:描述
	 */
	@PropertyDef(label = "描述", description = "描述:描述")
	private String prodeDesc;

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
	 * DEFS01:
	 */
	@PropertyDef(label = "DEFS01", description = "DEFS01:")
	private String defs01;

	/**
	 * DEFS02:
	 */
	@PropertyDef(label = "DEFS02", description = "DEFS02:")
	private String defs02;

	/**
	 * DEFS03:
	 */
	@PropertyDef(label = "DEFS03", description = "DEFS03:")
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
	 * DEFM01:
	 */
	@PropertyDef(label = "DEFM01", description = "DEFM01:")
	private String defm01;

	/**
	 * DEFM02:
	 */
	@PropertyDef(label = "DEFM02", description = "DEFM02:")
	private String defm02;

	/**
	 * PID_:
	 */
	@PropertyDef(label = "PID_", description = "PID_:")
	private String pid;

	/**
	 * PID1_:
	 */
	@PropertyDef(label = "PID1_", description = "PID1_:")
	private String pid1;

	/**
	 * PID2_:
	 */
	@PropertyDef(label = "PID2_", description = "PID2_:")
	private String pid2;

	/**
	 * PID3_:
	 */
	@PropertyDef(label = "PID3_", description = "PID3_:")
	private String pid3;

	/**
	 * PID4_:
	 */
	@PropertyDef(label = "PID4_", description = "PID4_:")
	private String pid4;

	/**
	 * PID5_:
	 */
	@PropertyDef(label = "PID5_", description = "PID5_:")
	private String pid5;

	public Tbbs021() {
		super();
	}

	public Tbbs021(String pkBs021, String compId, String prodeNo, String prodeName, String prodeDesc, String createEmp,
			Date createDate, String updEmp, Date updDate, String defs01, String defs02, String defs03, String defs04,
			String defs05, BigDecimal defb01, BigDecimal defb02, BigDecimal defb03, BigDecimal defb04,
			BigDecimal defb05, String defm01, String defm02, String pid, String pid1, String pid2, String pid3,
			String pid4, String pid5) {
		super();
		this.pkBs021 = pkBs021;
		this.compId = compId;
		this.prodeNo = prodeNo;
		this.prodeName = prodeName;
		this.prodeDesc = prodeDesc;
		this.createEmp = createEmp;
		this.createDate = createDate;
		this.updEmp = updEmp;
		this.updDate = updDate;
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
		this.pid = pid;
		this.pid1 = pid1;
		this.pid2 = pid2;
		this.pid3 = pid3;
		this.pid4 = pid4;
		this.pid5 = pid5;
	}

	public void setPkBs021(String pkBs021) {
		this.pkBs021 = pkBs021;
	}

	@Id
	@Column(name = "PK_BS021_", length = 40, nullable = false)
	public String getPkBs021() {
		return pkBs021;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "COMP_ID_", length = 40)
	public String getCompId() {
		return compId;
	}

	public void setProdeNo(String prodeNo) {
		this.prodeNo = prodeNo;
	}

	@Column(name = "PRODE_NO_", length = 20)
	public String getProdeNo() {
		return prodeNo;
	}

	public void setProdeName(String prodeName) {
		this.prodeName = prodeName;
	}

	@Column(name = "PRODE_NAME_", length = 40)
	public String getProdeName() {
		return prodeName;
	}

	public void setProdeDesc(String prodeDesc) {
		this.prodeDesc = prodeDesc;
	}

	@Column(name = "PRODE_DESC_", length = 100)
	public String getProdeDesc() {
		return prodeDesc;
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

	public void setUpdEmp(String updEmp) {
		this.updEmp = updEmp;
	}

	@Column(name = "UPD_EMP_", length = 40)
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

	public void setDefs01(String defs01) {
		this.defs01 = defs01;
	}

	@Column(name = "DEFS01", length = 40)
	public String getDefs01() {
		return defs01;
	}

	public void setDefs02(String defs02) {
		this.defs02 = defs02;
	}

	@Column(name = "DEFS02", length = 40)
	public String getDefs02() {
		return defs02;
	}

	public void setDefs03(String defs03) {
		this.defs03 = defs03;
	}

	@Column(name = "DEFS03", length = 40)
	public String getDefs03() {
		return defs03;
	}

	public void setDefs04(String defs04) {
		this.defs04 = defs04;
	}

	@Column(name = "DEFS04", length = 40)
	public String getDefs04() {
		return defs04;
	}

	public void setDefs05(String defs05) {
		this.defs05 = defs05;
	}

	@Column(name = "DEFS05", length = 40)
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

	public void setDefm01(String defm01) {
		this.defm01 = defm01;
	}

	@Column(name = "DEFM01", length = 200)
	public String getDefm01() {
		return defm01;
	}

	public void setDefm02(String defm02) {
		this.defm02 = defm02;
	}

	@Column(name = "DEFM02", length = 200)
	public String getDefm02() {
		return defm02;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "PID_", length = 20)
	public String getPid() {
		return pid;
	}

	public void setPid1(String pid1) {
		this.pid1 = pid1;
	}

	@Column(name = "PID1_", length = 20)
	public String getPid1() {
		return pid1;
	}

	public void setPid2(String pid2) {
		this.pid2 = pid2;
	}

	@Column(name = "PID2_", length = 20)
	public String getPid2() {
		return pid2;
	}

	public void setPid3(String pid3) {
		this.pid3 = pid3;
	}

	@Column(name = "PID3_", length = 20)
	public String getPid3() {
		return pid3;
	}

	public void setPid4(String pid4) {
		this.pid4 = pid4;
	}

	@Column(name = "PID4_", length = 20)
	public String getPid4() {
		return pid4;
	}

	public void setPid5(String pid5) {
		this.pid5 = pid5;
	}

	@Column(name = "PID5_", length = 20)
	public String getPid5() {
		return pid5;
	}

	public String toString() {
		return "Tbbs021 [pkBs021=" + pkBs021 + ",compId=" + compId + ",prodeNo=" + prodeNo + ",prodeName=" + prodeName
				+ ",prodeDesc=" + prodeDesc + ",createEmp=" + createEmp + ",createDate=" + createDate + ",updEmp="
				+ updEmp + ",updDate=" + updDate + ",defs01=" + defs01 + ",defs02=" + defs02 + ",defs03=" + defs03
				+ ",defs04=" + defs04 + ",defs05=" + defs05 + ",defb01=" + defb01 + ",defb02=" + defb02 + ",defb03="
				+ defb03 + ",defb04=" + defb04 + ",defb05=" + defb05 + ",defm01=" + defm01 + ",defm02=" + defm02
				+ ",pid=" + pid + ",pid1=" + pid1 + ",pid2=" + pid2 + ",pid3=" + pid3 + ",pid4=" + pid4 + ",pid5="
				+ pid5 + "]";
	}

}
