package com.kits.inms.bs.exception;


public class ApiException extends Exception {
    private String code;

    public ApiException() {
        this(ApiEnum.SERVER_ERROR);
    }

    public ApiException(ApiEnum apiEnum) {
        super(apiEnum.msg());
        code = apiEnum.code();
    }

    public ApiException(String msg) {
        super(msg);
        code = "500";
    }

    public ApiException(String msg, String code) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
