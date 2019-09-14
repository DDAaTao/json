package com.xxs.json.common;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author van
 */
@Configuration
public class CaffeineCacheConfig {
    /**
     * 默认缓存数量
     * */
    private static final int DEFAULT_MAXSIZE = 100;
    /**
     * 默认有效期
     * */
    private static final int DEFAULT_TTL = 600;

    public enum Caches{
        /**
         * 配置数据缓存
         * */
        CONFIG(6000, 100);

        @Getter
        private int ttl;
        @Getter
        private int maxSize;

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }
    }

    /**
     * 创建基于Caffeine的Cache Manager
     * Primary注解表示注入的时候优先选择
     * */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager(){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> cacheList = Lists.newArrayList();
        for (Caches value : Caches.values()) {
            cacheList.add(new CaffeineCache(value.name(),
                    Caffeine.newBuilder().recordStats()
                            .expireAfterWrite(value.ttl, TimeUnit.SECONDS)
                            .maximumSize(value.getMaxSize()).build()));
        }
        simpleCacheManager.setCaches(cacheList);
        return simpleCacheManager;
    }
}
