package cn.yz.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName MyGatewayFilter
 * @date 2020/9/10 15:40
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("************come in MyLogGatewayFilter"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("******用户名为null，非法用户，/(ㄒoㄒ)/~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //合法用户，去下一个过滤链
        return chain.filter(exchange);
    }

    //加载过滤器的顺序，一般数字越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
