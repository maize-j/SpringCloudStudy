package cn.yz.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentHystrixService
 * @date 2020/9/7 12:03
 */
@Service
public class PaymentHystrixService {

    //==============================服务降级================================
    /**
     *正常访问
     * @author 苞谷洁子
     * @param id
     *@return 
     *@throws
     *@date 2020/9/7 12:07
     */
    public String paymentInfo_OK(Long id){
        //hystrix用的是tomcat中的线程池
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_OK id: "+id+"\t哈哈";
    }

    /**
     * 模拟出错
     *@author 苞谷洁子
     * @param id
     * fallbackMethod 为降级的方法
     *@return 
     *@throws
     *@date 2020/9/7 12:09
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //定义了方法进入回调（fallback）方法的条件
            //表明该线程的超时时间为3秒钟，而下面设置的休眠时间为5秒钟，一定会超时。
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Long id){
        int timeNum = 5;
        //休眠timeNum秒钟
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_Timeout id: "+id+"\t耗时"+timeNum+"秒钟";
    }

    public String paymentInfo_TimeOutHandler(Long id){
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_TimeOutHandler id: "+id+"/(ㄒoㄒ)/~~";
    }



    //==============================服务熔断================================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗日期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("**********id不能为负数***********");
        }
        String serialNnmber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t调用成功，流水号："+serialNnmber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试，/(ㄒoㄒ)/~~    id:"+id;
    }
}
