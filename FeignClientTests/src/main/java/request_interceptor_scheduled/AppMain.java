package request_interceptor_scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "request_interceptor_scheduled.clients")
// @PropertySource(name = "CronSchedulerParameters", value = "cron.properties")
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class);
    }
}