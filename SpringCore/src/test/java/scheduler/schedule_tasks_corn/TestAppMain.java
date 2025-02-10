package scheduler.schedule_tasks_corn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource(name = "CronSchedulerParameters", value = "test_cron.properties")
public class TestAppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(TestAppMain.class);
    }
}