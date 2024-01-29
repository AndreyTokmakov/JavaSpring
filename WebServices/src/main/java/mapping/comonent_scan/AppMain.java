/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* AppMain.java class
*
* @name    : AppMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

package mapping.comonent_scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "mapping.comonent_scan.controllers") // To scan specific packages!!!
public class AppMain {
  public static void main(String[] args) {
	  
	  //ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
      SpringApplication.run(AppMain.class, args);
  }
}