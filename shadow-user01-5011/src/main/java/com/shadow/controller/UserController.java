package com.shadow.controller;

import com.shadow.api.UserFeignOrderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shadow
 * @date 2019/6/18 15:49
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignOrderApi userFeignService;

    @RequestMapping("/getUserOrder/{userId}")
    public String getUserOrder(@PathVariable Long userId){

        return userFeignService.getUserOrder(userId);
    }
}
