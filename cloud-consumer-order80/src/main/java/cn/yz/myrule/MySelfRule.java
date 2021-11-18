package cn.yz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName MySelfRule
 * @date 2020/9/5 20:00
 */
//官方特地提醒了不能放在ComponentScan能扫描到的地方，否则所定义的配置类会被所有的Ribbon客户端共享
//因此要跳出springcloud包
@Configuration
public class MySelfRule {
    @Bean
    public IRule muRule(){
        return new RandomRule();  //定义为随机
    }
}
