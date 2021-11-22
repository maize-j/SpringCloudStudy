package cn.yz.springcloud.service;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentFeignService
 * @date 2020/9/6 21:40
 */
@Component
//该注解表明将当前service作为一个Feign组件
//value指明要访问的服务名称
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //调用CLOUD-PAYMENT-SERVICE服务下的/payment/getPaymentById/{id}，和方法名无关
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
