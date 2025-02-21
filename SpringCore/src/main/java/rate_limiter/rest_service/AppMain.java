package rate_limiter.rest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
// @PropertySource("application.yml")
// @ComponentScan(basePackages = "rate_limiter")
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class, args);
    }
}