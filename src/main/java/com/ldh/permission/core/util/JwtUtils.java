package com.ldh.permission.core.util;

/**
 * @Author: ldh
 * @Date: 2018/12/19 11:14
 */
import com.ldh.permission.core.cache.ThreadCacheMgr;
import com.ldh.permission.core.exception.PermissionAopException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Component
public class JwtUtils {

    @Value("${security.jwt.tokenSigningKey:v98xc98f7s98rodiesrlkj897f3oi}")
    private String signKey;

    public void cacheAuth(String jwtToken){
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signKey.getBytes("UTF-8")).parseClaimsJws(jwtToken);
            ThreadCacheMgr.pushObject("claims", claimsJws);
        } catch (UnsupportedEncodingException e) {
            throw new PermissionAopException("token 解码错误", e);
        } catch (MalformedJwtException e2){
            throw new PermissionAopException("token 格式错误", e2);
        } catch (ExpiredJwtException e3){
            throw new PermissionAopException("token 过期", e3);
        }
    }

    @SuppressWarnings("unchecked")
    public List<String> parseAuth(){
        Jws<Claims> jws = (Jws<Claims>) ThreadCacheMgr.get("claims");
        return (List<String>) jws.getBody().get(String.valueOf(ThreadCacheMgr.getAdminId()) + "_permission");
    }

    @SuppressWarnings("unchecked")
    public void cachePartnerName(){
        Jws<Claims> jws = (Jws<Claims>) ThreadCacheMgr.get("claims");
        ThreadCacheMgr.push("partnerName", (String) jws.getBody().get(String.valueOf(ThreadCacheMgr.getAdminId() + "_partnerName")));
    }

    @SuppressWarnings("unchecked")
    public void cacheAdminName(){
        Jws<Claims> jws = (Jws<Claims>) ThreadCacheMgr.get("claims");
        ThreadCacheMgr.push("adminName", (String) jws.getBody().get("adminName"));
    }

}
