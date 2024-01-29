/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Main.java class
*
* @name    : Main.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 5, 2020
****************************************************************************/

package bean.autoconfig_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bean.autoconfig_test.entities.Cat;
import bean.autoconfig_test.entities.Dog;
import bean.autoconfig_test.entities.Parrot;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("bean.autoconfig_test.entities");

		Cat cat = context.getBean(Cat.class);
		Dog dog = (Dog) context.getBean("dog");
		Parrot parrot = context.getBean("parrot-kesha", Parrot.class);

		System.out.println(cat.getName());
		System.out.println(dog.getName());
		System.out.println(parrot.getName());

	}
}
