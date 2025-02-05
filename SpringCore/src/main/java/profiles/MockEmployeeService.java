/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* MockEmployeeService.java class
*
* @name    : MockEmployeeService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@Profile("!prod")
public class MockEmployeeService implements EmployeeService
{
	public MockEmployeeService(){
        log.info("{} created. NOT PROD!", this.getClass().getName());
	}
}