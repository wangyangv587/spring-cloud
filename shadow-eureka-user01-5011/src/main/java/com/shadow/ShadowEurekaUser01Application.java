package com.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Shadow
 * @date 2019/6/17 12:01
 */
@EnableFeignClients
@SpringBootApplication
public class ShadowEurekaUser01Application {

    public static void main(String[] args) {
        SpringApplication.run(ShadowEurekaUser01Application.class);
    }
}
