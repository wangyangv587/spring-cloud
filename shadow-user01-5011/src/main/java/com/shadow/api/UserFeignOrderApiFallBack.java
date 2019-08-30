package com.shadow.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 降级调用类，失败时返回自定义信息，此时UserFeignOrderApi类@FeignClient应注明fallback
 * @author Shadow
 * @date 2019/6/18 16:02
 */
@Component
@Slf4j
public class UserFeignOrderApiFallBack implements UserFeignOrderApi {

    @Override
    public String getUserOrder(Long userId) {

        log.info("用户订单降级方法,userId:{}",userId);
        return "请求用户订单失败" + userId;
    }

}
