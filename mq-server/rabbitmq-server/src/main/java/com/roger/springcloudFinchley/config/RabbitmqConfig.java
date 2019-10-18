package com.roger.springcloudFinchley.config;

import com.roger.springcloudFinchley.constant.MqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2019/2/15.
 */
@Configuration
public class RabbitmqConfig {
    @Bean(name = "logQueueMessage")
    public Queue logQueueMessage(){
        return new Queue(MqConstant.LogRabbitMq,true);
    }

    /**
     * 定义交换器
     * @return
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(MqConstant.LogExchange);
    }

    /**
     * 交换机与消息队列进行绑定
     * @param queueMessages
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(@Qualifier("logQueueMessage") Queue queueMessages, TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with(MqConstant.LogRabbitMq);
    }

}
