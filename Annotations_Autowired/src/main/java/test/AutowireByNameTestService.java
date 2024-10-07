/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* AutowireByNameTestService.java class
*
* @name    : AutowireByNameTestService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 14, 2020
****************************************************************************/

package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowireByNameTestService {
	@Autowired
	private IDao employeeDao;
  
	@Autowired
	private IDao customerDao;
  
	public void printResults() {
		System.out.println("\n ------ Autowire By Name Results ------");
		employeeDao.result();
		customerDao.result();
	}
}