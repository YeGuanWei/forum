package com.valid.util;

import com.valid.enums.IXEnum;

public class XEnumUtils {

    public static <T extends Enum & IXEnum> T valueOf(Class<T> clazz, int code) {
        T value = resolve(clazz, code);
        if (value == null) {
            throw new IllegalArgumentException(clazz.getSimpleName() + " no matching constant for code [" + code + "]");
        } else {
            return value;
        }
    }

    public static <T extends Enum & IXEnum> T resolve(Class<T> clazz, int code) {
        T[] var2 = (T[]) clazz.getEnumConstants();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            T value = var2[var4];
            if (((T) value).getCode() == code) {
                return value;
            }
        }

        return null;
    }
}
