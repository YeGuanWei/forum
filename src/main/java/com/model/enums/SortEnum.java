package com.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import com.valid.enums.IXEnum;
import com.valid.util.XEnumUtils;

/**
 * 排序标记
 *
 * @Author YeGuanWei
 */
public enum SortEnum implements IEnum<Integer>, IXEnum {

    ASC(1, "正序"),

    DESC(2, "倒序"),

    ;

    private String name;

    private Integer code;

    private SortEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    @JsonCreator
    public static SortEnum valueOf(Integer code) {
        if (code == null) {
            return null;
        }
        return (SortEnum) XEnumUtils.valueOf(SortEnum.class, code);
    }

    public static SortEnum resolve(Integer code) {
        if (code == null) {
            return null;
        }
        return (SortEnum) XEnumUtils.resolve(SortEnum.class, code);
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
