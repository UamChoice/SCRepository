package com.example.config;

import lombok.Data;

@Data
public class XLException extends RuntimeException{
    private String code;
    private String msg;

    public XLException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
