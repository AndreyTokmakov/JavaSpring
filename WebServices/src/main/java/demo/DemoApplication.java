package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s. Now is %s", name, LocalDateTime.now());
	}
	
	@GetMapping("/red")
	public String red(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("<html><body bgcolor='red'><h1>Hello %s</h1></body></html>", name);
	}
}

// Open http://localhost:8080/hello