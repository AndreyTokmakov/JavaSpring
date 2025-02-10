package scheduler.schedule_tasks_corn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource(name = "CronSchedulerParameters", value = "cron.properties")
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class);
    }
}