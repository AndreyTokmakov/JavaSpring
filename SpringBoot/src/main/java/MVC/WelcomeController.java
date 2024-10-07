/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* WelcomeController.java class
*
* @name    : WelcomeController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService service; 

	@RequestMapping("/welcome")
  	public String welcome() {
		return service.getWelcomeMessage();
	}
}