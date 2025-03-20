package resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class, args);
    }
}

/**
 Need to add params into 'SpringCore/src/main/resources/application.yml' file

 application_params:
    # service_type: 'real'
    service_type: 'mock'
**/