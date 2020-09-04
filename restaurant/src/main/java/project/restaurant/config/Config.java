package project.restaurant.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import project.restaurant.model.RestaurantDto;

@Configuration
public class Config {
    @Bean
    public static JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    public static RedisTemplate<String, RestaurantDto> redisTemplate() {
        RedisTemplate<String, RestaurantDto> redisTemplate = new RedisTemplate<String ,RestaurantDto>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
