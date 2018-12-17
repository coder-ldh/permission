package com.ldh.permission.core.exception.code;

/**
 * 统一异常码code
 * @author ldh
 **/
public enum BizExceptionCode {

    NO_TOKEN("400", "token不能为空"),
    NO_PERMISSION("403", "无权操作"),
    SYSTEM_ERROR("500", "服务器异常"),
    PARAM_INVALID("502", "参数不正确"),
    ;

    BizExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
