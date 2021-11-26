package cn.yz.springcloud.controller;

import cn.yz.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName SendMessageController
 * @date 2021/11/26 13:38
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageService messageService;

    @GetMapping("/sendMessage")
    public String sendmessage(){

        return messageService.send();
    }
}
