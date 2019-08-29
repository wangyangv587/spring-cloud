package com.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableCircuitBreaker 为hystrix的注解，也可使用@EnableHystrix，他们是继承关系
 * 继承SpringBootServletInitializer类，并重写configure方法，将当前类进行注册后Tomcat启动时会启动这个类（war包形式）
 * @author Shadow
 * @date 2019/6/17 12:01
 */
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class ShadowUser01Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ShadowUser01Application.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShadowUser01Application.class);
    }
}
