package com.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import com.valid.enums.IXEnum;
import com.valid.util.XEnumUtils;

/**
 * 性别标记
 *
 * @Author YeGuanWei
 */
public enum SexEnum implements IEnum<Integer>, IXEnum {

    MALE(1, "男"),

    FEMALE(2, "女"),

    ;

    private String name;

    private Integer code;

    private SexEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static SexEnum valueOf(Integer code) {
        if (code == null) {
            return null;
        }
        return (SexEnum) XEnumUtils.valueOf(SexEnum.class, code);
    }

    public static SexEnum resolve(Integer code) {
        if (code == null) {
            return null;
        }
        return (SexEnum) XEnumUtils.resolve(SexEnum.class, code);
    }

    public String getName() {
        return this.name;
    }

    @JsonValue
    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

}
