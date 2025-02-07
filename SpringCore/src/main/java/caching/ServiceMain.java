package caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

// @PropertySource("cloud_service_application.properties")
@EnableAutoConfiguration
@ComponentScan
@RestController
public class ServiceMain {
    public static void main(String[] args)  {
        SpringApplication.run(ServiceMain.class, args);
    }
}

/*
Call 'http://localhost:8080/math/square?value=1' 3 times

1 * 1 = 1
MathController::println(): value = 1, square =1
MathController::println(): value = 1, square =1
MathController::println(): value = 1, square =1

Call 'http://localhost:8080/math/square?value=2' 3 times

2 * 2 = 4
MathController::println(): value = 2, square =4
MathController::println(): value = 2, square =4
MathController::println(): value = 2, square =4

Call 'http://localhost:8080/math/square?value=3' 3 times

3 * 3 = 9
MathController::println(): value = 3, square =9
MathController::println(): value = 3, square =9
MathController::println(): value = 3, square =9
 */