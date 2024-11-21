/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* HelloController.java class
*
* @name    : HelloController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 27, 2020
****************************************************************************/

package simple_example;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class Controller
{
	public Controller()
	{
        log.info("{} created!", this.getClass().getSimpleName());
	}

	@RequestMapping("/")
	public String index()
	{
		final String message = "Test message from Controller::index() method";
        log.info("{}::index() called. Returning: {}", this.getClass().getSimpleName(), message);
		return message;
	}
}