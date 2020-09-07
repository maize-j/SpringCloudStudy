package cn.yz.springcloud.service;

import cn.yz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentService
 * @date 2020/8/31 23:14
 */
@Service
public interface IPaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
