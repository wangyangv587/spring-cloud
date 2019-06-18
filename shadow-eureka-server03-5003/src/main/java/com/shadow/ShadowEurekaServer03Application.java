package com.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Shadow
 * @date 2019/6/17 10:55
 */
@SpringBootApplication
@EnableEurekaServer
public class ShadowEurekaServer03Application {

    public static void main(String[] args) {
        SpringApplication.run(ShadowEurekaServer03Application.class);
    }
}
