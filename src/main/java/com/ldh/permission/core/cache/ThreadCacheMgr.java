package com.ldh.permission.core.cache;

import com.ldh.permission.core.exception.PermissionAopException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ldh
 * @Date: 2018/12/19 10:57
 */
public class ThreadCacheMgr {

    /**
     * 本地线程
     */
    private static ThreadLocal<Map<String,Object>> threadlocal = new ThreadLocal<Map<String,Object>>();


    /**
     *
     * 功能描述: 缓存数据到线程上下文<br>
     * 〈功能详细描述〉
     *
     * @param context 入参内容
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void cache(Map<String,Object> context){
        threadlocal.set(context);
    }

    /**
     *
     * 功能描述: 从线程上下文中获取数据<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String,Object> cache(){
        Map<String,Object> context =  threadlocal.get();
        if(context == null){
            context = new HashMap<String,Object>();
            cache(context);
        }
        return context;
    }

    @SuppressWarnings("unchecked")
    public static Map<String,Object> push(String apiname,String paramKey,String params){
        Map<String,Object> context = cache();
        Map<String,Object> apiParams = (Map<String, Object>) context.get(apiname);
        if( apiParams == null ){
            apiParams = new HashMap<String,Object>();
            context.put(apiname, apiParams);
        }
        apiParams.put(paramKey, params);
        return context;
    }

    public static Map<String,Object> push(String apiname, String params){
        Map<String,Object> context = cache();
        context.put(apiname, params);
        return context;
    }

    public static Map<String, Object> pushList(String apiname, List list){
        Map<String,Object> context = cache();
        context.put(apiname, list);
        return context;
    }

    public static Map<String, Object> pushObject(String apiname, Object object){
        Map<String,Object> context = cache();
        context.put(apiname, object);
        return context;
    }

    public static Object get(String apiname){
        Map<String,Object> context = cache();
        return context.get(apiname);
    }

    public static void remove(){
        threadlocal.remove();
    }

    /**
     * 获取用户ID
     *
     * @return
     */
    public static Long getUserId(){
        String userIdStr = (String) get("userId");
        if (StringUtils.isNumeric(userIdStr)){
            return Long.parseLong(userIdStr);
        } else {
            throw new PermissionAopException("userId 不为数字");
        }
    }

    /**
     * 获取企业ID
     *
     * @return
     */
    public static Long getAdminId(){
        String adminId =(String) get("adminId");
        if (StringUtils.isNumeric(adminId)){
            return Long.parseLong(adminId);
        } else {
            throw new PermissionAopException("adminId 不为数字");
        }

    }
}
