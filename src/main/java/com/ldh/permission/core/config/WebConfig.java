package com.ldh.permission.core.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ldh
 * @Date: 2018/12/26 22:48
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    HttpMessageConverters httpMessageConverters;

    @Bean
    UndertowServletWebServerFactory embeddedServletContainerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true)
                .setServerOption(UndertowOptions.URL_CHARSET, "UTF-8")
                .setServerOption(UndertowOptions.MULTIPART_MAX_ENTITY_SIZE, 20971520L));
        return factory;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new JacksonMapperConfig());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.addAll(httpMessageConverters.getConverters());
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(false)
                .allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600);
    }
}
