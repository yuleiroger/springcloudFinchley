package com.roger.springcloudFinchley.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import sun.util.calendar.BaseCalendar;

import java.util.Date;
import java.util.Objects;

/**
 * Created by yulei on 2019/4/6.
 */
@Component
@Slf4j
public class EurekaStateChangeListener {
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        // 服务断线事件
        String appName = event.getAppName();
        String serverId = event.getServerId();
        Objects.requireNonNull(appName, "服务名不能为空!");
        log.info(">>>>>>> 服务:{}，{}下线，下线时间{}", serverId, appName, new Date());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("{}进行注册,注册时间{}", instanceInfo.getAppName(), new Date());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        //log.info(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("注册中心启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka Server启动");
    }
}
