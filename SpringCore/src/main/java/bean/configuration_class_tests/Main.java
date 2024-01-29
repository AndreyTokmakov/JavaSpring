/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Main.java class
*
* @name    : Main.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 5, 2020
****************************************************************************/

package bean.configuration_class_tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bean.configuration_class_tests.configs.Config;
import bean.configuration_class_tests.entities.Cat;
import bean.configuration_class_tests.entities.Dog;
import bean.configuration_class_tests.entities.Parrot;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		//ApplicationContext context = new AnnotationConfigApplicationContext(ConfigEx.class);

		Cat cat = context.getBean(Cat.class);
		Dog dog = (Dog) context.getBean("dog");
		Parrot parrot = context.getBean("parrot-kesha", Parrot.class);

		System.out.println(cat.getName());
		System.out.println(dog.getName());
		System.out.println(parrot.getName());

	}
}
