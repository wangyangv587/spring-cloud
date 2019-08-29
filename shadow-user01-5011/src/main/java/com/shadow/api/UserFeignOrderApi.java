package com.shadow.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户调用订单接口 ，整合了hystrix
 * @author Shadow
 * @date 2019/6/18 15:49
 */
@FeignClient(name = "EUREKA-ORDER",fallback = UserFeignOrderApiFallBack.class)
public interface UserFeignOrderApi {

    @RequestMapping("/getUserOrder/{userId}")
    String getUserOrder(@PathVariable Long userId);

}
