/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* RemoteResource.java class
*
* @name    : RemoteResource.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 28, 2021
****************************************************************************/

package web_service.beans;

import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component("RemoteResource")
public class RemoteResource implements Resource {
	
	public RemoteResource() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "REMORE_RESOURCE";
	}
}
