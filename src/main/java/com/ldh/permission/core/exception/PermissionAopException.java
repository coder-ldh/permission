package com.ldh.permission.core.exception;

/**
 * @Author: ldh
 * @Date: 2018/12/19 10:55
 */
public class PermissionAopException extends RuntimeException {
    private static final long serialVersionUID = 5131156211494399588L;

    public PermissionAopException() {
        super();
    }

    public PermissionAopException(String message) {
        super(message);
    }

    public PermissionAopException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionAopException(Throwable cause) {
        super(cause);
    }
}
