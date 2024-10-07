/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* HomeController.java class
*
* @name    : HomeController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package demo_app;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class HomeController {
	
	public HomeController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}

	@RequestMapping("/")
	public @ResponseBody String greeting() {
		log.info("Returning greeting text!");
		return "Hello, World";
	}
	
	@GetMapping("/test1")
	public @ResponseBody String handleTest() {
		log.info("handleTest");
		return "Here is the test1 page";
	}
}