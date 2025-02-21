package rate_limiter.scheduled_service.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

public interface IService {
    @RateLimiter(name = "rateLimiterApi")
    public String getInfo();
}
