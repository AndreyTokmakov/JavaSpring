package request_interceptor_scheduled.scheduler;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import request_interceptor_scheduled.service.Service;

@Log4j2
@Component
public class Scheduler
{
    @Autowired
    Service service;

    public Scheduler() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Scheduled(fixedRate = 1000)
    public void callApiService()
    {
        String response = service.getAccountBalance("12345");
        log.info("callApiService() = {}", response);
    }
}