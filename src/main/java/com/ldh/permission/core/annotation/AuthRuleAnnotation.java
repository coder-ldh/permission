package com.ldh.permission.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ldh
 * @Date: 2018/11/28 12:33
 */
//此注解只能修饰方法
@Target(ElementType.METHOD)
//当前注解如何去保持
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthRuleAnnotation {
    String value();
}