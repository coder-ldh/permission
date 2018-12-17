package com.ldh.permission.core.exception;


import com.ldh.permission.core.exception.code.BizExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * </p>
 * @author ldh
 * @since 2018-11-21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 3302370961563777293L;

    /**
     * 异常编码
     */
    private String code;

    /**
     * 异常内容
     */
    private String message;

    /**
     * 数据
     */
    private Object data;


    public BusinessException(BizExceptionCode bizExceptionCode){
        this.code = bizExceptionCode.getCode();
        this.message = bizExceptionCode.getMessage();
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
