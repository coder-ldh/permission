package com.ldh.permission.core.aspect;

/**
 * @Author: ldh
 * @Date: 2018/11/28 13:24
 */

import com.ldh.permission.core.annotation.AuthRuleAnnotation;
import com.ldh.permission.core.exception.BusinessException;
import com.ldh.permission.core.exception.code.BizExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录验证 AOP
 */
@Aspect
@Component
@Slf4j
public class AuthorizeAspect {


    @Pointcut("@annotation(com.ldh.permission.core.annotation.AuthRuleAnnotation)")
    public void adminLoginVerify() {
    }

    /**
     * 登录验证
     *
     * @param joinPoint
     */
    @Before("adminLoginVerify()")
    public void doAdminAuthVerify(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            //throw new JsonException(ResultEnum.NOT_NETWORK);
        }
        HttpServletRequest request = attributes.getRequest();

        String id = request.getHeader("adminId");

        Long adminId = Long.valueOf(id);

        String token = request.getHeader("token");
        log.info("adminId——>{},token——>{}",adminId,token);
        if (token == null) {
            throw new BusinessException(BizExceptionCode.NO_TOKEN);
        }
        // 判断是否进行权限验证
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //从切面中获取当前方法
        Method method = signature.getMethod();
        //得到了方,提取出他的注解
        AuthRuleAnnotation action = method.getAnnotation(AuthRuleAnnotation.class);
        // 进行权限验证
        authRuleVerify(action.value(), adminId);
    }

    /**
     * 权限验证
     * @param authRule
     */
    private void authRuleVerify(String authRule, Long adminId) {

        if (authRule != null && authRule.length() > 0) {

            List<String> authRules = new ArrayList<>();
            // admin 为最高权限
            for (String item : authRules) {
                if (item.equals("admin") || item.equals(authRule)) {
                    return;
                }
            }
            //throw new JsonException(ResultEnum.AUTH_FAILED);
        }

    }

}
