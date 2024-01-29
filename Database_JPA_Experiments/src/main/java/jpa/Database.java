/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Database.java class
*
* @name    : Database.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
	private static final Logger log = LoggerFactory.getLogger(Database.class);
	
	@Bean
	public CommandLineRunner demo(Repository repository) {
		return (args) -> {
		  // save a few customers
		  repository.save(new Customer("Jack", "Bauer"));
		  repository.save(new Customer("Chloe", "O'Brian"));
		  repository.save(new Customer("Kim", "Bauer"));
		  repository.save(new Customer("David", "Palmer"));
		  repository.save(new Customer("Michelle", "Dessler"));

		  // fetch all customers
		  log.info("Customers found with findAll():");
		  log.info("-------------------------------");
		  for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		  }
		  log.info("");

		  // fetch an individual customer by ID
		  Customer customer = repository.findById(1L);
		  log.info("Customer found with findById(1L):");
		  log.info("--------------------------------");
		  log.info(customer.toString());
		  log.info("");

		  // fetch customers by last name
		  log.info("Customer found with findByLastName('Bauer'):");
		  log.info("--------------------------------------------");
		  repository.findByLastName("Bauer").forEach(bauer -> {
			log.info(bauer.toString());
		  });
		  // for (Customer bauer : repository.findByLastName("Bauer")) {
		  //  log.info(bauer.toString());
		  // }
		  log.info("");
		};
	}
}
