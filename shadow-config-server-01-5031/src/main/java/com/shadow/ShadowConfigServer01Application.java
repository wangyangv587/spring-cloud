package com.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Shadow
 * @date 2019/6/20 15:20
 */
@SpringBootApplication
@EnableConfigServer
public class ShadowConfigServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(ShadowConfigServer01Application.class);
    }
}
