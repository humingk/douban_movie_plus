package org.humingk.common.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Redis 配置类
 * <p>
 * EnableCaching :  开启缓存
 *
 * @author humingk
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 缓存过期时间 day
     */
    private final int EXPIRE_DAY = 5;

    /**
     * redis工厂
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    /**
     * 自定义生成key的规则
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return (object, method, objects) -> {
            // 格式化缓存key字符串
            StringBuilder stringBuilder = new StringBuilder();
            // 追加参数
            for (Object obj : objects) {
                stringBuilder.append(obj.toString());
                stringBuilder.append("_");
            }
            // 追加方法名
            stringBuilder.append(method.getName());
            stringBuilder.append("_");
            // 追加类名
            stringBuilder.append(object.getClass().getName());
            return stringBuilder.toString();
        };
    }


    /**
     * 采用RedisCacheManager作为缓存管理器
     * <p>
     * 添加注解@cacheable即可自动缓存到redis
     * <p>
     * 其他注解:@cacheconfig @cachePut 更新 @cacheEvict 删除
     * <p>
     * spring2.0.2之后,配置redisTemplate无法影响@cacheable注解,需单独配置fastjson序列化
     *
     * @return
     */
    @Bean
    @Override
    public CacheManager cacheManager() {
        // 初始化redisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        // 使用JfastJsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        // 设置过期时间
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofDays(5));
        //初始化RedisCacheManager
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        // 序列化白名单
        ParserConfig.getGlobalInstance().addAccept("org.humingk.movie.");
        return redisCacheManager;
    }


    /**
     * redis操作模板
     * <p>
     * 包括 set get 等方法
     * <p>
     * 由默认的JDK序列化改为fastjson序列化
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "RedisTemplate")
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();

        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
