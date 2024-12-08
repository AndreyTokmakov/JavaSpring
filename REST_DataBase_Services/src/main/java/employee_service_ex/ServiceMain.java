package employee_service_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("employee_service_ex.properties")
@SpringBootApplication 
public class ServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }
}
