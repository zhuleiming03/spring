package spring.boot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        //使用 Jackson2JsonRedisSerializer 来序列化和反序列化 redis 的 value 值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer<Object> jacksonSerializer = new Jackson2JsonRedisSerializer<Object>(
                Object.class);
        jacksonSerializer.setObjectMapper(jacksonConfig.objectMapper());

        // 设置键（key）的序列化采用 StringRedisSerializer。
        template.setKeySerializer(new StringRedisSerializer());
        // 设置值（value）的序列化采用 FastJsonRedisSerializer。
        template.setValueSerializer(jacksonSerializer);
        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerializer);
        template.afterPropertiesSet();

        return template;
    }

    @Resource
    private JacksonConfig jacksonConfig;

}
