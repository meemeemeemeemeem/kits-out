package com.kits.inms.api.expection;

import com.kits.inms.bs.exception.ApiEnum;

/**
 * 自定义异常
 * @author 张成
 */
@SuppressWarnings("serial")
public class CheckException extends Exception {
    private String code;

    public CheckException() {
        this(ApiEnum.SERVER_ERROR);
    }
    public CheckException(ApiEnum apiEnum) {
        super(apiEnum.msg());
        code = apiEnum.code();
    }
    public CheckException(String msg) {
        super(msg);
        code = "500";
    }
    public CheckException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    
    
}