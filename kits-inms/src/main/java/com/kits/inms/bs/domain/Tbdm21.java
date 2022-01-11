package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TBDM21:
 */
@Entity
@Table(name = "TBDM21")
public class Tbdm21 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 公司别:??????
	 */
	@PropertyDef(label = "公司别", description = "公司别:??????")
	private String compId;

	/**
	 * 钢种代号:????????
	 */
	@PropertyDef(label = "钢种代号", description = "钢种代号:????????")
	private String matNo;

	/**
	 * 代码:????
	 */
	@PropertyDef(label = "代码", description = "代码:????")
	private String matItem;

	/**
	 * 流水号:??????
	 */
	@PropertyDef(label = "流水号", description = "流水号:??????")
	private String serNo;

	/**
	 * 材质名称:????????
	 */
	@PropertyDef(label = "材质名称", description = "材质名称:????????")
	private String specCode;

	/**
	 * 工艺大类:????????
	 */
	@PropertyDef(label = "工艺大类", description = "工艺大类:????????")
	private String prodType;

	public Tbdm21() {
		super();
	}

	public Tbdm21(String compId, String matNo, String matItem, String serNo,
			String specCode, String prodType) {
		super();
		this.compId = compId;
		this.matNo = matNo;
		this.matItem = matItem;
		this.serNo = serNo;
		this.specCode = specCode;
		this.prodType = prodType;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Id
	@Column(name = "COMP_ID_", length = 10, nullable = false)
	public String getCompId() {
		return compId;
	}

	public void setMatNo(String matNo) {
		this.matNo = matNo;
	}

	@Id
	@Column(name = "MAT_NO_", length = 5, nullable = false)
	public String getMatNo() {
		return matNo;
	}

	public void setMatItem(String matItem) {
		this.matItem = matItem;
	}

	@Id
	@Column(name = "MAT_ITEM_", length = 2, nullable = false)
	public String getMatItem() {
		return matItem;
	}

	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}

	@Id
	@Column(name = "SER_NO_", length = 4, nullable = false)
	public String getSerNo() {
		return serNo;
	}

	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}

	@Column(name = "SPEC_CODE_", length = 20)
	public String getSpecCode() {
		return specCode;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	@Column(name = "PROD_TYPE_", length = 1)
	public String getProdType() {
		return prodType;
	}

	public String toString() {
		return "Tbdm21 [compId=" + compId + ",matNo=" + matNo + ",matItem="
				+ matItem + ",serNo=" + serNo + ",specCode=" + specCode
				+ ",prodType=" + prodType + "]";
	}

}
