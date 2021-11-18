package cn.yz.springcloud;

import cn.yz.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName OrderMain80
 * @date 2020/9/1 12:45
 */
@SpringBootApplication
@EnableEurekaClient
//为CLOUD-PAYMENT_SERVICE服务定义了服务选择规则MySelfRule
//@RibbonClient(name = "CLOUD-PAYMENT_SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
