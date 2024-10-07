/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* InternalController.java class
*
* @name    : InternalController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 29, 2021
****************************************************************************/

package experimental_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/internal")
public class InternalController {
	
	public InternalController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @GetMapping("/state")
    public ResponseEntity<String> getS() {
    	log.info("InternalController::getHealthCheckForBalancer() called");
    	return ResponseEntity.status(200)
    	        .header("Custom-Header", "foo")
    	        .body("Health response.");
    }
    
    /*
    @GetMapping(value = "/health/state")
    public void setHealthCheckState(@RequestParam(value = "state", required = false, defaultValue = "true") boolean state) {
    	log.info("InternalController::setHealthCheckState(): state = " + state);
    	isHealthOK = state;
    }
    */
}