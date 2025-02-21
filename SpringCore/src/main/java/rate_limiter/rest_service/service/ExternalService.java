package rate_limiter.rest_service.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Log4j2
@Component
public class ExternalService implements IService
{
    public ExternalService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    @RateLimiter(name = "simpleRateLimit")
    public String getInfo()
    {
        return "Info { \"time\": " +   LocalDateTime.now() + "}";
    }
}
