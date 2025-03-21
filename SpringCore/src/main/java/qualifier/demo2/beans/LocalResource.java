/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* LocalResource.java class
*
* @name    : LocalResource.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 28, 2021
****************************************************************************/

package qualifier.demo2.beans;

import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component("LocalResource")
public class LocalResource implements Resource {

	public LocalResource() {
        log.info("{} created!", this.getClass().getSimpleName());
	}
	
	@Override
	public String getData()
	{
		return "LOCAL_RESOURCE";
	}
}
