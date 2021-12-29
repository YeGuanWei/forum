package com.valid.base;

import com.valid.result.code.CommonError;
import com.valid.result.code.IErrorCode;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -443951596164587002L;

    protected String message;

    protected int code;

    public CommonException(Integer code, String message) {
        super(message);
        this.code = CommonError.FAILURE.getCode();
        this.code = code;
        this.message = message;
    }

    public CommonException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = CommonError.FAILURE.getCode();
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public CommonException(Integer code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = CommonError.FAILURE.getCode();
        this.code = code;
        this.message = String.format(msgFormat, args);
    }

    public CommonException() {
        this.code = CommonError.FAILURE.getCode();
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
        this.code = CommonError.FAILURE.getCode();
    }

    public CommonException(Throwable cause) {
        super(cause);
        this.code = CommonError.FAILURE.getCode();
    }

    public CommonException(String message) {
        super(message);
        this.code = CommonError.FAILURE.getCode();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public Integer getCode() {
        return this.code;
    }

}
