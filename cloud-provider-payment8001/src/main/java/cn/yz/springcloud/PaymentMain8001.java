package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentMain8001
 * @date 2020/8/31 20:15
 */
@SpringBootApplication
//标记为EurekaClient，Eureka的客户端，服务提供方
@EnableEurekaClient
//开启服务发现
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}
