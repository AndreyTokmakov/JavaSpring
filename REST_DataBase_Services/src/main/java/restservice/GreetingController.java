package restservice;

import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class GreetingController
{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	public GreetingController()  {
		log.info("{} created!", this.getClass().getSimpleName());
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		log.info("GreetingController::greeting({}) called", name);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
