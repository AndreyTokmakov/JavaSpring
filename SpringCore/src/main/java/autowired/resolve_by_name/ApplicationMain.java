/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ApplicationMain.java class
*
* @name    : ApplicationMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 14, 2020
****************************************************************************/

package autowired.resolve_by_name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain 
{
	public static void main(String[] args) 
	{
	    final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigForAutowired.class);
	    AutowireByNameTestService service = ctx.getBean(AutowireByNameTestService.class);
		service.printResults();
	}
}
