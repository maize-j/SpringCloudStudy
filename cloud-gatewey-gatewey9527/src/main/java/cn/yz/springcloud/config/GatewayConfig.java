package cn.yz.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName GatewayConfig
 * @date 2020/9/9 20:16
 */
@Configuration
public class GatewayConfig {

    @Bean
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
        //在跳转的页面上点击别的按钮会跳转到localhost:9527/**
        //如访问localhost:9527/guonei，页面跳转到https://news.baidu.com/guonei，此时在页面点国际，不会跳转到https://news.baidu.com/guoji，而是跳转到localhost:9527/guoji
        routes.route("path_route_cnyz",r -> r.path("/guonei").uri("https://news.baidu.com/guonei"));
        routes.route("path_route_cnyz",r -> r.path("/guoji").uri("https://news.baidu.com/guoji"));
        routes.route("path_route_cnyz",r -> r.path("/mil").uri("https://news.baidu.com/mil"));

        return routes.build();
    }
}
