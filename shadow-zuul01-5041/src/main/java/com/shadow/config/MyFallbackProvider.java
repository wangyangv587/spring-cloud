package com.shadow.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/** zuul的容错回退
 * @author YangWang
 * @Description
 * @Date 2019/8/30 9:53
 */
@Slf4j
@Component
public class MyFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        //制定为哪个微服务提供回退（这里写微服务名 写*代表所有微服务）
        return "*";
    }

    /**
     *  此方法需要返回一个ClientHttpResponse对象  ClientHttpResponse是一个接口，具体的回退逻辑要实现此接口
     * @param route 出错的微服务名
     * @param cause 出错的异常对象
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.error("fallbackResponse | route:{},cause:{}",route,cause);

        //这里返回一个ClientHttpResponse对象 并实现其中的方法，关于回退逻辑的详细，便在下面的方法中
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {

                //返回一个HttpStatus对象 这个对象是个枚举对象， 里面包含了一个status code 和reasonPhrase信息
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {

                //返回HttpStatus的code  比如 404，500等，这里是200
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {

                //返回一个HttpStatus对象的reasonPhrase信息
                return "OK";
            }

            @Override
            public void close() {

                //close的时候调用的方法， 讲白了就是当降级信息全部响应完了之后调用的方法
            }

            @Override
            public InputStream getBody() throws IOException {
                //吧降级信息响应回前端
                return new ByteArrayInputStream("降级信息".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                //需要对响应报头设置的话可以在此设置
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

}
