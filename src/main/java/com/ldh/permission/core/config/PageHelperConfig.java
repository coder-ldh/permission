package com.ldh.permission.core.config;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
/**
 * @Author: ldh
 * @Date: 2018/12/14 18:42
 */
@Configuration
public class PageHelperConfig {

    /**
     * 注入pagehelper配置
     *
     * @return
     */
    @Bean
    public PageHelper getPageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}