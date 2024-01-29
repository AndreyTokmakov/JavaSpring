/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ExceptionHandlerController.java class
*
* @name    : ExceptionHandlerController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 23, 2021
****************************************************************************/

package exception_handling_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import exception_handling_controller.exceptions.ConflictException;
import exception_handling_controller.exceptions.NotFoundException;
import exception_handling_controller.exceptions.ServiceException;
import exception_handling_controller.exceptions.ServiceUnavailableException;
import exception_handling_controller.exceptions.TestException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerController {
	
	public ExceptionHandlerController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(ConflictException.class)
    public void handleConflictException() {
    	log.error(this.getClass().getSimpleName() + "Handling ConflictException.");
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NotFoundException.class)
    public void notFoundException() {
    	log.error(this.getClass().getSimpleName() + "Handling NotFoundException.");
    }
    
    // @ResponseStatus(HttpStatus.NOT_FOUND) ----> We don't need it here. We return ResponseEntity implicitly
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handleServiceException(final ServiceException exc) {
    	log.info("ExceptionHandlerController::handleServiceException() called");
    	log.info("ExceptionHandlerController::handleServiceException() message: " + exc.getMessage());
    	return ResponseEntity
    			.status(400)
    			.header("Custom-Header", "foo")
    			.body("</bgcolor='black'>ServiceException page</body>");
    }
    
    // This (handleServiceUnavailable) overrides the handleServiceException handler
    // And since ServiceUnavailableException extends ServiceException, all ServiceUnavailableException
    // exceptions will be handled by handleServiceException if we commend method 'handleServiceUnavailable'
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE) 
    @ExceptionHandler(ServiceUnavailableException.class)
    public void handleServiceUnavailable(final ServiceUnavailableException exc) {
    	log.info("ExceptionHandlerController::handleServiceUnavailable() called");
    	log.info("ExceptionHandlerController::handleServiceUnavailable() message: " + exc.getMessage());
    }
}
