package rate_limiter.rest_service.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

public interface IService {
    @RateLimiter(name = "rateLimiterApi")
    public String getInfo();
}
