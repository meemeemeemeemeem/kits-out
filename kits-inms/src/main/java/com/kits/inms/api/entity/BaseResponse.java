package com.kits.inms.api.entity;

import com.kits.inms.bs.exception.ApiEnum;

/**
 * 统一返回实体类
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> {
	//状态码
	private String code;
	//描述信息
	private String msg;
	//响应数据
	private T data;
	
	public BaseResponse() {
		
	}
	public BaseResponse(ApiEnum apiEnum) {
		this.code = apiEnum.code();
		this.msg = apiEnum.msg();
	}
	public BaseResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public BaseResponse(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public String getCode() {
		if (code == null)
			return "";
		else
			return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		if (msg == null)
			return "";
		else
			return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
    @Override
    public String toString() {
        return "BaseResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    
    
    
}