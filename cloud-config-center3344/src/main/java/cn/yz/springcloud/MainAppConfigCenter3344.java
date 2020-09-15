package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName MainAppConfigCenter3344
 * @date 2020/9/10 18:34
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class MainAppConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class,args);
    }
}