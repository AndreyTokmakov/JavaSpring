package sprint_clound_config_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource("cloud_service_application.properties")
@EnableAutoConfiguration
@ComponentScan
@RestController
// @RefreshScope
public class ServiceMain
{
    /*
    @Value("${bar:World!}")
    String bar;

    @RequestMapping("/")
    String hello() {
        return "Hello " + bar + "!";
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }
}
