package com.shadow.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 降级调用类，失败时可查看异常信息，此时UserFeignOrderApi类@FeignClient应注明fallbackFactory
 * @author Shadow
 * @date 2019/6/20 10:25
 */
@Component
public class UserFeignOrderApiFallBackFactory implements FallbackFactory<UserFeignOrderApi> {


    @Override
    public UserFeignOrderApi create(Throwable cause) {

        System.out.println("1111" + cause.getMessage());
        cause.printStackTrace();
        return (userId)-> {
            return cause.getMessage() + userId;
        };
    }
}
