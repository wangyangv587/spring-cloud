package com.shadow.api;

import org.springframework.stereotype.Component;

/**
 * 降级调用类，失败时返回自定义信息，此时UserFeignOrderApi类@FeignClient应注明fallback
 * @author Shadow
 * @date 2019/6/18 16:02
 */
@Component
public class UserFeignOrderApiFallBack implements UserFeignOrderApi {

    @Override
    public String getUserOrder(Long userId) {

        System.out.println("用户订单降级方法");
        return "请求用户订单失败" + userId;
    }

}
