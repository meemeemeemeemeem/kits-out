package com.kits.inms.bs.domain;

import com.bstek.dorado.annotation.PropertyDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TBBS024:品名表
 */
@Entity
@Table(name = "TBBS024")
public class Tbbs024 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 品名表主键:品名表主键
	 */
	@PropertyDef(label = "品名表主键", description = "品名表主键:品名表主键")
	private String pkBs024;

	/**
	 * 商品编号:商品编号
	 */
	@PropertyDef(label = "商品编号", description = "商品编号:商品编号")
	private String productNo;

	/**
	 * 商品名称:商品名称
	 */
	@PropertyDef(label = "商品名称", description = "商品名称:商品名称")
	private String productName;

	/**
	 * 长度:长度
	 */
	@PropertyDef(label = "长度", description = "长度:长度")
	private BigDecimal length;

	/**
	 * 宽度:宽度
	 */
	@PropertyDef(label = "宽度", description = "宽度:宽度")
	private BigDecimal width;

	/**
	 * 厚度:厚度
	 */
	@PropertyDef(label = "厚度", description = "厚度:厚度")
	private BigDecimal thick;

	/**
	 * 内径:内径
	 */
	@PropertyDef(label = "内径", description = "内径:内径")
	private BigDecimal innerDiameter;

	/**
	 * 外径:外径
	 */
	@PropertyDef(label = "外径", description = "外径:外径")
	private BigDecimal outerDiameter;

	/**
	 * 技术标准:技术标准
	 */
	@PropertyDef(label = "技术标准", description = "技术标准:技术标准")
	private String techNorms;

	/**
	 * 材质:材质
	 */
	@PropertyDef(label = "材质", description = "材质:材质")
	private String texture;

	/**
	 * 质量标准:质量标准
	 */
	@PropertyDef(label = "质量标准", description = "质量标准:质量标准")
	private String qualNorms;

	/**
	 * 重量:重量
	 */
	@PropertyDef(label = "重量", description = "重量:重量")
	private BigDecimal invWgt;

	/**
	 * 用途:用途
	 */
	@PropertyDef(label = "用途", description = "用途:用途")
	private String purpose;

	/**
	 * 牌号:牌号
	 */
	@PropertyDef(label = "牌号", description = "牌号:牌号")
	private String shopSign;

	/**
	 * 备注说明:备注说明
	 */
	@PropertyDef(label = "备注说明", description = "备注说明:备注说明")
	private String desrc;

	/**
	 * 备用字段1:备用字段1
	 */
	@PropertyDef(label = "备用字段1", description = "备用字段1:备用字段1")
	private String defs01;

	/**
	 * 备用字段2:备用字段2
	 */
	@PropertyDef(label = "备用字段2", description = "备用字段2:备用字段2")
	private String defs02;

	/**
	 * 备用字段3:备用字段3
	 */
	@PropertyDef(label = "备用字段3", description = "备用字段3:备用字段3")
	private String defs03;

	/**
	 * 备用字段4:备用字段4
	 */
	@PropertyDef(label = "备用字段4", description = "备用字段4:备用字段4")
	private String defs04;

	/**
	 * 备用字段5:备用字段5
	 */
	@PropertyDef(label = "备用字段5", description = "备用字段5:备用字段5")
	private String defs05;

	/**
	 * 备用字段6:备用字段6
	 */
	@PropertyDef(label = "备用字段6", description = "备用字段6:备用字段6")
	private BigDecimal defb01;

	/**
	 * 备用字段7:备用字段7
	 */
	@PropertyDef(label = "备用字段7", description = "备用字段7:备用字段7")
	private BigDecimal defb02;

	/**
	 * 备用字段8:备用字段8
	 */
	@PropertyDef(label = "备用字段8", description = "备用字段8:备用字段8")
	private BigDecimal defb03;

	/**
	 * 备用字段9:备用字段9
	 */
	@PropertyDef(label = "备用字段9", description = "备用字段9:备用字段9")
	private BigDecimal defb04;

	/**
	 * 备用字段10:备用字段10
	 */
	@PropertyDef(label = "备用字段10", description = "备用字段10:备用字段10")
	private BigDecimal defb05;

	/**
	 * 状态:状态
	 */
	@PropertyDef(label = "状态", description = "状态:状态")
	private String status;

	/**
	 * 计价方式:计价方式
	 */
	@PropertyDef(label = "计价方式", description = "计价方式:计价方式")
	private String priceType;

	/**
	 * 计量单位:计量单位
	 */
	@PropertyDef(label = "计量单位", description = "计量单位:计量单位")
	private String meaUnit;

	/**
	 * 品名:品名
	 */
	@PropertyDef(label = "品名", description = "品名:品名")
	private String tradeName;

	public Tbbs024() {
		super();
	}

	public Tbbs024(String pkBs024, String productNo, String productName, BigDecimal length, BigDecimal width,
			BigDecimal thick, BigDecimal innerDiameter, BigDecimal outerDiameter, String techNorms, String texture,
			String qualNorms, BigDecimal invWgt, String purpose, String shopSign, String desrc, String defs01,
			String defs02, String defs03, String defs04, String defs05, BigDecimal defb01, BigDecimal defb02,
			BigDecimal defb03, BigDecimal defb04, BigDecimal defb05, String status, String priceType, String meaUnit,
			String tradeName) {
		super();
		this.pkBs024 = pkBs024;
		this.productNo = productNo;
		this.productName = productName;
		this.length = length;
		this.width = width;
		this.thick = thick;
		this.innerDiameter = innerDiameter;
		this.outerDiameter = outerDiameter;
		this.techNorms = techNorms;
		this.texture = texture;
		this.qualNorms = qualNorms;
		this.invWgt = invWgt;
		this.purpose = purpose;
		this.shopSign = shopSign;
		this.desrc = desrc;
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
		this.status = status;
		this.priceType = priceType;
		this.meaUnit = meaUnit;
		this.tradeName = tradeName;
	}

	public void setPkBs024(String pkBs024) {
		this.pkBs024 = pkBs024;
	}

	@Id
	@Column(name = "PK_BS024_", length = 40, nullable = false)
	public String getPkBs024() {
		return pkBs024;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	@Column(name = "PRODUCT_NO_", length = 20)
	public String getProductNo() {
		return productNo;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRODUCT_NAME_", length = 10)
	public String getProductName() {
		return productName;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	@Column(name = "LENGTH_")
	public BigDecimal getLength() {
		return length;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	@Column(name = "WIDTH_")
	public BigDecimal getWidth() {
		return width;
	}

	public void setThick(BigDecimal thick) {
		this.thick = thick;
	}

	@Column(name = "THICK_")
	public BigDecimal getThick() {
		return thick;
	}

	public void setInnerDiameter(BigDecimal innerDiameter) {
		this.innerDiameter = innerDiameter;
	}

	@Column(name = "INNER_DIAMETER_")
	public BigDecimal getInnerDiameter() {
		return innerDiameter;
	}

	public void setOuterDiameter(BigDecimal outerDiameter) {
		this.outerDiameter = outerDiameter;
	}

	@Column(name = "OUTER_DIAMETER_")
	public BigDecimal getOuterDiameter() {
		return outerDiameter;
	}

	public void setTechNorms(String techNorms) {
		this.techNorms = techNorms;
	}

	@Column(name = "TECH_NORMS_", length = 20)
	public String getTechNorms() {
		return techNorms;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	@Column(name = "TEXTURE_", length = 20)
	public String getTexture() {
		return texture;
	}

	public void setQualNorms(String qualNorms) {
		this.qualNorms = qualNorms;
	}

	@Column(name = "QUAL_NORMS_", length = 20)
	public String getQualNorms() {
		return qualNorms;
	}

	public void setInvWgt(BigDecimal invWgt) {
		this.invWgt = invWgt;
	}

	@Column(name = "INV_WGT_")
	public BigDecimal getInvWgt() {
		return invWgt;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "PURPOSE_", length = 20)
	public String getPurpose() {
		return purpose;
	}

	public void setShopSign(String shopSign) {
		this.shopSign = shopSign;
	}

	@Column(name = "SHOP_SIGN_", length = 20)
	public String getShopSign() {
		return shopSign;
	}

	public void setDesrc(String desrc) {
		this.desrc = desrc;
	}

	@Column(name = "DESRC_", length = 200)
	public String getDesrc() {
		return desrc;
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

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS_", length = 20)
	public String getStatus() {
		return status;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	@Column(name = "PRICE_TYPE_", length = 20)
	public String getPriceType() {
		return priceType;
	}

	public void setMeaUnit(String meaUnit) {
		this.meaUnit = meaUnit;
	}

	@Column(name = "MEA_UNIT_", length = 20)
	public String getMeaUnit() {
		return meaUnit;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	@Column(name = "TRADE_NAME_", length = 20)
	public String getTradeName() {
		return tradeName;
	}

	public String toString() {
		return "Tbbs024 [pkBs024=" + pkBs024 + ",productNo=" + productNo + ",productName=" + productName + ",length="
				+ length + ",width=" + width + ",thick=" + thick + ",innerDiameter=" + innerDiameter + ",outerDiameter="
				+ outerDiameter + ",techNorms=" + techNorms + ",texture=" + texture + ",qualNorms=" + qualNorms
				+ ",invWgt=" + invWgt + ",purpose=" + purpose + ",shopSign=" + shopSign + ",desrc=" + desrc + ",defs01="
				+ defs01 + ",defs02=" + defs02 + ",defs03=" + defs03 + ",defs04=" + defs04 + ",defs05=" + defs05
				+ ",defb01=" + defb01 + ",defb02=" + defb02 + ",defb03=" + defb03 + ",defb04=" + defb04 + ",defb05="
				+ defb05 + ",status=" + status + ",priceType=" + priceType + ",meaUnit=" + meaUnit + ",tradeName="
				+ tradeName + "]";
	}

}
