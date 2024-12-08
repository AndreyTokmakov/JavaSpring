package department_repository_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("department_repository_service.properties")
@SpringBootApplication 
public class ServiceMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceMain.class, args);
    }
}
