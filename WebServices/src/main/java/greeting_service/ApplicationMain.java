/****************************************************************************
* Copyright 2021 (C) Andrei Tokmakov
* ApplicationMain.java class
*
* @name    : ApplicationMain.java
* @author  : Tokmakov Andrei
* @version : 1.0
* @since   : Jan 3, 2021
****************************************************************************/

package greeting_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain
{
	public static void main(String[] args)
	{
		SpringApplication.run(ApplicationMain.class, args);
	}
}