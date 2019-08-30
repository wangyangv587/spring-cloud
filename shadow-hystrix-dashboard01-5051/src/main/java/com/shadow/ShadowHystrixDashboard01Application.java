package com.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author YangWang
 * @Description
 * @Date 2019/8/30 13:59
 */
@EnableHystrixDashboard
@SpringBootApplication
public class ShadowHystrixDashboard01Application {

    public static void main(String[] args) {
        SpringApplication.run(ShadowHystrixDashboard01Application.class);
    }

}
