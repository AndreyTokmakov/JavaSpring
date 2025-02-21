package rate_limiter.scheduled_service.tasks;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rate_limiter.scheduled_service.service.IService;

@Log4j2
@Component
public class ScheduledTasks
{
    @Autowired
    private IService service;

    @Scheduled(fixedRate = 250)
    public void reportCurrentTime()
    {
        try {
            log.info("reportCurrentTime: The time is now {}", service.getInfo());
        }
        catch (final RequestNotPermitted exc) {
            log.info(exc.getMessage());
        }
    }
}