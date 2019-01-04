package com.ldh.permission.core.constant;

/**
 * @Author: ldh
 * @Date: 2018/12/19 12:48
 */
public class PermissionConstant {

    public static final int JWT_TTL = 60*60*1000;
    public static final String AUTHORIZATION = "Authorization";
    public static final String TOKEN = "TOKEN";
    public static final String USER_ID = "user-id";
    public static final String USER_TYPE = "user-type";
    public static final String APPLICATION_NAME = "spring.application.name";
    public static final String SERVICE_OWNER = "consul.instance.metadataMap.owner";

    public static final String PERMISSION_SCAN_PACKAGES = "permission.scan.packages";
    public static final String PERMISSION_INTERCEPTION_ENABLED = "permission.interception.enabled";
    public static final String PERMISSION_AUTOMATIC_PERSIST_ENABLED = "permission.automatic.persist.enabled";
    public static final String PERMISSION_USER_TYPE_WHITELIST = "permission.user.type.whitelist";
}
