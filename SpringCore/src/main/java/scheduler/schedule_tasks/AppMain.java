package scheduler.schedule_tasks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class);
    }
}