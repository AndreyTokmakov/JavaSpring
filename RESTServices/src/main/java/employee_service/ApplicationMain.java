/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ApplicationMain.java class
*
* @name    : ApplicationMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("employee_service.properties")
@SpringBootApplication
public class ApplicationMain {
	public static void main(String... args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}

/*

curl http://localhost:8082/employees && echo ""

*/