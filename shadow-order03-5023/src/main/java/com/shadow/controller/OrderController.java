package com.shadow.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shadow
 * @date 2019/6/18 15:45
 */
@RestController
@Slf4j
public class OrderController {

    private static int count = 0;

    @RequestMapping("/getUserOrder/{userId}")
    public String getUserOrder(@PathVariable Long userId){

        log.info("count = {}",++count);
        return "order01-5023-" + userId + "-" + count ;
    }
}
