package com.roger.springcloudFinchley.receiver;

import com.roger.springcloudFinchley.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2019/10/11.
 */
@Component
@Slf4j
public class MqReceiver {
    @RabbitListener(queues = MqConstant.LogRabbitMq)
    @RabbitHandler
    public void process(String msg){
        log.info("receive message from sender:{}", msg);
    }
}
