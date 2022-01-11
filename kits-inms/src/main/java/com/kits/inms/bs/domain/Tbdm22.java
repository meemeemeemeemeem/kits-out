package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TBDM22:
 */
@Entity
@Table(name = "TBDM22")
public class Tbdm22 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 钢种代号:????????
	 */
	@PropertyDef(label = "钢种代号", description = "钢种代号:????????")
	private String matNo;

	/**
	 * 钢种名称:????????
	 */
	@PropertyDef(label = "钢种名称", description = "钢种名称:????????")
	private String matName;

	/**
	 * 代码:????
	 */
	@PropertyDef(label = "代码", description = "代码:????")
	private String matItem;

	public Tbdm22() {
		super();
	}

	public Tbdm22(String matNo, String matName, String matItem) {
		super();
		this.matNo = matNo;
		this.matName = matName;
		this.matItem = matItem;
	}

	public void setMatNo(String matNo) {
		this.matNo = matNo;
	}

	@Id
	@Column(name = "MAT_NO_", length = 5, nullable = false)
	public String getMatNo() {
		return matNo;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	@Column(name = "MAT_NAME_", length = 30)
	public String getMatName() {
		return matName;
	}

	public void setMatItem(String matItem) {
		this.matItem = matItem;
	}

	@Id
	@Column(name = "MAT_ITEM_", length = 2, nullable = false)
	public String getMatItem() {
		return matItem;
	}

	public String toString() {
		return "Tbdm22 [matNo=" + matNo + ",matName=" + matName + ",matItem="
				+ matItem + "]";
	}

}
