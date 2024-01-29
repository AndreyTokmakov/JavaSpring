/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Config.java class
*
* @name    : Config.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 5, 2020
****************************************************************************/

package bean.configuration_class_tests.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bean.configuration_class_tests.entities.Cat;
import bean.configuration_class_tests.entities.Dog;
import bean.configuration_class_tests.entities.Parrot;

@Configuration
public class Config {
	
	@Bean
	public Cat getCat() {
		return new Cat();
	}
	
	@Bean
	public Dog dog() {
		return new Dog();
	}
	
	@Bean("parrot-kesha")
	public Object weNeedMoreParrots() {
		return new Parrot();
	}
}