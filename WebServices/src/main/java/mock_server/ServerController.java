/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceController.java class
*
* @name    : ServiceController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package mock_server;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Constants enumerating the mocking headers and parameters names.
 */
final class RequestFields {
	
    private RequestFields() {
        // Don't allow instantiation.
    	throw new RuntimeException("... and no reflection please.");
    }

	/** HTTP request block parameters name: **/
	public final static String REQUEST_PARAM = "request";	
	
	/** HTTP response block parameters name: **/
	public final static String RESPONSE_PARAM = "response";
	
	/** HTTP request URI parameters name: **/
	public final static String REQUEST_URL = "url";
	
	/** HTTP method parameters name: **/
	public final static String REQUEST_METHOD = "method";
	
	/** HTTP response body/payload parameters name: **/
	public final static String RESPONSE_BODY = "body";
	
	/** HTTP response status (code) parameters name: **/
	public final static String RESPONSE_STATUS = "status";
	
	/** HTTP response delay (ms) parameters name: **/
	public final static String RESPONSE_DELAY = "delay";
	
	/** HTTP response headers parameters name: **/
	public final static String RESPONSE_HEADERS = "headers";
}

@Data
class ResponseMapping {
	/** HTTP Response status: **/
    private int status = 200;
    
    /** HTTP Response body/payload: **/
    private String body;

    /** HTTP Response delay (milliseconds): **/
    private int delay = 0;

    /** HTTP Response headers: **/
    private Map<String, String> headers;
}


@Log4j2
@RestController 
public final class ServerController {
	/** Gson instance. **/
	private final static Gson gson = new Gson();
	
	/** Mock-Map: **/
	private Map<String, ResponseMapping> mapping = new HashMap<String, ResponseMapping>();
	
	public ServerController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	@GetMapping({"/", "*", "*/*", "*/*/*", "*/*/*/*", "*/*/*/*/*"})
    public ResponseEntity<String> handleGET(final HttpServletRequest request) {
		final ResponseMapping stub = mapping.get(request.getRequestURI());
		if (null == stub) {
			return ResponseEntity.status(404)
				.body("<body bgcolor='gray'>Your page ain't here, kid (^_^)</body>");
		}
		
		return ResponseEntity.status(stub.getStatus()).body(stub.getBody());
    }

    
    @PostMapping(path = "/mapping",
    		     consumes = MediaType.APPLICATION_JSON_VALUE,
    		     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> handlePOST(final HttpServletRequest request, 
    						 @RequestBody String content) {
    	final JsonObject jsonObject = new Gson().fromJson(content, JsonObject.class);
    	
     	JsonObject requestParams  = (JsonObject) jsonObject.get(RequestFields.REQUEST_PARAM);
    	JsonObject responseParams = (JsonObject) jsonObject.get(RequestFields.RESPONSE_PARAM);
    	
    	ResponseMapping stub = new ResponseMapping();
    	if (false == parseResponse(responseParams, stub))  {
    		return ResponseEntity.status(500).
    			body("<body bgcolor='black'>Grats. You broke it. </body>");
    	}
    	
    	this.mapping.put(requestParams.get(RequestFields.REQUEST_URL).getAsString(), stub);
    	return ResponseEntity.ok().body("{\"status\": \"ok\"}");
    }
    
    private boolean parseResponse(final JsonObject response, 
    							  ResponseMapping mapping) {
    	try {
        	JsonElement value = response.get(RequestFields.RESPONSE_BODY);
        	if (null != value)
        		mapping.setBody(value.getAsString());
        	
        	value = response.get(RequestFields.RESPONSE_STATUS);
        	if (null != value)
        		mapping.setStatus(value.getAsInt());
        	
        	value = response.get(RequestFields.RESPONSE_DELAY);
        	if (null != value)
        		mapping.setDelay(value.getAsInt());
        	
        	value = response.get(RequestFields.RESPONSE_HEADERS);
        	if (null != value)
        		mapping.setHeaders(gson.fromJson(value, Map.class));
    	}
    	catch (Exception exc) {
    		log.error(exc);
    		return false;
    	}
    	return true;
    }
}