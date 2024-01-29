/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceController.java class
*
* @name    : ServiceController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package exception_handling;

import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.log4j.Log4j2;


class TestException extends Exception {
	/** **/
	private static final long serialVersionUID = 1L;

	public TestException() {
		super();
	}

	public TestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TestException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestException(String message) {
		super(message);
	}

	public TestException(Throwable cause) {
		super(cause);
	}
}


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not found")
class UserNotFoundException extends RuntimeException {

}

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "BAD_GATEWAY")
class RuntimeException502 extends RuntimeException {

}

/*
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Employee isn't authorized")
class EmployeeAccessDeniedException extends Exception {
    public EmployeeAccessDeniedException(String msg) {
        super(msg);
    }
}
*/

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
    @GetMapping("/produceException2")
    public String produceException2() throws UserNotFoundException {
    	log.info("ServiceController::produceException2() throwing UserNotFoundException!");
        throw new UserNotFoundException();
    }
    
    
    
    // Will cause error 502
    @GetMapping("/produceException502")
    public String produceException502() throws RuntimeException502 {
    	log.info("ServiceController::produceException2() throwing UserNotFoundException!");
        throw new RuntimeException502();
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