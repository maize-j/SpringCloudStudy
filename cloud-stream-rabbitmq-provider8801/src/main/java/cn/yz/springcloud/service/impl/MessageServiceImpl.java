package cn.yz.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.yz.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName MessageServiceImpl
 * @date 2021/11/26 13:17
 */
//这里注解不同service，因为该service是和mq打交道的
//source表示生产者，sink表示消费者
@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****"+serial);
        return serial;
    }
}
