package caching_service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfigurationManager
{
    @Value("${cache.duration.getInfo}")
    private Duration getInfoCacheDuration;

    @Bean
    @Qualifier("Cache_To_Test")
    @Primary
    public CacheManager getInfoServerCacheConfiguration() {
        return createCacheManager(getInfoCacheDuration, "info-service-get-info");
    }

    @Bean
    public CacheManager getInfoServerCacheConfigurationSecond() {
        return createCacheManager(getInfoCacheDuration, "info-service-get-info-second");
    }

    private CacheManager createCacheManager(Duration validity, String... cacheNames) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager(cacheNames);
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(validity));
        return caffeineCacheManager;
    }
}


// Call http://localhost:8080/info
/*
[http-nio-8080-exec-1] INFO org.springframework.web.servlet.DispatcherServlet - Completed initialization in 1 ms
[http-nio-8080-exec-1] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:10.564418943
[http-nio-8080-exec-2] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:10.564418943
[http-nio-8080-exec-3] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:10.564418943
[http-nio-8080-exec-4] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-5] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-6] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-7] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-8] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-9] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-1] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-1] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:22.694530423
[http-nio-8080-exec-2] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:33.419791603
[http-nio-8080-exec-3] INFO caching_service.Controller - ServiceController::handleHello() called | 2025-04-18T16:03:33.419791603
 */