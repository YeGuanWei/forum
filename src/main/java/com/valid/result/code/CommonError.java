package com.valid.result.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.valid.util.XEnumUtils;

import java.io.Serializable;

/**
 * @author Yegua
 * code 从0到100
 */
public enum CommonError implements IErrorCode, Serializable {

    // 预留
    PRESET(9999, ""),

    // 基础
    SUCCESS(0, "请求成功"),
    FAILURE(9999, "请求失败,请稍后再试"),

    // 参数相关 9000-9099
    INVALID_PARAMS(9000, "请求参数有误"),
    PARAMS_CONVERT_ERROR(9001, "请求参数值不合法或格式转换出错"),

    // 验证码错误 9100-9199
    CAPTCHA_EXPIRED(9100, "验证码已过期"),
    CAPTCHA_INCORRECT(9101, "验证码不正确"),

    // 基础操作 1000-1099
    CREATE_ERROR(1000, "新增请求失败,请稍后再试"),
    UPDATE_ERROR(1001, "修改请求失败,请稍后再试"),
    DELETE_ERROR(1002, "删除请求失败,请稍后再试"),

    // 用户相关 1100-1199
    NOT_LOGGED_IN(1100, "用户未登录"),
    USER_DISABLED(1101, "用户已被锁定"),
    INVALID_USERNAME_OR_PWD(1102, "用户名或密码错误"),
    USER_NOT_EXISTS(1103, "用户不存在"),

    // 组织机构相关 1200-1299
    ORG_EXISTS(1200, "该组织机构信息已存在"),
    ORG_NOT_EXISTS(1201, "该组织机构信息不存在"),
    ORG_PARENT_ORG_NOT_EXISTS(1202, "该上级组织机构信息无法找到"),
    ORG_SUB_ORG_EXISTS(1203, "无法删除,该组织机构下还存在子级数据"),

    // 行业相关 1300-1399
    INDUSTRY_EXISTS(1300, "该行业信息已存在"),
    INDUSTRY_NOT_EXISTS(1301, "该行业信息不存在"),

    // 角色相关 1400-1499
    ROLE_EXISTS(1400, "该角色信息已存在"),
    ROLE_NOT_EXISTS(1401, "该角色信息不存在"),

    // 菜单相关 1500-1599
    MENU_EXISTS(1500, "该菜单信息已存在"),
    MENU_NOT_EXISTS(1501, "该菜单信息不存在"),
    MENU_PARENT_MENU_NOT_EXISTS(1502, "该上级菜单信息无法找到"),
    MENU_SUB_MENU_EXISTS(1503, "无法删除,该菜单下还存在子级数据"),

    ;

    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    CommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 重新构造一个枚举实例
     *
     * @param code
     * @param msg
     * @return
     */
    public static CommonError newInstance(int code, String msg) {
        CommonError.PRESET.code = code;
        // 添加错误行数,便于排查
        CommonError.PRESET.msg = msg + "-" + Thread.currentThread().getStackTrace()[1].getLineNumber();
        return CommonError.PRESET;
    }

    @JsonCreator
    public static CommonError valueOf(int code) {
        return XEnumUtils.valueOf(CommonError.class, code);
    }

    public static CommonError resolve(int code) {
        return XEnumUtils.resolve(CommonError.class, code);
    }

    @Override
    @JsonValue
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

}