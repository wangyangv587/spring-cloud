package com.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author YangWang
 * @Description zuul启动类
 * @Date 2019/8/29 15:33
 */
@EnableZuulProxy
@SpringBootApplication
public class ShadowZuul01Application {

    public static void main(String[] args) {
        SpringApplication.run(ShadowZuul01Application.class);
    }
}
