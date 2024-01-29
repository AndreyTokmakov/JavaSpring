/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceControllerEx.java class
*
* @name    : ServiceControllerEx.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 24, 2021
****************************************************************************/

package mapping.experiments;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController 
@RequestMapping("/restapi/v1.0/subscription")
public class SubscriptionEndpointController {

	public SubscriptionEndpointController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	protected String buildResponse(String name) {
		return "<body bgcolor='gray'>" + name + "</body>";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{subscriptionId}")
    public String findSubscriptionById(@PathVariable  String subscriptionId,
           							   @RequestParam(value = "timeout", defaultValue = "0") int timeout,
           							   @RequestParam(value = "error", defaultValue = "200") int error,
           							   HttpServletResponse response)
    {
    	log.info("SubscriptionEndpointController::findSubscriptionById() called.");
    	log.info("timeout = " + timeout);
    	log.info("error = " + error);
        return buildResponse("Hello for {" + subscriptionId + "}");
    }
}
