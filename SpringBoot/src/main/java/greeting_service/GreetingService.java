/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* GreetingService.java class
*
* @name    : GreetingService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package greeting_service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class GreetingService {
	
	public GreetingService() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	public String greet() {
		log.info("Returning greeting text!");
		return "Hello, World";
	}
}