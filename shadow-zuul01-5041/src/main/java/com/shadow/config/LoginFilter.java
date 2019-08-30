package com.shadow.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul的过滤器
 * @author YangWang
 * @Description
 * @Date 2019/8/29 16:54
 */
@Slf4j
@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //FilterConstants.ROUTE_TYPE：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服 务的请求，并使用 Apache HttpCIient或 Netfilx Ribbon请求微服务
        //FilterConstants.POST_TYPE：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准 的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等
        //FilterConstants.ERROR_TYPE：在其他阶段发生错误时执行该过滤器
        //FilterConstants.PRE_TYPE：这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在 集群中选择请求的微服务、记录调试信息等
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    /**
     * 是否需要调用过滤方法run()
     * @return true标识需要调用run，默认为false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的过滤逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("run | token:{},requestURI:{}",request.getHeader("token"),request.getRequestURI());
        return null;
    }
}
