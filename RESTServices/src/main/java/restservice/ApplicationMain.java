package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("rest_service.properties")
public class ApplicationMain
{
	public static void main(String[] args)
	{
		SpringApplication.run(ApplicationMain.class, args);
	}
}

/**
curl http://localhost:8080/greeting?name=User1111
wget http://localhost:8080/greeting?name=User1111222
**/