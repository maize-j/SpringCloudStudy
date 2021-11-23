package cn.yz.springcloud.controller;

import cn.yz.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentHystrixController
 * @date 2020/9/7 16:15
 */
@RestController
@Slf4j
//配置异常处理的全局方法，没有单独配置fallback方法的方法，在出错时就用该全局fallback方法
@DefaultProperties(defaultFallback = "order_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        return orderHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/Timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    //加上这个注解，在方法出现异常时，会调用全局的回调方法，否则就会报错
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Long id){
        return orderHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Long id){
        return "我是消费者80，对方制度系统繁忙，请10秒后再试，或者自己运行出错请自行检查，/(ㄒoㄒ)/~~";
    }

    //全局fallback方法
    public String order_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后重试，/(ㄒoㄒ)/~~";
    }

}
