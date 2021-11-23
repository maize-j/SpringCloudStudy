package cn.yz.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import java.net.ServerSocket;

/**
 * TODO
 * 监控其他的服务，如监控8001时，在启动后的界面中填入http://localhost:8001/hystrix.stream
 * @author 苞谷洁子
 * @ClassName HystrixDashboardMain9001
 * @date 2020/9/8 18:33
 */
@SpringBootApplication
//开启hystrix仪表盘
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }

}
