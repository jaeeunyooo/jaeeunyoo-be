package com.jaeeunyoo.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public enum GlobalCache {

    SAMPLE(TimeUnit.HOURS, 1L, "SAMPLE_");

    private final TimeUnit timeUnit;
    private final Long ttl;
    private final String cacheKeyPrefix;

    public String generateCacheKey(String cacheKeyInfo) {
        return this.cacheKeyPrefix + cacheKeyInfo;
    }
}
