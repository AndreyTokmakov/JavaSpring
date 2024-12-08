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

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
class LoadDatabase
{
	public LoadDatabase()
	{
		log.info("LoadDatabase created!. Class name: {}", this.getClass().getSimpleName());
	}

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository)
	{
		log.info("LoadDatabase::initDatabase() called");
		return args -> {
            log.info("Preloading {}", repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading {}", repository.save(new Employee("Frodo Baggins", "thief")));
		};
	}
}