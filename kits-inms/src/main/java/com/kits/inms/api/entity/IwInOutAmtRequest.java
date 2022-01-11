package com.kits.inms.api.entity;

public class IwInOutAmtRequest {  
    private Integer opttyp;//1入金，2出金，3.保证金入金，4.保证金出金
    @ColumnVerify(name="会员代码",nullable=false,maxlen=50)
    private String mbcode;
    @ColumnVerify(name="会员名称",maxlen=250)
    private String mbname;
    @ColumnVerify(name="收款单编号",nullable=false,maxlen=30)
    private String posnum;
    @ColumnVerify(name="转账金额",nullable=false)
    private Double amt;
    @ColumnVerify(name="备注")
    private String remark;
    
    
    public Integer getOpttyp() {
        return opttyp;
    }
    public void setOpttyp(Integer opttyp) {
        this.opttyp = opttyp;
    }
    
    public String getMbcode() {
        return mbcode;
    }
    public void setMbcode(String mbcode) {
        this.mbcode = mbcode;
    }
    
    public String getMbname() {
        return mbname;
    }
    public void setMbname(String mbname) {
        this.mbname = mbname;
    }
    
    public String getPosnum() {
        return posnum;
    }
    public void setPosnum(String posnum) {
        this.posnum = posnum;
    }
    
    public Double getAmt() {
        return amt;
    }
    public void setAmt(Double amt) {
        this.amt = amt;
    }
    
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
    
}