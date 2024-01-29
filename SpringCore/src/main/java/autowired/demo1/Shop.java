/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Shop.java class
*
* @name    : Shop.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo1;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Shop {
	
	public Shop() {
		log.info(this.getClass().getSimpleName() + " crated!");
	}
}