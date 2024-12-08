package demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableConfigurationProperties
// @EnableDiscoveryClient
// @EnableFeignClients(basePackages = "demo")
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"demo"})
public class ApplicationMain
{
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}
