/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Employee.java class
*
* @name    : Employee.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 17, 2021
****************************************************************************/

package service.demo1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
public class Employee 
{
	private long id;
	private String name;
	
	public Employee() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
}