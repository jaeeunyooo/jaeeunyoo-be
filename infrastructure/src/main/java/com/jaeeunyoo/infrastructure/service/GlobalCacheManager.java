package com.jaeeunyoo.infrastructure.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class GlobalCacheManager {

    private final RedissonClient redissonClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T getCache(String key, TypeReference<T> ref) {
        RBucket<String> bucket;
        try {
            bucket = redissonClient.getBucket(key);
            if (bucket.isExists()) {
                return objectMapper.readValue(StringUtils.defaultString(bucket.get(), StringUtils.EMPTY), ref);
            }
            return null;
        } catch (Exception e) {
            log.error("글로벌 캐시 get 실패 : ", e);
            return null;
        }
    }

    public void putCache(TimeUnit timeUnit, Long ttl, String key, Object value) {
        try {
            if (timeUnit != null && ttl != null && StringUtils.isNotBlank(key) && value != null) {
                RBucket<Object> bucket = redissonClient.getBucket(key);
                bucket.setAsync(objectMapper.writeValueAsString(value), ttl, timeUnit);
            }
        } catch (Exception e) {
            log.error("글로벌 캐시 put 실패 : ", e);
        }
    }

    public void evictCache(String key) {
        try {
            RBucket<Object> bucket = redissonClient.getBucket(key);
            bucket.delete();
        } catch (Exception e) {
            log.error("글로벌 캐시 evict 실패 :", e);
        }
    }
}