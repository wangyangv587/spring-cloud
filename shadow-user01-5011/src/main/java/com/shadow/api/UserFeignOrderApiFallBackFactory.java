package com.shadow.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 使用FallbackFactory方式可用于查看具体信息
 * @author Shadow
 * @date 2019/6/20 10:25
 */
@Component
public class UserFeignOrderApiFallBackFactory implements FallbackFactory<UserFeignOrderApi> {


    @Override
    public UserFeignOrderApi create(Throwable cause) {

        System.out.println("1111" + cause.getMessage());
        return (userId)-> {
            return cause.getMessage() + userId;
        };
    }
}
