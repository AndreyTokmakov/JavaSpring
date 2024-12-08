package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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