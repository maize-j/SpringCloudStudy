package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName StreamRabbitmqMain8802
 * @date 2021/11/26 15:05
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamRabbitmqMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqMain8802.class,args);
    }
}
