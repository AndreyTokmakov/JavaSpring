/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ApplicationMain.java class
*
* @name    : ApplicationMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 14, 2020
****************************************************************************/

package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain 
{
	public static void main(String[] args) 
	{
	    ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfigForAutowired.class);	    	
	    AutowireByNameTestService abnts = ctxt.getBean(AutowireByNameTestService.class);
	    abnts.printResults();
	}
}
