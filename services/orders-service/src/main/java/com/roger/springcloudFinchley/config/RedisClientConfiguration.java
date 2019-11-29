package com.roger.springcloudFinchley.config;

import com.roger.springcloudFinchley.component.CommonPool2Properties;
import com.roger.springcloudFinchley.component.SentinelProperties;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

/**
 * Created by admin on 2019/11/25.
 */
@Configuration
public class RedisClientConfiguration {

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        //todo 定制化配置
        return stringRedisTemplate;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //todo 定制化配置
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory (RedisSentinelConfiguration redisSentinelConfiguration, JedisClientConfiguration jedisClientConfiguration) {
        return new JedisConnectionFactory(redisSentinelConfiguration, jedisClientConfiguration);
    }

    /**
     * 配置哨兵集群信息 master和host:ip
     * @param sentinelProperties  集群Properties
     * @return redisSentinelConfiguration
     */
    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration(SentinelProperties sentinelProperties) {
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration(sentinelProperties.getMaster(), sentinelProperties.getHosts());
        redisSentinelConfiguration.setPassword(RedisPassword.of("yulei"));
        return redisSentinelConfiguration;
    }

    /**
     * 配置LettuceClientConfiguration 包括线程池配置和安全项配置
     * @param genericObjectPoolConfig common-pool2线程池
     * @return lettuceClientConfiguration
     */
    @Bean
    public JedisClientConfiguration jedisClientConfiguration(GenericObjectPoolConfig genericObjectPoolConfig) {
        return JedisClientConfiguration.builder()
                .usePooling()
                .poolConfig(genericObjectPoolConfig)
                .build();
    }

    @Bean
    public GenericObjectPoolConfig genericObjectPoolConfig(CommonPool2Properties commonPool2Properties) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(commonPool2Properties.getMaxIdle());
        poolConfig.setMinIdle(commonPool2Properties.getMinIdle());
        poolConfig.setMaxTotal(commonPool2Properties.getMaxTotal());
        //todo 其他配置
        return poolConfig;
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

}

