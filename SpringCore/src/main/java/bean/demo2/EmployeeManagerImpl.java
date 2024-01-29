/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* EmployeeManagerImpl.java class
*
* @name    : EmployeeManagerImpl.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 17, 2021
****************************************************************************/

package bean.demo2;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmployeeManagerImpl implements EmployeeManager {
 
    @Override
    public Employee create() {
    	log.info(this.getClass().getSimpleName() + "::create()");
        Employee emp =  new Employee();
        emp.setId(1);
        emp.setName("Lokesh");
        return emp;
    }
    
	public EmployeeManagerImpl() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
}