package com.shadow.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shadow.api.UserFeignOrderApi;
import com.shadow.common.R;
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

//    HystrixCommand方式步骤1
//    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @RequestMapping("/getUserOrder/{userId}")
    public R getUserOrder(@PathVariable Long userId)throws Exception{

        return R.dataObj(userFeignService.getUserOrder(userId));
    }
//      HystrixCommand方式步骤2
//    public R fallbackMethod(Long userId){
//        return R.dataObj("请求失败" + userId);
//    }
}
