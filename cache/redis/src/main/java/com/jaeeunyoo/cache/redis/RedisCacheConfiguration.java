package com.jaeeunyoo.cache.redis;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({ RedisProperties.class})
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 604800)
public class RedisCacheConfiguration {

    private final RedisProperties redisProperties;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setThreads(redisProperties.getThreads());
        config.setNettyThreads(redisProperties.getNettyThreads());
        config.setTransportMode(getTransportMode(redisProperties.getTransportMode()));
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress(redisProperties.getAddress());
        singleServerConfig
            .setIdleConnectionTimeout(redisProperties.getIdleConnectionTimeout())
            .setIdleConnectionTimeout(redisProperties.getIdleConnectionTimeout())
            .setConnectTimeout(redisProperties.getConnectTimeout())
            .setTimeout(redisProperties.getTimeout())
            .setRetryAttempts(redisProperties.getRetryAttempts())
            .setRetryInterval(redisProperties.getRetryInterval())
            .setSubscriptionsPerConnection(redisProperties.getSubscriptionsPerConnection())
            .setSubscriptionConnectionMinimumIdleSize(redisProperties.getSubscriptionConnectionMinimumIdleSize())
            .setSubscriptionConnectionPoolSize(redisProperties.getSubscriptionConnectionPoolSize())
            .setConnectionMinimumIdleSize(redisProperties.getConnectionMinimumIdleSize())
            .setConnectionPoolSize(redisProperties.getConnectionPoolSize())
            .setDatabase(redisProperties.getDatabase())
            .setDnsMonitoringInterval(redisProperties.getDnsMonitoringInterval());
        return Redisson.create(config);
    }

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient client) {
        return new RedissonConnectionFactory(client);
    }

    private TransportMode getTransportMode(String transportMode) {
        if ("NIO".equalsIgnoreCase(transportMode)) {
            return TransportMode.NIO;
        }
        if ("EPOLL".equalsIgnoreCase(transportMode)) {
            return TransportMode.EPOLL;
        }
        if ("KQUEUE".equalsIgnoreCase(transportMode)) {
            return TransportMode.KQUEUE;
        }

        return TransportMode.NIO;
    }
}
