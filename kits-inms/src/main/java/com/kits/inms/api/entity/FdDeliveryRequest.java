package com.kits.inms.api.entity;

import java.util.Date;

/**
 * 一期电商采购订单（挂网销售）接口映射实体类
 * @author 张成
 */
public class FdDeliveryRequest {
    @ColumnVerify(name="id",nullable=false,maxlen=32)
    private String compid;
    @ColumnVerify(name="操作标识",nullable=false,maxlen=30)
    private String actionflag;
    @ColumnVerify(name="操作类型",nullable=false,maxlen=30)
    private String actiontype;
    @ColumnVerify(name="系统键",nullable=false,maxlen=30)
    private String dataid;
    @ColumnVerify(name="合同类型",nullable=false,maxlen=30)
    private String contracttype;
    @ColumnVerify(name="提单编号",nullable=false,maxlen=32)
    private String deliveryno;
    @ColumnVerify(name="合同编号",nullable=false,maxlen=32)
    private String contractno;
    @ColumnVerify(name="货主编码",nullable=false,maxlen=30)
    private String hzdm;
    @ColumnVerify(name="客商编码",nullable=false,maxlen=30)
    private String vendorno;
    @ColumnVerify(name="合同总金额",nullable=false)
    private Double contractamt;
    @ColumnVerify(name="付款方式",nullable=false,maxlen=80)
    private String paymethod;
    @ColumnVerify(name="付款金额",nullable=false)
    private Double payamt;
    @ColumnVerify(name="收款银行账号")
    private String bankaccount;
    @ColumnVerify(name="银行流水号")
    private String serialnumber;
    @ColumnVerify(name="操作人",nullable=false,maxlen=30)
    private String operatorcode;
    @ColumnVerify(name="操作日期")
    private Date operatdate;
	
    public String getCompid() {
		return compid;
	}
	public void setCompid(String compid) {
		this.compid = compid;
	}
	
	public String getActionflag() {
		return actionflag;
	}
	public void setActionflag(String actionflag) {
		this.actionflag = actionflag;
	}
	
	public String getActiontype() {
		return actiontype;
	}
	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}
	
	public String getDataid() {
		return dataid;
	}
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	
	public String getContracttype() {
		return contracttype;
	}
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}
	
	public String getDeliveryno() {
		return deliveryno;
	}
	public void setDeliveryno(String deliveryno) {
		this.deliveryno = deliveryno;
	}
	
	public String getContractno() {
		return contractno;
	}
	public void setContractno(String contractno) {
		this.contractno = contractno;
	}
	
	public String getHzdm() {
		return hzdm;
	}
	public void setHzdm(String hzdm) {
		this.hzdm = hzdm;
	}
	
	public String getVendorno() {
		return vendorno;
	}
	public void setVendorno(String vendorno) {
		this.vendorno = vendorno;
	}
	
	public Double getContractamt() {
		return contractamt;
	}
	public void setContractamt(Double contractamt) {
		this.contractamt = contractamt;
	}
	
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	
	public Double getPayamt() {
		return payamt;
	}
	public void setPayamt(Double payamt) {
		this.payamt = payamt;
	}
	
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	
	public String getOperatorcode() {
		return operatorcode;
	}
	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	}
	
	public Date getOperatdate() {
		return operatdate;
	}
	public void setOperatdate(Date operatdate) {
		this.operatdate = operatdate;
	}
    
    
	
	//private Integer sfbz;  //收费标准：1.只收服务费，2.只收提单费。3.即收服务费又收提单费。整体逻辑待编写
    /** 
     * 资源属性：判断
     * 1：金贸同步(从贸易系统同步过来)
     * 2：三方挂牌(EC非金贸会员挂牌)
     * 3：金贸会员挂牌(EC金贸会员挂牌)
     * 4：仓单同步(从仓储系统同步过来)
     * 5：代销会员挂牌(EC代销会员挂牌)
     * 6：第三方仓单同步(从仓储系统同步过来)
     */
	/*public Integer getSfbz() {
		return sfbz;
	}
	public void setSfbz(Integer sfbz) {
		this.sfbz = sfbz;
	} */
}