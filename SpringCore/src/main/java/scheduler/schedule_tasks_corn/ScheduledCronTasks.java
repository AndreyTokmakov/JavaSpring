package scheduler.schedule_tasks_corn;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import scheduler.schedule_tasks_corn.services.TimeService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
@Service
public class ScheduledCronTasks
{
    @Autowired
    private TimeService timeService;

    public ScheduledCronTasks() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    // @Scheduled(cron = "${exchange.params.cron.every_second}", zone = "UTC")
    @Scheduled(cron = "${exchange.params.cron.every_minute}", zone = "UTC")
    // @Scheduled(cron = "${exchange.params.cron.every_hour}", zone = "UTC")
    public void callbackTask() {
        log.info("callbackTask() - {}", timeService.getCurrentTime());
    }
}