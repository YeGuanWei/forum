package com.valid.base;

import com.hesc.cloud_core.utils.StringUtil;
import com.valid.result.code.CommonError;
import com.valid.result.code.IErrorCode;
import com.valid.util.ValidateUtils;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * @author Yegua
 */
public class BaseDTO extends BaseBean {

    private static final long serialVersionUID = 1L;

    public static final String ERROR_SPLIT_MARK = ";";

    public BaseDTO() {
    }

    public IErrorCode validate(Class... groups) {
        List<String> errors = ValidateUtils.validate(this, groups);
        return errors != null && errors.size() > 0 ? CommonError.INVALID_PARAMS : null;
    }

    public void validateWithException(Class... groups) {
        List<String> errors = ValidateUtils.validate(this, groups);
        if (errors != null && errors.size() > 0) {
            throw new CommonException(CommonError.INVALID_PARAMS.getCode(), (String) errors.get(0));
        }
    }

    public Map<String, String> validateWithDetail(Class... groups) {
        Set<ConstraintViolation<BaseDTO>> errors = ValidateUtils.validateWithDetail(this, groups);
        if (errors != null && errors.size() > 0) {
            Map<String, String> errorsMap = new HashMap();
            Iterator var4 = errors.iterator();

            while (var4.hasNext()) {
                ConstraintViolation<BaseDTO> constraintViolation = (ConstraintViolation) var4.next();
                String fieldName = constraintViolation.getPropertyPath().toString();
                if (StringUtil.isNotBlank(fieldName)) {
                    fieldName = this.getClassValidateErrorKeyWithDetail();
                }

                if (errorsMap.containsKey(fieldName)) {
                    errorsMap.put(fieldName, (String) errorsMap.get(fieldName) + ";" + constraintViolation.getMessage());
                } else {
                    errorsMap.put(fieldName, constraintViolation.getMessage());
                }
            }

            return errorsMap;
        } else {
            return null;
        }
    }

    public Map<String, List<String>> validateWithDetailList(Class... groups) {
        Set<ConstraintViolation<BaseDTO>> errors = ValidateUtils.validateWithDetail(this, groups);
        if (errors != null && errors.size() > 0) {
            Map<String, List<String>> errorsMap = new HashMap();
            Iterator var4 = errors.iterator();

            while (var4.hasNext()) {
                final ConstraintViolation<BaseDTO> constraintViolation = (ConstraintViolation) var4.next();
                String fieldName = constraintViolation.getPropertyPath().toString();
                if (StringUtil.isBlank(fieldName)) {
                    fieldName = this.getClassValidateErrorKeyWithDetail();
                }

                if (errorsMap.containsKey(fieldName)) {
                    ((List) errorsMap.get(fieldName)).add(constraintViolation.getMessage());
                } else {
                    errorsMap.put(fieldName, new ArrayList<String>() {
                        {
                            this.add(constraintViolation.getMessage());
                        }
                    });
                }
            }

            return errorsMap;
        } else {
            return null;
        }
    }

    protected String getClassValidateErrorKeyWithDetail() {
        return "_clazz_";
    }

    public String buildSqlKey(String key) {
        if (key != null) {
            if (key.contains("`")) {
                key = key.replaceAll("`", "");
            }

            key = key.trim();
        }

        if (StringUtil.isBlank(key)) {
            return null;
        } else if (!key.contains(".")) {
            return "`" + key + "`";
        } else {
            StringBuilder sb = new StringBuilder();
            String[] var3 = key.split("\\.");
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String str = var3[var5];
                if (StringUtil.isNotBlank(str)) {
                    sb.append(".").append("`").append(str.trim()).append("`");
                }
            }

            if (sb.length() > 0) {
                return sb.substring(1);
            } else {
                return null;
            }
        }
    }
}
