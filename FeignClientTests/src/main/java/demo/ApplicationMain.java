package demo;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@EnableConfigurationProperties
// @EnableDiscoveryClient
@EnableFeignClients(clients=EternalServiceClient.class)
// @EnableFeignClients
@SpringBootApplication(scanBasePackages = {"demo"})
// @ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ApplicationMain
{
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}
