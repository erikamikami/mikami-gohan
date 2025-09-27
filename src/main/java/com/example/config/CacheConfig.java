package com.example.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManeger() {
    // 1時間キャッシュ
    CaffeineCacheManager cacheManager = new CaffeineCacheManager("oneHourCache");
    cacheManager.setCaffeine(
        Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                .maximumSize(1000)
    );
    return cacheManager;
  }
}
