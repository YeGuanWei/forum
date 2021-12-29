package com.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 字符串辅助类
 * @author YeGuanWei
 */
public class StringUtil {

    public static String toString(Object object) {
        if (object != null) {
            return object.toString();
        } else {
            return "";
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() != 0;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.trim().length() != 0;
    }

    public static String urlEncode(String str, String charset) throws UnsupportedEncodingException {
        return !isEmpty(str) ? URLEncoder.encode(str, charset).replaceAll("\\+", "%20") : str;
    }

    public static String utf8UrlEncode(String str) {
        try {
            return urlEncode(str, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return str;
        }
    }

}
