/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* HelloController.java class
*
* @name    : HelloController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 15, 2021
****************************************************************************/

package autowired.Inject_Resource;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import autowired.Inject_Resource.beans.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public final class HelloController {
	
	@Autowired
	@Qualifier("RemoteResource")
	private Resource resource;
	
	public HelloController() {
        log.info("{} created!", this.getClass().getSimpleName());
	}
	
    private String formatGreet(final String name) {
        return String.format("Hello, %s", name);
    }
    
    @GetMapping("/resource")
    public String checkResource()
    {
    	final String text = resource.getData();
        log.info("checkResource() called for {}", text);
    	return "<body bgcolor='gray'>" + text + "</body>";
    }
    
    @GetMapping("/hello")
    // @ResponseBody 
    public String handleHello(final String name)
    {
    	log.info("handleHello() called.");
        return "<body bgcolor='gray'>Hello</body>";
    }

    @GetMapping("/info")
    public String handleInfoContext(@RequestParam(value = "name", required = false) final String name)
    {
        log.info("handleInfoContext() called. Params: {}", name);
        if (StringUtils.isEmpty(name)) {
            return formatGreet("Anonymous");
        }
        return formatGreet(name);  
        // CALL: Call http://localhost:8080/info?name=12345
        // CALL: Call http://localhost:8080/info
    }

    @GetMapping("/info1")
    public String handleInfo1Context(@RequestParam(required = false) final String name)
    {
        log.info("handleInfo1Context() called. Params: {}", name);
        return "<body bgcolor='gray'>handleInfoWithParam1</body>";
        // CALL: http://localhost:8080/info?name=12345
        // CALL: http://localhost:8080/info
    }

    @GetMapping("/info2")
    public String handleInfo2Context(@RequestParam Optional<String> name)
    {
        log.info("handleInfo2Context() called. Params: {}", name.orElseGet(() -> "not provided"));
    	return "<body bgcolor='gray'>Hello for " + name.orElseGet(() -> "not provided")+ "</body>";
        // CALL: http://localhost:8080/info2?name=12345
        // CALL: http://localhost:8080/info2
    }

    @GetMapping("/info3")
    public String handleInfo3Context(@RequestParam(defaultValue = "Jonh Dow") String name)
    {
        log.info("handleInfo3Context() called. Params: {}", name);
    	return "<body bgcolor='gray'>Hello for " + name + "</body>";
    	// CALL: http://localhost:8080/info?name=12345
        // CALL: http://localhost:8080/info
    }

    @GetMapping("/info4")
    public String handleInfo4Context(@RequestParam final Map<String,String> allParams)
    {
        log.info("handleInfo4Context() called. Params: {}", allParams.entrySet());
    	return "<body bgcolor='gray'>Params: " +  allParams.entrySet() + "</body>";
    	// CALL:://localhost:8080/info4?param1=value1&param2=value2&param3=value3
    }
     
    @GetMapping("/param_list")
    public String handleParamList(@RequestParam("names") final List<String> names) {
        log.info("handleParamList() called. Names: {}", names);
    	return "<body bgcolor='gray'>Names: " +  names + "</body>";
    	// CALL: http://localhost:8080/param_list?names=1,2,3,4,5
    }
    
    @GetMapping("/messages/{id}")
    public String handleMessageById(@PathVariable("id") final String messageId)
    {
        log.info("handleMessageById() called. Id: {}", messageId);
    	return "<body bgcolor='gray'>Message id: " +  messageId + "</body>";
    	// CALL: http://localhost:8080/messages/123
    }
 
    @GetMapping("/two_params")
    public String handleTwoParamsContext(@RequestParam(value = "name", required = false, defaultValue = "John Dow") final String name,
    								     @RequestParam(value = "id",   required = false, defaultValue = "-1") final int id)
    {
        log.info("handleTwoParamsContext() called. Params: {}", name);
    	return "<body bgcolor='gray'>Hello for " + name + " with id = " + id + "</body>";
    } 
}












