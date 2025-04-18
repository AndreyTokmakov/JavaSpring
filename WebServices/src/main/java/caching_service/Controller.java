package caching_service;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Log4j2
@RestController
public class Controller
{
    @Autowired
    private InfoCachableService infoCachableService;

    @Autowired
    @Qualifier("Cache_To_Test")
    private CacheManager cacheManager;

    /*
    @Autowired
    public Controller(InfoCachableService infoCachableService) {
        this.infoCachableService = infoCachableService;
        log.info("{} created!", this.getClass().getSimpleName());
    }*/

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(HttpServletRequest request)
    {
        String response = infoCachableService.getInfo();
        log.info("ServiceController::handleHello() called | {}", response);
        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("<html><body bgcolor='gray'>" + response + "</body></html>");
    }


    @GetMapping(value = "/inspectCache")
    public void inspectCache(String cacheName)
    {

        System.out.println(cacheManager.getCacheNames());
        Cache cache = cacheManager.getCache("info-service-get-info");

        cache.clear();


        //CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache(cacheName);
        //Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();

        /*
        Caffeine.from()

        final CaffeineCacheManager cacheManager = new CaffeineCacheManager("info-service-get-info");
        System.out.println(cacheManager.getCacheNames());

        Cache cache = cacheManager.getCache("info-service-get-info");
        //cache.invalidate();
        cache.clear();
        cache.getNativeCache()
        */

        /*
        CaffeineCache cache = (CaffeineCache) cacheManager.getCache("info-service-get-info");
        Cache<Object, Object> nativeCache = cache.getNativeCache();

        for (Map.Entry<Object, Object> entry : nativeCache.asMap().entrySet()) {

            System.out.println("Key = " + entry.getKey());
            System.out.println("Value = " + entry.getValue());
        }*/
    }
}
