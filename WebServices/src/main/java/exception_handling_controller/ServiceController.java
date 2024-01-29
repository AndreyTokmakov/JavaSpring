/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceController.java class
*
* @name    : ServiceController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package exception_handling_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import exception_handling_controller.exceptions.NotFoundException;
import exception_handling_controller.exceptions.ServiceException;
import exception_handling_controller.exceptions.ServiceUnavailableException;
import exception_handling_controller.exceptions.BadGatewayException;
import exception_handling_controller.exceptions.ConflictException;
import exception_handling_controller.exceptions.TestException;
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
    	log.info("ServiceController::handleHello() called.");
        return buildResponse("Hello");
    }
    
    // This will casuse HTTP 400 error
    @GetMapping("/bind_exception")
    public ResponseEntity<String> bind_exception(HttpServletRequest request) throws BindException {
    	throw new BindException("", "");
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
    
    // -------------------------------------------------------------------//
    
    @GetMapping("/produceException")
    public String produceException() throws TestException {
    	log.info("ServiceController::produceException() called.");
        throw new TestException("Oooooppps");
    }
    
    @ExceptionHandler(TestException.class)
    public String handleException(TestException exc) {
    	log.info("ServiceController::handleException() called: " + exc.getMessage());

        return buildResponse(exc.getMessage());
    }
    
    //---------------------------------------------------------------------//
    
    // Will cause error 404
    @GetMapping("/exceptions")
    public String produceException(@RequestParam(value = "code", defaultValue = "200") final int code) 
    		throws NotFoundException, TestException, ServiceException {
    	log.info("ServiceController::produceException called(): Code = " + code);
    	switch (code) {
    		case 51:  throw new TestException("Handling code = 51");
    		case 123: throw new ServiceException("Handle code = " + code);
    		case 409: throw new ConflictException();   // HttpStatus.CONFLICT  - 409
    		case 502: throw new BadGatewayException(); // Will cause error 502
    		case 503: throw new ServiceUnavailableException("Handle code = " + code);
    		default: 
    			// Default action.
    			break;
    	}
        throw new NotFoundException();
    }
    
    
    
    // 
    @GetMapping("/produceException502")
    public String produceException502() throws BadGatewayException {
    	log.info("ServiceController::produceException502() throwing RuntimeException502!");
        throw new BadGatewayException();
    }
    
    
    /*
    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value = HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
      // Nothing to do
    }
    */
}