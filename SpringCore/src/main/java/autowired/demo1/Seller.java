/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Seller.java class
*
* @name    : Seller.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lifecycle.InheritingService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Seller {

	public Seller() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @Autowired
    private Shop shop;
}