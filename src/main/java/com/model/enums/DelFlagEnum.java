package com.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import com.valid.enums.IXEnum;
import com.valid.util.XEnumUtils;

/**
 * 删除标记
 *
 * @Author YeGuanWei
 */
public enum DelFlagEnum implements IEnum<Integer>, IXEnum {

    SUCCESS(1, "正常"),

    DELETE(2, "已删除"),

    ;

    private String name;

    private Integer code;

    private DelFlagEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static DelFlagEnum valueOf(Integer code) {
        if (code == null) {
            return null;
        }
        return (DelFlagEnum) XEnumUtils.valueOf(DelFlagEnum.class, code);
    }

    public static DelFlagEnum resolve(Integer code) {
        if (code == null) {
            return null;
        }
        return (DelFlagEnum) XEnumUtils.resolve(DelFlagEnum.class, code);
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
