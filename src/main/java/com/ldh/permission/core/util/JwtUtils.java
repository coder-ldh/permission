package com.ldh.permission.core.util;

/**
 * @Author: ldh
 * @Date: 2018/12/19 11:14
 */
import com.ldh.permission.core.cache.ThreadCacheMgr;
import com.ldh.permission.core.constant.PermissionConstant;
import com.ldh.permission.core.exception.PermissionAopException;
import com.ldh.permission.core.model.Admin;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public String createToken(Admin admin,String signKey){
        // 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<>();
        claims.put("adminId", admin.getAdminId());
        claims.put("userName", admin.getUserName());

        // 下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() // 这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)          // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                //.setId(id)                  // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)           // iat: jwt的签发时间
                //.setIssuer(issuer)          // issuer：jwt签发人
                //.setSubject(subject)        // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(signatureAlgorithm, signKey); // 设置签名使用的签名算法和签名使用的秘钥


        // 设置过期时间
        long expMillis = nowMillis + PermissionConstant.JWT_TTL;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
        return builder.compact();
    }

}
