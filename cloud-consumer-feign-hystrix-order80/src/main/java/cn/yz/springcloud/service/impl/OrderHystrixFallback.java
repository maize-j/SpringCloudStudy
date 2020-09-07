package cn.yz.springcloud.service.impl;

import cn.yz.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName OrderHystrixServiceImpl
 * @date 2020/9/7 20:32
 */
@Component
public class OrderHystrixFallback implements OrderHystrixService {

    @Override
    public String paymentInfo_OK(Long id) {
        return "---OrderHystrixFallback fall back-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "---OrderHystrixFallback fall back-paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
