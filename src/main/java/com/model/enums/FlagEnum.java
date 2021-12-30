package com.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import com.valid.enums.IXEnum;
import com.valid.util.XEnumUtils;

/**
 * 通用标记
 *
 * @Author YeGuanWei
 */
public enum FlagEnum implements IEnum<Integer>, IXEnum {

    YES(1, "是"),

    NO(2, "否"),

    ;

    private String name;

    private Integer code;

    private FlagEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static FlagEnum valueOf(Integer code) {
        if (code == null) {
            return null;
        }
        return (FlagEnum) XEnumUtils.valueOf(FlagEnum.class, code);
    }

    public static FlagEnum resolve(Integer code) {
        if (code == null) {
            return null;
        }
        return (FlagEnum) XEnumUtils.resolve(FlagEnum.class, code);
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
