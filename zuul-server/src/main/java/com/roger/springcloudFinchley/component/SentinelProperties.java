package com.roger.springcloudFinchley.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2019/11/25.
 */
@Component
public class SentinelProperties {
    @Value("${sentinel.master}")
    private String master;
    @Value("${sentinel.nodes}")
    private String nodes;

    private Set<String> hosts;

    @PostConstruct
    public void hosts() {
        hosts = new HashSet<>();
        hosts.addAll(Arrays.asList(nodes.split(",")));
    }

    public String getMaster() {
        return master;
    }

    public Set<String> getHosts() {
        return hosts;
    }
}
