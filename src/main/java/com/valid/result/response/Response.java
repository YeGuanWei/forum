package com.valid.result.response;

import com.valid.result.code.CommonError;
import com.valid.result.code.IErrorCode;

import java.io.Serializable;

public class Response<T> implements Serializable {

    protected Integer code;

    protected T data;

    protected Long time;

    protected String message;

    protected Response(T data) {
        this(CommonError.SUCCESS.getCode(), data, CommonError.SUCCESS.getMsg());
    }

    protected Response(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.time = System.currentTimeMillis();
        this.message = message;
    }

    public static <T> Response<T> success(T data) {
        return new Response(data);
    }

    public static Response failure(IErrorCode errorCode) {
        return failure(errorCode.getCode(), errorCode.getMsg());
    }

    public static Response failure(IErrorCode errorCode, Object... args) {
        return failure(errorCode.getCode(), String.format(errorCode.getMsg(), args));
    }

    public static Response failure(int code, String message) {
        return new Response(code, (Object) null, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
