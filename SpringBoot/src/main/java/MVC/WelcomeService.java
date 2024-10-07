/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* WelcomeService.java class
*
* @name    : WelcomeService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package MVC;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class WelcomeService {
	
	public WelcomeService() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	public String getWelcomeMessage() {
		log.info("Returning Welcome message!");
		return "Hello, World";
	}
}