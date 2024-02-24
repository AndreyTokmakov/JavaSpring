package shcedule_task_2;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Log4j2
@Component
public class ScheduledTasks
{
    public ScheduledTasks() {
        log.info("* * * * * " + this.getClass().getSimpleName() + " is created * * * * ");
    }

    @Scheduled(fixedRate = 5000)
    public void performTask() {
        try {
            log.info("Task performed at {}", LocalDateTime.now());
            // Perform task logic
        } catch (Exception e) {
            log.error("Error during task execution", e);
        }
    }
}