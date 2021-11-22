package cn.yz.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName FeignConfig
 * @date 2020/9/7 0:07
 */
@Configuration
public class FeignConfig {
    /**
     * 日志级别
     * NONE 默认的，不显示任何日志
     * BASIC 仅记录请求的方法，URL、相应状态码及执行时间
     * HEADERS 除了BASIC中定义的信息外，还记录请求和相应的头信息
     * FULL 除了HEADERS中定义的信息外，还有请求和相应的正文及元数据
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
