/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* GreetingServiceImpl.java class
*
* @name    : GreetingServiceImpl.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 24, 2020
****************************************************************************/

package bean.greeting_service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GreetingServiceImpl implements GreetingService {

	private static final Logger logger = LogManager.getLogger(GreetingServiceImpl.class);
	  
	public GreetingServiceImpl() {
		logger.info(this.getClass().getName() + " created");
	}
	
    @Override
    public String sayGreeting() {
        return "Greeting, user!";
    }
}