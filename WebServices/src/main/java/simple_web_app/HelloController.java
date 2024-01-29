/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* HelloController.java class
*
* @name    : HelloController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 27, 2020
****************************************************************************/

package simple_web_app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}

/*
 * The class is flagged as a @RestController, meaning it is ready for use by Spring MVC to handle web requests.
 * @RequestMapping maps / to the index() method. 
 * When invoked from a browser or by using curl on the command line, the method returns pure text.
 * That is because @RestController combines @Controller and @ResponseBody, two annotations that results
 *  in web requests returning data rather than a view.
 */