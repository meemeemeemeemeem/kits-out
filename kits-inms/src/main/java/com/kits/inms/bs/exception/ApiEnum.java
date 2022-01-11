package com.kits.inms.bs.exception;

public enum ApiEnum {
    //200是服务正常
    SUCCESSFUL("200", "操作成功！"),
    //500是服务端异常
    SERVER_ERROR("500", "服务端异常！"),
    //400是客户端异常
    CLIENT_ERROR("400", "客户端异常！"),
    
    //400开头的是客户端请求参数方面的异常
    PARAMETER_MISS_OR_TYPEERROR_CODE("40401", "参数缺失或者参数类型错误！"),
    NOTFOUNT_DATA_CODE("40402", "没有查询到相关信息！"),
    DATA_OPERATIONED_OR_NORIGHT_CODE("40403", "当前业务数据已经被操作或者无权操作！"),
    CLASS_CAST_CODE("40404", "数据格式转换失败！"),
    REQUEST_THIRDPARTY_CODE("40405", "请求第三方系统失败！"),
    NOT_NULL_CODE("40406", "数据非NULL校验失败！"),
    LENGTH_CHECK_CODE("40407", "数据长度校验失败！"),
    NEGATIVE_CHECK_CODE("40408", "数据正负值校验失败！"),
    STATUS_CHECK_CODE("40409", "状态码校验失败！"),
    DATE_START_END_CHECK_CODE("40410", "起止时间校验失败！"),
    CONNECTION_TIMEOUT_CODE("40499", "连接超时！");

    private String code;
    private String msg;

    ApiEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
    
    
    
}