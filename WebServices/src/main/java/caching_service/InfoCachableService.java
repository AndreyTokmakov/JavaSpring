package caching_service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class InfoCachableService
{
    private String getTimestamp() {
        return DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
    }

    @Cacheable(value = "info-service-get-info", cacheManager = "getInfoServerCacheConfiguration")
    public String getInfo()
    {
        return getTimestamp();
    }
}
