/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* FastProdEmployeeService.java class
*
* @name    : FastProdEmployeeService.java
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
@Profile("prod & fast")
public class FastProdEmployeeService implements EmployeeService {

	public FastProdEmployeeService() {
		log.info(this.getClass().getName() + " created. PROD & FAST");
	}
}