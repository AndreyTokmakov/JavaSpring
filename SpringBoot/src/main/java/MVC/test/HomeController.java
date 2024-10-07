/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* HomeController.java class
*
* @name    : HomeController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package MVC.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/"})
@CrossOrigin(origins = "*")
public class HomeController {

    public HomeController() {
    }

    @RequestMapping(value = {"/index", "/home"}, method = RequestMethod.GET) //FIXME
    public ModelAndView defaultMethod() {
        System.out.println("home");
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }
}