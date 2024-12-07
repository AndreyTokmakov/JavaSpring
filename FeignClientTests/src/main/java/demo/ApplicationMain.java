package demo;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableConfigurationProperties
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = "trade_proxy.integration")
@SpringBootApplication(scanBasePackages = {"demo"})
public class ApplicationMain
{
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}
