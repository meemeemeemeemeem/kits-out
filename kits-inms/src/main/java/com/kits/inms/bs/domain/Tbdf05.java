package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBDF05: 单号计数档
 */
@Entity
@Table(name = "TBDF05")
public class Tbdf05 implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * COMP_ID_:
	 */
	@PropertyDef(label = "COMP_ID_", description = "COMP_ID_:")
	private String compId;
	/**
	 * NO_ID_:
	 */
	@PropertyDef(label = "NO_ID_", description = "NO_ID_:")
	private String noId;
	/**
	 * NO_STYLE_:
	 */
	@PropertyDef(label = "NO_STYLE_", description = "NO_STYLE_:")
	private String noStyle;
	/**
	 * NO_COUNT_:
	 */
	@PropertyDef(label = "NO_COUNT_", description = "NO_COUNT_:")
	private BigDecimal noCount;
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

	public Tbdf05() {
		super();
	}
	public Tbdf05(String compId, String noId, String noStyle,
			BigDecimal noCount, String createEmpNo, Date createDate,
			String modifyEmpNo, Date modifyDate) {
		super();
		this.compId = compId;
		this.noId = noId;
		this.noStyle = noStyle;
		this.noCount = noCount;
		this.createEmpNo = createEmpNo;
		this.createDate = createDate;
		this.modifyEmpNo = modifyEmpNo;
		this.modifyDate = modifyDate;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}
	@Id
	@Column(name = "COMP_ID_", length = 10, nullable = false)
	public String getCompId() {
		return compId;
	}

	public void setNoId(String noId) {
		this.noId = noId;
	}
	@Id
	@Column(name = "NO_ID_", length = 20, nullable = false)
	public String getNoId() {
		return noId;
	}

	public void setNoStyle(String noStyle) {
		this.noStyle = noStyle;
	}
	@Id
	@Column(name = "NO_STYLE_", length = 20, nullable = false)
	public String getNoStyle() {
		return noStyle;
	}

	public void setNoCount(BigDecimal noCount) {
		this.noCount = noCount;
	}
	@Column(name = "NO_COUNT_")
	public BigDecimal getNoCount() {
		return noCount;
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
		return "Tbdf05 [compId=" + compId + ",noId=" + noId + ",noStyle="
				+ noStyle + ",noCount=" + noCount + ",createEmpNo="
				+ createEmpNo + ",createDate=" + createDate + ",modifyEmpNo="
				+ modifyEmpNo + ",modifyDate=" + modifyDate + "]";
	}

}
