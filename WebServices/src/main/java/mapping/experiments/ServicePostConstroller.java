/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServicePostConstroller.java class
*
* @name    : ServicePostConstroller.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 25, 2021
****************************************************************************/

package mapping.experiments;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/posts")
public class ServicePostConstroller {
	
	public ServicePostConstroller() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @PostMapping(path = "/context1")
    public void handleContext1(final HttpServletRequest request) {
    	log.info("* * * * * * * * * ServicePostConstroller::handleContext1 * * * * * * * * * * ");
    	log.info(request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
    	log.info("----------------- Headers: ------------------");
    	for (Enumeration<String> v = request.getHeaderNames(); v.hasMoreElements();) {
    		String name = v.nextElement();
    		log.info("   [" + name + " = " + request.getHeader(name) + "]");
    	}
    }
	
    @PostMapping(path = "/debug")
    public void debugRequestHandler(@RequestBody String body,
    						        final HttpServletRequest request) {
    	log.info("* * * * * * * * * ServicePostConstroller::debugRequestHandler * * * * * * * * * * ");
    	log.info(request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
    	log.info("----------------- Headers: ------------------");
    	for (Enumeration<String> v = request.getHeaderNames(); v.hasMoreElements();) {
    		String name = v.nextElement();
    		log.info("   [" + name + " = " + request.getHeader(name) + "]");
    	}
    	log.info("----------------- Body: ------------------");
    	log.info(body);
    }
}
