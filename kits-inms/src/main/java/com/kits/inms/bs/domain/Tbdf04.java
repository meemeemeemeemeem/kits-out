package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TBDF04: 单号规则档

 */
@Entity
@Table(name = "TBDF04")
public class Tbdf04 implements Serializable {
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
	 * RULE_ID_:
	 */
	@PropertyDef(label = "RULE_ID_", description = "RULE_ID_:")
	private String ruleId;
	/**
	 * RULE_DESC_:
	 */
	@PropertyDef(label = "RULE_DESC_", description = "RULE_DESC_:")
	private String ruleDesc;
	/**
	 * RULE_TYPE_:
	 */
	@PropertyDef(label = "RULE_TYPE_", description = "RULE_TYPE_:")
	private String ruleType;
	/**
	 * RULE_LENGTH_:
	 */
	@PropertyDef(label = "RULE_LENGTH_", description = "RULE_LENGTH_:")
	private BigDecimal ruleLength;
	/**
	 * RULE_CONSTANT_:
	 */
	@PropertyDef(label = "RULE_CONSTANT_", description = "RULE_CONSTANT_:")
	private String ruleConstant;
	/**
	 * RULE_RENEW_:
	 */
	@PropertyDef(label = "RULE_RENEW_", description = "RULE_RENEW_:")
	private String ruleRenew;
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

	public Tbdf04() {
		super();
	}
	public Tbdf04(String compId, String noId, String ruleId, String ruleDesc,
			String ruleType, BigDecimal ruleLength, String ruleConstant,
			String ruleRenew, String createEmpNo, Date createDate,
			String modifyEmpNo, Date modifyDate) {
		super();
		this.compId = compId;
		this.noId = noId;
		this.ruleId = ruleId;
		this.ruleDesc = ruleDesc;
		this.ruleType = ruleType;
		this.ruleLength = ruleLength;
		this.ruleConstant = ruleConstant;
		this.ruleRenew = ruleRenew;
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

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	@Id
	@Column(name = "RULE_ID_", length = 2, nullable = false)
	public String getRuleId() {
		return ruleId;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	@Column(name = "RULE_DESC_", length = 100)
	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	@Column(name = "RULE_TYPE_", length = 5)
	public String getRuleType() {
		return ruleType;
	}

	public void setRuleLength(BigDecimal ruleLength) {
		this.ruleLength = ruleLength;
	}
	@Column(name = "RULE_LENGTH_")
	public BigDecimal getRuleLength() {
		return ruleLength;
	}

	public void setRuleConstant(String ruleConstant) {
		this.ruleConstant = ruleConstant;
	}
	@Column(name = "RULE_CONSTANT_", length = 20)
	public String getRuleConstant() {
		return ruleConstant;
	}

	public void setRuleRenew(String ruleRenew) {
		this.ruleRenew = ruleRenew;
	}
	@Column(name = "RULE_RENEW_", length = 1)
	public String getRuleRenew() {
		return ruleRenew;
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
		return "Tbdf04 [compId=" + compId + ",noId=" + noId + ",ruleId="
				+ ruleId + ",ruleDesc=" + ruleDesc + ",ruleType=" + ruleType
				+ ",ruleLength=" + ruleLength + ",ruleConstant=" + ruleConstant
				+ ",ruleRenew=" + ruleRenew + ",createEmpNo=" + createEmpNo
				+ ",createDate=" + createDate + ",modifyEmpNo=" + modifyEmpNo
				+ ",modifyDate=" + modifyDate + "]";
	}

}
