package com.example.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // key serialize
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value serialize
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash: key serialize
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash: value serialize
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        // insert connection factory
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public DefaultRedisScript<Boolean> script(){
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        //lock.lua脚本位置和application.yml同级目录
        redisScript.setLocation(new ClassPathResource("lock.lua"));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}
