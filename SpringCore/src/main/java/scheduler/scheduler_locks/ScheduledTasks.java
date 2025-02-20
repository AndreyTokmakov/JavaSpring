package scheduler.scheduler_locks;

import lombok.extern.log4j.Log4j2;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Log4j2
@Component
public class ScheduledTasks
{
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss.SSS] ");

    private static String getCurrentTime() {
        return formatter.format(LocalDateTime.now());
    }

    private void sleep(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public ScheduledTasks() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Scheduled(cron = "${exchange.params.cron.every_second}", zone = "UTC")
    public void taskOne() {
        log.info("taskOne() - {}", getCurrentTime());
        sleep(900);
    }

    @Scheduled(cron = "${exchange.params.cron.every_second}", zone = "UTC")
    @SchedulerLock(name = "TaskScheduler_synchronizeSymbols", lockAtLeastFor = "PT1S", lockAtMostFor = "PT4S")
    public void taskTwo() {
        log.info("taskTwo() - {}", getCurrentTime());
        sleep(900);
    }
}