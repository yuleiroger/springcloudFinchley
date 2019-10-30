package com.roger.springcloudFinchley.rabbitmq;

import com.roger.springcloudFinchley.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2019/2/15.
 */
@Component
@Slf4j
public class RabbitmqSender {
    @Autowired
    private AmqpTemplate amqpTemplate;



    public void send(String msg) {
        this.amqpTemplate.convertAndSend(MqConstant.LogExchange,MqConstant.LogRabbitMq, msg);
    }
}
