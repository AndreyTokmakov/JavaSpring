/****************************************************************************
* Copyright 2021 (C) Andrei Tokmakov
* GreetingController.java class
*
* @name    : GreetingController.java
* @author  : Tokmakov Andrei
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package greeting_service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class GreetingController {

	private final GreetingService service;

	public GreetingController(GreetingService service) {
		log.info(this.getClass().getSimpleName() + " created!");
		this.service = service;
	}

	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		log.info("GreetingController::greeting()");
		return service.greet();
	}

}