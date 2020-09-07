package cn.yz.springcloud.service.impl;

import cn.yz.springcloud.dao.IPaymentDao;
import cn.yz.springcloud.entities.Payment;
import cn.yz.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentServiceImpl
 * @date 2020/8/31 23:14
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

//    @Autowired
    @Resource
    private IPaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
