package rate_limiter.experiments;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

public interface IEndpoint {
    @RateLimiter(name = "simpleRateLimit")
    public void getInfo();
}
