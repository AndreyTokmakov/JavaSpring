/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* HelloWorldController.java class
*
* @name    : HelloWorldController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/greeting")
	public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World")
									   String name, 
									   Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}