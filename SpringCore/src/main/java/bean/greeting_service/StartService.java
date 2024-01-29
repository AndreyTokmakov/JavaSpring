/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* StartService.java class
*
* @name    : StartService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 24, 2020
****************************************************************************/

package bean.greeting_service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartService {

    private static final Logger logger = LogManager.getLogger(StartService.class);

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        logger.info("Starting configuration...");

        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        logger.info(greetingService.sayGreeting());  // "Greeting, user!"
    }
}