package com.kits.inms.api.entity;

@SuppressWarnings("serial")
public class HttpClientException extends RuntimeException {
    public int code = 0;
    
    public HttpClientException(String format) {
        super(format);
    }

    HttpClientException(int code, String msg) {
        super(msg);
        this.code = code;
    }
    
    public static void throwHttpClientException(String msg) {
        throw new HttpClientException(msg);
    }
    
    
    
}