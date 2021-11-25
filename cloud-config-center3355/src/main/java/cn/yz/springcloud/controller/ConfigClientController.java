package cn.yz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName ConfigClientController
 * @date 2020/9/15 12:18
 */
@RestController
//刷新，每次github修改后，3355获取到的都是最新的
//添加这个注解后，直接刷新还是不会生效的，需要运维人员在修改配置后发送post请求刷新3355
//curl -X POST "http://localhost:3355/actuator/refresh"
//想要完全实现自动更新要配合消息总线bus
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")  //从GitHub上的http://config-3344.com:3344/master/config-dev.yml读取config.info的内容
    private String configInfo;
//
//    @Value("${config}")
//    private String config;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

//    @GetMapping("/config")
//    public String getConfig(){
//        return config;
//    }
}
