package com.ldh.permission.core.filter;

import com.ldh.permission.core.cache.ThreadCacheMgr;
import com.ldh.permission.core.config.PathConfig;
import com.ldh.permission.core.constant.PermissionConstant;
import com.ldh.permission.core.exception.PermissionAopException;
import com.ldh.permission.core.util.JwtUtils;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: ldh
 * @Date: 2018/12/19 11:20
 */
@Component
@WebFilter(urlPatterns = "/*")
@Order(value = -999)
@Configuration
public class BasicFilter implements Filter {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PathConfig pathConfig;
    @Value("${" + PermissionConstant.PERMISSION_INTERCEPTION_ENABLED + ":true}")
    private Boolean interceptionEnabled;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequestImpl) servletRequest).getRequestURI();
        if (!pathConfig.hasFixPath(uri) && !pathConfig.hasPrefixPath(uri)){

            String userId = ((HttpServletRequestImpl) servletRequest).getHeader("userId");
            String entId = ((HttpServletRequestImpl) servletRequest).getHeader("entId");
            // 缓存jwt相关信息
            ThreadCacheMgr.push("userId", userId);
            ThreadCacheMgr.push("entId", entId);

            if (interceptionEnabled){
                String authorization = ((HttpServletRequestImpl) servletRequest).getHeader(PermissionConstant.AUTHORIZATION);
                jwtUtils.cacheAuth(authorization);
                jwtUtils.cacheAdminName();
                jwtUtils.cachePartnerName();

                // 判断是否自己企业
                if (CollectionUtils.isEmpty(jwtUtils.parseAuth())){
                    throw new PermissionAopException("No permision to proceed , please select your own enterprise! ");
                }
            }else {
                String userName = ((HttpServletRequestImpl) servletRequest).getHeader("userName");
                String entName = ((HttpServletRequestImpl) servletRequest).getHeader("entName");
                ThreadCacheMgr.push("userName", userName);
                ThreadCacheMgr.push("entName", entName);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
