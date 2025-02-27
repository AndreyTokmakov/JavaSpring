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

    //@Scheduled(cron = "${exchange.params.cron.every_second}", zone = "UTC")
    public void everySecondTask() {
        log.info("everySecondTask({})", timeService.getCurrentTime());
    }

    //@Scheduled(cron = "${exchange.params.cron.every_minute}", zone = "UTC")
    public void everyMinuteTask() {
        log.info("everyMinuteTask({})", timeService.getCurrentTime());
    }

    //@Scheduled(cron = "${exchange.params.cron.every_hour}", zone = "UTC")
    public void everyHourTask() {
        log.info("everyHourTask({})", timeService.getCurrentTime());
    }

    //@Scheduled(cron = "${exchange.params.cron.test_interval}", zone = "UTC")
    public void testCallback() {
        log.info("testCallback({}) (**** TEST INTERVAL ****)", timeService.getCurrentTime());
    }

    //@Scheduled(cron = "${cron_params.sync.cron.every_second}", zone = "UTC")
    public void xmlFileTest_EverySecond() {
        log.info("xmlFileTest_EverySecond({})", timeService.getCurrentTime());
    }

    // @Scheduled(cron = "${cron_params.sync.cron.every_minute}", zone = "UTC")
    public void xmlFileTest_EveryMinute() {
        log.info("xmlFileTest_EveryMinute({})", timeService.getCurrentTime());
    }

    //@Scheduled(cron = "${cron_params.sync.cron.every_hour}", zone = "UTC")
    public void xmlFileTest_EveryHour() {
        log.info("xmlFileTest_EveryHour({})", timeService.getCurrentTime());
    }

    // @Scheduled(cron = "${cron_params.sync.cron.test}", zone = "UTC")
    public void experimental() {
        log.info("experimental({})", timeService.getCurrentTime());
    }

    // @Scheduled(cron = "0 34 18 * * *")
    @Scheduled(cron = "${cron_params.sync.cron.test}", zone = "Asia/Dubai")
    public void testFunc() {
        System.out.println("=".repeat(180));
        System.out.println(timeService.getCurrentTime());
        System.out.println("=".repeat(180));
    }
}