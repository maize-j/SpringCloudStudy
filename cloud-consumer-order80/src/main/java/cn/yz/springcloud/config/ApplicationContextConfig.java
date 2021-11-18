package cn.yz.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName ApplicationContextConfig
 * @date 2020/9/1 12:59
 */
@Configuration
public class ApplicationContextConfig {

    //将RestTemplate对象注入到Spring容器中
    @Bean
    //注册进eureka后，需要开启一个自动的负载均衡机制，赋予RestTemplate负载均衡的能力，否则服务不认识注册进eureka服务提供方的微服务名称CLOUD-PAYMENT-SERVICE
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
