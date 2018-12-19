package com.ldh.permission.core.aspect;

/**
 * @Author: ldh
 * @Date: 2018/11/28 13:24
 */

import com.ldh.permission.core.annotation.Login;
import com.ldh.permission.core.annotation.Permission;
import com.ldh.permission.core.exception.BusinessException;
import com.ldh.permission.core.exception.code.BizExceptionCode;
import com.ldh.permission.core.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 登录验证 AOP
 */
@Aspect
@Component
@Slf4j
public class AuthorizeAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(com.ldh.permission.core.annotation.Permission)")
    public void adminLoginVerify() {
    }

    /**
     * 拦截所有后台请求过来的接口进行鉴权
     * @param joinPoint
     */
    @Before("adminLoginVerify()")
    public void doAdminAuthVerify(JoinPoint joinPoint) {
        /*判断是否进行权限验证*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*从切面中获取当前方法*/
        Method method = signature.getMethod();

        /*检查是否有Login注释，有则跳过认证*/
        if (method.isAnnotationPresent(Login.class)) {
            Login login = method.getAnnotation(Login.class);
            if (login.required()){
                return;
            }
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            throw new BusinessException(BizExceptionCode.NOT_NETWORK);
        }
        HttpServletRequest request = attributes.getRequest();
        /*判断header里面的是否有了adminId*/
        String id = request.getHeader("adminId");
        if (id == null){
            throw new BusinessException(BizExceptionCode.NO_ADMIN_ID);
        }
        Long adminId = Long.valueOf(id);
        /*判断header里面的是否有了token*/
        String token = request.getHeader("token");
        log.info("adminId——>{},token——>{}",adminId,token);
        if (token == null) {
            throw new BusinessException(BizExceptionCode.NO_TOKEN);
        }



        /*得到了方,提取出他的注解*/
        Permission action = method.getAnnotation(Permission.class);
        /*进行权限验证*/
        authService.authRuleVerify(action.value(), adminId);
    }
}
