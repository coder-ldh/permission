package com.ldh.permission.core.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.ldh.permission.core.exception.code.BizExceptionCode;
import com.ldh.permission.core.model.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.BindException;

/**
 * @Author: ldh
 * @Date: 2018/12/17 10:09
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    /**
     * 处理自定义参数异常
     */
    @ExceptionHandler(value = { BindException.class, MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class,
            UnrecognizedPropertyException.class, InvalidFormatException.class, HttpMessageNotReadableException.class })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResultVO handleBindException(Exception ex) {
        log.error("参数Exception:{}", ex);

        String message = "输入的参数错误";
        return ResultVO.build(BizExceptionCode.PARAM_INVALID.getCode(), message);
    }

    /**
     * 处理普通异常
     */
    @ExceptionHandler(value = { Throwable.class })
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleCommonException(Throwable ex) {
        log.error(ex.getMessage(), ex);
        if (ex instanceof NumberFormatException) {
            return ResultVO.build(
                    BizExceptionCode.PARAM_INVALID.getCode(),
                    BizExceptionCode.PARAM_INVALID.getMessage());
        }
        if (ex instanceof InvalidFormatException) {
            return ResultVO.build(
                    BizExceptionCode.PARAM_INVALID.getCode(),
                    BizExceptionCode.PARAM_INVALID.getMessage());
        }
        return ResultVO.build(BizExceptionCode.SYSTEM_ERROR.getCode(), "未知异常");
    }

    /**
     * 处理自定义业务异常底层的微服务业务异常
     */
    @ExceptionHandler(value = { BusinessException.class })
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResultVO handleBusinessException(BusinessException ex) {
        log.error("BusinessException-{}:{}", ex.getCode(), ex.getMessage());
        return ResultVO.build(ex.getCode(), ex.getMessage(), ex.getData());
    }
}
