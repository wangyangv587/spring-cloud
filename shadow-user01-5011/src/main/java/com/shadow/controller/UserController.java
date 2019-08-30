package com.shadow.controller;

import com.shadow.api.UserFeignOrderApi;
import com.shadow.common.exception.ShadowException;
import com.shadow.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shadow
 * @date 2019/6/18 15:49
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserFeignOrderApi userFeignService;

    @Value("${spring.application.name}")
    private String springApplicationName;

//    HystrixCommand方式步骤1
//    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @RequestMapping("/getUserOrder/{userId}")
    public R getUserOrder(@PathVariable Long userId)throws Exception{

        log.info("getUserOrder | userId:{}",userId);
        return R.ok().dataObj(userFeignService.getUserOrder(userId));
    }
//      HystrixCommand方式步骤2
//    public R fallbackMethod(Long userId){
//        return R.dataObj("请求失败" + userId);
//    }

    @RequestMapping("/test")
    public R test(){

        return R.ok().dataObj(springApplicationName);
    }
}
