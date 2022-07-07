package com.exam.nxt.exception;

import lombok.Getter;

@Getter
public class NxtException extends RuntimeException {
    private String code;

    public NxtException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
