package com.valid.result.code;

import com.valid.enums.IXEnum;

public interface IErrorCode extends IXEnum {

    String getMsg();

    void setMsg(String msg);

}