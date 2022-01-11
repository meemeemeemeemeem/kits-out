package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TBDF03:单号主档
 */
@Entity
@Table(name = "TBDF03")
public class Tbdf03 implements Serializable {
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
	 * NO_DESC_:
	 */
	@PropertyDef(label = "NO_DESC_", description = "NO_DESC_:")
	private String noDesc;
	/**
	 * GROUP_ID_:
	 */
	@PropertyDef(label = "GROUP_ID_", description = "GROUP_ID_:")
	private String groupId;
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

	public Tbdf03() {
		super();
	}
	public Tbdf03(String compId, String noId, String noDesc, String groupId,
			String createEmpNo, Date createDate, String modifyEmpNo,
			Date modifyDate) {
		super();
		this.compId = compId;
		this.noId = noId;
		this.noDesc = noDesc;
		this.groupId = groupId;
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

	public void setNoDesc(String noDesc) {
		this.noDesc = noDesc;
	}
	@Column(name = "NO_DESC_", length = 100)
	public String getNoDesc() {
		return noDesc;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	@Column(name = "GROUP_ID_", length = 20)
	public String getGroupId() {
		return groupId;
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
		return "Tbdf03 [compId=" + compId + ",noId=" + noId + ",noDesc="
				+ noDesc + ",groupId=" + groupId + ",createEmpNo="
				+ createEmpNo + ",createDate=" + createDate + ",modifyEmpNo="
				+ modifyEmpNo + ",modifyDate=" + modifyDate + "]";
	}

}
