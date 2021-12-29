package com.util;

import org.springframework.util.DigestUtils;

/**
 * MD5加密
 *
 * @author YeGuanWei
 */
public class MD5Util {

    /**
     * 随机盐
     * 用于混交md5
     */
    private static final String SLAT = "&%5123***&&%%$$#@";

    private static final String encodingCharset = "UTF-8";

    /**
     * 生成md5
     *
     * @param value
     * @return
     */
    public static String md5(String value) {
        String base = value + "/" + SLAT;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

}