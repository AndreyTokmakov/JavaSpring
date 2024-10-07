/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* DemoApplication.java class
*
* @name    : DemoApplication.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 26, 2020
****************************************************************************/

package demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@SpringBootApplication
@RestController
public class DemoApplication
{
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World!!!") String name)
	{
        log.info("DemoApplication::hello(name = {})", name);
		return String.format("Hello %s!", name);
	}
}
// Simple which display test "hello world"
// when we open http://127.0.0.1:8080/hello
//              http://127.0.0.1:8080/hello?name=AndTokm