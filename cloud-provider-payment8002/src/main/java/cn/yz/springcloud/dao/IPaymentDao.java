package cn.yz.springcloud.dao;

import cn.yz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentDao
 * @date 2020/8/31 22:59
 */
//@Repository
@Mapper
public interface IPaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
