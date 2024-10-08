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
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("posts")
public class ServicePostController
{
	public ServicePostController() {
        log.info("{} created!", this.getClass().getSimpleName());
	}

	protected void printRequestInfo(final HttpServletRequest request)
	{
		log.info("{} {} {}", request.getMethod(), request.getRequestURI(), request.getProtocol());
		log.info("----------------- Headers: ------------------");
		for (Enumeration<String> v = request.getHeaderNames(); v.hasMoreElements();) {
			String name = v.nextElement();
            log.info("   [{} = {}]", name, request.getHeader(name));
		}
	}
	
    @PostMapping(path = "/context1")
    public void handleContext1(final HttpServletRequest request)
	{
    	log.info("* * * * * * * * * ServicePostController::handleContext1 * * * * * * * * * * ");
		printRequestInfo(request);
    }
	
    @PostMapping(path = "/debug")
    public void debugRequestHandler(@RequestBody String body,
    						        final HttpServletRequest request)
	{
    	log.info("* * * * * * * * * ServicePostController::debugRequestHandler * * * * * * * * * * ");
		printRequestInfo(request);
    	log.info("----------------- Body: ------------------");
    	log.info(body);
    }

	@PostMapping("/markets/{pair}")
	public boolean marketsInfo(@PathVariable("pair") String pair,
							   final HttpServletRequest request)
	{
		log.info("* * * * * * * * * ServicePostController::marketsInfo * * * * * * * * * * ");
		printRequestInfo(request);
		return true;
	}
}
