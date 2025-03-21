package service_rate_limiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients
@PropertySource("rate_limiter.properties")
public class ApplicationMain
{
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}