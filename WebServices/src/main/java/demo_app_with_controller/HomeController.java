/****************************************************************************
* Copyright 2021 (C) Andrei Tokmakov
* HomeController.java class
*
* @name    : HomeController.java
* @author  : Tokmakov Andrei
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package demo_app_with_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {
	
	public HomeController() {
        log.info("{} created!", this.getClass().getSimpleName());
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