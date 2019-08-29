package com.shadow.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YangWang
 * @Description
 * @Date 2019/8/29 16:54
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //FilterConstants.ROUTE_TYPE：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服 务的请求，并使用 Apache HttpCIient或 Netfilx Ribbon请求微服务
        //FilterConstants.POST_TYPE：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准 的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等
        //FilterConstants.ERROR_TYPE：在其他阶段发生错误时执行该过滤器
        //FilterConstants.PRE_TYPE：这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在 集群中选择请求的微服务、记录调试信息等
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("run......");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println("requestURI：" + request.getRequestURI());
        System.out.println("remoteAddr：" + request.getRemoteAddr());
        System.out.println("localAddr：" + request.getLocalAddr());
        return null;
    }
}
