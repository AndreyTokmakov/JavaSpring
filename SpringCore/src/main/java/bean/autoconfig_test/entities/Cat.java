/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Cat.java class
*
* @name    : Cat.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 5, 2020
****************************************************************************/

package bean.autoconfig_test.entities;

import org.springframework.stereotype.Component;

@Component
public class Cat {
	private String name = "Barsik";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
