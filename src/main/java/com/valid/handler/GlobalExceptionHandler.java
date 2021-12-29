package com.valid.handler;

import com.valid.result.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常错误处理
 *
 * @author
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数为空验证，全局异常捕获
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response exceptionHandler(MethodArgumentNotValidException e) {
        return Response.failure(1, e.getBindingResult().getFieldError().getDefaultMessage());
    }

}
