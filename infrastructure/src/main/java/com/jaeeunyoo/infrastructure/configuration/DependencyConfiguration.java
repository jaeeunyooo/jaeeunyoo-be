package com.jaeeunyoo.infrastructure.configuration;

import com.jaeeunyoo.cache.redis.RedisCacheConfiguration;
import com.jaeeunyoo.datasource.mysql.DataSourceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ DataSourceConfiguration.class, RedisCacheConfiguration.class })
@Configuration
public class DependencyConfiguration {
}
