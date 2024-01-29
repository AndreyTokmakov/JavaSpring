/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ServiceConfiguration.java class
*
* @name    : ServiceConfiguration.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 24, 2020
****************************************************************************/

package bean.greeting_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class ServiceConfiguration {
	
    @Bean
    // @Bean(name = "gServiceName")                                         /** HELP:  Used to set specific BEAN name **/
    // @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")    /** HELP:  Used to set specific BEAN name **/
    @Description("Some bean description! Test!!")
    public GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}