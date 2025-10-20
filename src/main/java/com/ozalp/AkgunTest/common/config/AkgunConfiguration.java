package com.ozalp.AkgunTest.common.config;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.UnifiedJedis;

@Configuration
public class AkgunConfiguration {

    @Value("${redisUrl}")
    private String redisUrl;

    @Bean
    public UnifiedJedis getRedis() {
        return new UnifiedJedis(redisUrl);
    }

    @Bean
    public Gson getGson() {
        return new Gson();
    }
}

