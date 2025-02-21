package rate_limiter.scheduled_service.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Log4j2
@Component
public class ExternalService implements IService
{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss.SSS] ");

    public ExternalService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    @RateLimiter(name = "simpleRateLimit")
    public String getInfo()
    {
        return "Info { \"time\": " +   formatter.format(LocalDateTime.now()) + "}";
    }
}
