package scheduler.shcedule_task_2;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Log4j2
@Component
public class ProgrammaticallyScheduledTasks
{
    private final TaskScheduler taskScheduler;

    @Autowired
    public ProgrammaticallyScheduledTasks(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
        scheduleTask();
    }

    public void scheduleTask() {
        Runnable task = () -> log.info("Programmatically scheduled task performed at {}", LocalDateTime.now());
        taskScheduler.scheduleWithFixedDelay(task, Duration.ofSeconds(5));
    }
}