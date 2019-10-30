package com.roger.springcloudFinchley.receiver;

import com.roger.springcloudFinchley.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/10/11.
 */
@Component
@Slf4j
public class MqReceiver {

    @RabbitListener(queues = MqConstant.LogRabbitMq)
    @RabbitHandler
    public void process(String msg){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                log.info("receive message from sender:{}", msg);
            }
        });
    }
}
