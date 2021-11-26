package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName StreamRabbitmqMain
 * @date 2021/11/26 12:59
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamRabbitmqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqMain8801.class,args);
    }
}
