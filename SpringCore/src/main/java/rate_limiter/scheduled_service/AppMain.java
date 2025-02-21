package rate_limiter.scheduled_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class, args);
    }
}

/**
 [scheduling-1]  RateLimiter 'simpleRateLimit' does not permit further calls
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:25.714 }
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:25.715 }
 [scheduling-1]  RateLimiter 'simpleRateLimit' does not permit further calls
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:27.714 }
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:27.715 }
 [scheduling-1]  RateLimiter 'simpleRateLimit' does not permit further calls
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:29.714 }
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:29.715 }
 [scheduling-1]  RateLimiter 'simpleRateLimit' does not permit further calls
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:31.714 }
 [scheduling-1]  reportCurrentTime: The time is now Info { "time": 2025-02-21 09:44:31.715 }
 **/

