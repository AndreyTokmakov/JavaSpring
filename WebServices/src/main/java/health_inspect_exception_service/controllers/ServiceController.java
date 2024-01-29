
package health_inspect_exception_service.controllers;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.exceptions.BadGatewayException;
import common.exceptions.ConflictException;
import common.exceptions.NotFoundException;
import common.exceptions.ServiceException;
import common.exceptions.ServiceUnavailableException;
import common.exceptions.TestException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController 
@RequestMapping("/service")
public final class ServiceController {
	
	public ServiceController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	private String buildResponse(String name) {
		return "<body bgcolor='gray'>" + name + "</body>";
	}
	
    @GetMapping("/hello")
    public String handleHello() {
    	log.info("ServiceController::handleHello() called.");
        return buildResponse("Hello");
    }
    
    // This will cause HTTP 400 error
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
    
    /*
    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value = HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
      // Nothing to do
    }
    */
}