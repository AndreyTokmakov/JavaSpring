/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceController.java class
*
* @name    : ServiceController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package mapping.experiments;

import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController 
public final class ServiceController {
	
	public ServiceController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	protected String buildResponse(String name) {
		return "<body bgcolor='gray'>" + name + "</body>";
	}
	
    @GetMapping("/hello")
    public String handleHello() {
    	// log.info("ServiceController::handleHello() called.");
        return buildResponse("Hello");
    }
    
    @GetMapping(value = { "/multiple/one", "/multiple/two", "/multiple/three"})
    public String handleMultiple() {
    	log.info("ServiceController::Multiple() called");
        return buildResponse("handleMultiple");
    }
    
    @GetMapping("/hello/*")
    public String handleHelloAll() {
    	log.info("ServiceController::handleHelloAll() called.");
        return buildResponse("HelloAll");
    }

    @GetMapping("/info")
    public String handleInfo(@RequestParam(value = "name", required = false) final String name) {
    	log.info("ServiceController::handleInfo(). Params: " + name);
        return buildResponse("Hello " + name);
        // CALL: http://localhost:8080/info?name=12345 OR http://localhost:8080/info
    }
    
    @GetMapping("/inspect")
    public String inspectParams(final HttpServletRequest request) {
    	log.info("ServiceController::inspectParams()");
    	
    	log.info(request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
    	log.info("Headers:");
    	for (Enumeration<String> v = request.getHeaderNames(); v.hasMoreElements();) {
    		String name = v.nextElement();
    		log.info("   [" + name + " = " + request.getHeader(name) + "]");
    	}
        return buildResponse(new Date().toString());
    }
    
    @GetMapping("/custom_error_500")
    public ResponseEntity<String> customError_500(HttpServletRequest request) {
    	log.info("ServiceController::customError_500() called");
    	return ResponseEntity.status(500)
    	        .header("Custom-Header", "foo")
    	        .body("Custom header set");
    }
    
    @GetMapping("/custom_error_503")
    public ResponseEntity<String> customError_503() {
    	log.info("ServiceController::customError_503() called");
    	return ResponseEntity.status(503)
    	        .header("Custom-Header", "foo")
    	        .body("Custom header set");
    }
}