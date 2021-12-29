package com.valid.enums;

import com.valid.base.CommonException;
import com.valid.result.code.CommonError;
import com.valid.util.XEnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.lang.reflect.ParameterizedType;

/**
 * @author Yegua
 */
public class ToIXEnumConverter<T extends Enum & IXEnum> implements Converter<String, T> {

    private static final Logger log = LoggerFactory.getLogger(ToIXEnumConverter.class);

    private Class<T> clazz;

    public ToIXEnumConverter() {
    }

    public T convert(String source) {
        try {
            return XEnumUtils.valueOf(this.getClazz(), Integer.parseInt(source));
        } catch (Exception var3) {
            log.error(var3.getMessage(), var3);
            throw new CommonException(CommonError.PARAMS_CONVERT_ERROR);
        }
    }

    public Class<T> getClazz() {
        if (this.clazz == null) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            this.clazz = (Class) type.getActualTypeArguments()[0];
        }

        return this.clazz;
    }

}
