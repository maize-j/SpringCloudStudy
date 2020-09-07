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
@Configuration
public class MySelfRule {
    @Bean
    public IRule muRule(){
        return new RandomRule();  //定义为随机
    }
}
