package com.kits.inms.api.entity;

public class BaseModel { 
    private String retcode;
    private String retmsg;
    private Object retId;
    private String dataInfo;
    
    
    public BaseModel() {
    	
    } 
    public BaseModel(String retcode, String retmsg) {
        this.retcode = retcode;
        this.retmsg = retmsg;
    }
    public BaseModel(String retcode, String retmsg, Object retId) {
        this.retcode = retcode;
        this.retmsg = retmsg;
        this.retId = retId;
    }
    public BaseModel(String retcode, String retmsg, Object retId, String dataInfo) {
        this.retcode = retcode;
        this.retmsg = retmsg;
        this.retId = retId;
        this.dataInfo = dataInfo;
    }
    
    
    public String getRetcode() {
        return retcode;
    }
    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }
    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }
    
    public Object getRetId() {
        return retId;
    }
    public void setRetId(Object retId) {
        this.retId = retId;
    }

    public String getDataInfo() {
        return dataInfo;
    }
    public void setDataInfo(String dataInfo) {
        this.dataInfo = dataInfo;
    }
    
    
    
}