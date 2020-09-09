package cn.yz.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName GatewayConfig
 * @date 2020/9/9 20:16
 */
@Configuration
public class GatewayConfig {
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        //相当于yml中
        // cloud:
        //    gateway:
        //      routes:
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //相当于yml中配置的
        //        - id: payment_routh    #路由的ID，没有固定规则但要求唯一，建议配合服务名
        //          uri: http://localhost:8001    #匹配后提供服务的路由地址
        //意味着访问localhost:9527/guonei这个网址，将会转发到https://news.baidu.com/guonei
        routes.route("path_route_cnyz",r -> r.path("/guonei").uri("https://news.baidu.com/guonei"));

        return routes.build();
    }
}
