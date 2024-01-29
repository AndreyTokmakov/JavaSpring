/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* PrincipalService.java class
*
* @name    : PrincipalService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo2;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PrincipalService {
	
	public PrincipalService() {
		log.info(this.getClass().getSimpleName() + " created!");
	}

    public void administer() {
        System.out.println("Administering the school.");
    }
}
