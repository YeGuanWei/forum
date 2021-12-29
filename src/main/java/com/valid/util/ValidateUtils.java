package com.valid.util;

import com.hesc.cloud_core.utils.StringUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {

    public static final String REGEX_NAME = "^[\\u4e00-\\u9fa5]{2,30}$";
    public static final String REGEX_PAPERS_CODE = "^[a-zA-Z0-9\\(\\)\\u4e00-\\u9fa5]{2,30}$";
    public static final String REGEX_ID_HKMT = "^([A-Z]{1,2}[0-9]{6}\\([0-9A]\\))|([1|5|7][0-9]{6}\\([0-9Aa]\\))|([A-Z][0-9]{9})$";
    public static final String REGEX_ID_PASSPORT = "^1[45][0-9]{7}$|([P|p|S|s]\\d{7}$)|([S|s|G|g|E|e]\\d{8}$)|([Gg|Tt|Ss|Ll|Qq|Dd|Aa|Ff]\\d{8}$)|([H|h|M|m]\\d{8,10})$";
    public static final String REGEX_ID_COO = "^[\\u4e00-\\u9fa5](字第){1}([a-zA-Z\\d]{4,8})号$";
    public static final String REGEX_MONEY = "^([0-9]*)|([0-9]+\\.[0-9]{1,2})$";
    public static final String REGEX_BANK_CARD_WITH_PASSBOOK = "^\\d{10,30}$";
    public static final String REGEX_NICKNAME = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$";
    public static final String REGEX_USERNAME = "^[a-zA-Z0-9]{5,20}$";
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    public static final String REGEX_MOBILE = "^((1[3-9]))\\d{9}$";
    public static final String REGEX_EMAIL = "^\\w[-\\w.+]*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static final String REGEX_CHINESE = "^[一-龥],{0,}$";
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
    public static final String REGEX_URL = "^[a-zA-z]+://[^\\s]*$";
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    public static final String REGEX_INTEGER = "^\\d+$";
    public static final String REGEX_DECIMAL = "^\\d+\\.\\d+$";
    private static ValidatorFactory factoryWithDetail = Validation.buildDefaultValidatorFactory();
    private static ValidatorFactory factory = Validation.byDefaultProvider().configure().addProperty("hibernate.validator.fail_fast", String.valueOf(true)).buildValidatorFactory();

    public ValidateUtils() {
    }

    public static boolean validateNickname(String nickname, int minBit, int maxBit) {
        return !StringUtil.isEmpty(nickname) && nickname.length() >= minBit && nickname.length() <= maxBit ? exec("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$", nickname) : false;
    }

    public static boolean validateUserName(String userName) {
        return !StringUtil.isEmpty(userName) && userName.length() <= 20;
    }

    public static boolean validateSysUserName(String userName) {
        return exec("^[a-zA-Z0-9]{5,20}$", userName);
    }

    public static boolean validateUrl(String url) {
        return exec("^[a-zA-z]+://[^\\s]*$", url);
    }

    public static boolean validateAppKey(String appKey) {
        return StringUtil.isEmpty(appKey) ? false : exec("^[a-zA-Z0-9]{19}$", appKey);
    }

    public static boolean validateAppSecret(String appSecret) {
        return StringUtil.isEmpty(appSecret) ? false : exec("^[a-zA-Z0-9]{64}$", appSecret);
    }

    public static boolean validateAuthorizationCode(String authorizationCode) {
        return StringUtil.isEmpty(authorizationCode) ? false : exec("^[a-zA-Z0-9]{32}$", authorizationCode);
    }

    public static boolean validateAuthorizationAccessToken(String accessToken) {
        return StringUtil.isEmpty(accessToken) ? false : exec("^[a-zA-Z0-9]{32}$", accessToken);
    }

    public static boolean validateOpenId(String openId) {
        return StringUtil.isEmpty(openId) ? false : exec("^[a-zA-Z0-9]{16}$", openId);
    }

    public static boolean validatePassword(String password) {
        return exec("^[a-zA-Z0-9]{6,16}$", password);
    }

    public static boolean validateEmail(String email) {
        return exec("^\\w[-\\w.+]*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);
    }

    public static boolean validatePhone(String phone) {
        return exec("^((1[3-9]))\\d{9}$", phone);
    }

    public static boolean validateTelephone(String str) {
        Pattern p1 = null;
        Pattern p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }

        return b;
    }

    public static boolean validateInteger(String integer) {
        return exec("^\\d+$", integer);
    }

    public static boolean validateDecimal(String decimal) {
        return exec("^\\d+\\.\\d+$", decimal);
    }

    public static boolean validatePapersCode(String code) {
        return exec("^[a-zA-Z0-9\\(\\)\\u4e00-\\u9fa5]{2,30}$", code);
    }

    public static boolean exec(String regex, String input) {
        if (StringUtil.isBlank(input)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            boolean result = matcher.matches();
            return result;
        }
    }

    public static <T> List<String> validate(T t, Class... groups) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);
        List<String> messageList = new ArrayList();
        Iterator var5 = constraintViolations.iterator();

        while(var5.hasNext()) {
            ConstraintViolation<T> constraintViolation = (ConstraintViolation)var5.next();
            messageList.add(constraintViolation.getMessage());
        }

        return messageList;
    }

    public static <T> Set<ConstraintViolation<T>> validateWithDetail(T t, Class... groups) {
        Validator validator = factoryWithDetail.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);
        return constraintViolations;
    }

    public static void main(String[] args) {
        System.out.println(exec("^[\\u4e00-\\u9fa5]{2,30}$", "你好"));
        System.out.println(exec("^[\\u4e00-\\u9fa5]{2,30}$", "你 好"));
        System.out.println(exec("^[\\u4e00-\\u9fa5]{2,30}$", "你"));
        System.out.println(exec("^[\\u4e00-\\u9fa5]{2,30}$", "你好123''[]"));
        System.out.println(exec("^[\\u4e00-\\u9fa5]{2,30}$", "你好a.12()"));
    }

}
