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
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")  //从GitHub上的http://config-3344.com:3344/master/config-dev.yml读取config.info的内容
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
