package caching_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import java.time.Duration;

@Configuration
// @RefreshScope
@EnableCaching
public class CacheConfigurationManager
{
    @Value("${cache.duration.getInfo}")
    private Duration getInfoCacheDuration;

    @Bean
    public CacheManager getInfoServerCacheConfiguration() {
        return createCacheManager(getInfoCacheDuration, "info-service-get-info");
    }

    private CacheManager createCacheManager(Duration validity, String... cacheNames) {
        var caffeineCacheManager = new CaffeineCacheManager(cacheNames);
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(validity));
        return caffeineCacheManager;
    }
}
