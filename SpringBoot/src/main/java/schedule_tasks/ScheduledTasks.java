package schedule_tasks;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class ScheduledTasks
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /*
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        log.info("reportCurrentTime: The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(initialDelay = 1000L, fixedDelay = 2000L)
    public void someJob() throws InterruptedException {
        log.info("someJob () : Current Time is " + dateFormat.format(new Date()));
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        log.info("* * * * scheduleFixedRateTaskAsync: started at " + dateFormat.format(new Date()) + " * * * *");
        Thread.sleep(3000);
        log.info("* * * * scheduleFixedRateTaskAsync: completed at " + dateFormat.format(new Date()) + " * * * *");
    }

    @Async
    @Scheduled(initialDelay = 1000L, fixedRate = 1000)
    public void scheduleFixedRateTaskAsync2() throws InterruptedException {
        log.info("* * * * scheduleFixedRateTaskAsync2: started at " + dateFormat.format(new Date()) + " * * * *");
        Thread.sleep(3000);
        log.info("* * * * scheduleFixedRateTaskAsync2: completed at " + dateFormat.format(new Date()) + " * * * *");
    }*/

    @Scheduled(fixedDelay = 60000L)
    public void periodicTask() {
        log.info("periodicTask () : Current Time is {}", dateFormat.format(new Date()));
    }

}