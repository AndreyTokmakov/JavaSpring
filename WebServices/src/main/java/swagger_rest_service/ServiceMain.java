package swagger_rest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ServiceMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceMain.class, args);
    }
}

// http://localhost:8080/swagger-ui/index.html#