/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* LoadDatabase.java class
*
* @name    : LoadDatabase.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package employee_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
		};
	}
}

/*  
   --- To make it work add this dependencies:

	<dependency>
		<groupId>org.springframework.boot</groupId>
	 	<artifactId>spring-boot-starter-data-jpa</artifactId>
	</dependency>
        
	<dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
	</dependency>
*/