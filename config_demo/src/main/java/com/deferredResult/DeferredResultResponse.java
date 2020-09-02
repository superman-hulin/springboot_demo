package com.deferredResult;

/**
 * @program: config_demo
 * @description: 通用返回结果类
 * @author: Su
 * @create: 2020-09-02 11:00
 **/
public class DeferredResultResponse<T> {
    private String code;
    private T msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public DeferredResultResponse(String code, T msg) {
        this.code = code;
        this.msg = msg;
    }
}
