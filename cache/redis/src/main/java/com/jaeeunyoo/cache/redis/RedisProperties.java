package com.jaeeunyoo.cache.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "redis.redis-server-config")
public class RedisProperties {

    private String address;
    private int idleConnectionTimeout;
    private int connectTimeout;
    private int timeout;
    private int retryAttempts;
    private int retryInterval;
    private int subscriptionsPerConnection;
    private int subscriptionConnectionMinimumIdleSize;
    private int subscriptionConnectionPoolSize;
    private int connectionMinimumIdleSize;
    private int connectionPoolSize;
    private int database;
    private int dnsMonitoringInterval;
    private int threads;
    private int nettyThreads;
    private String transportMode;
}