/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Users.java class
*
* @name    : Users.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Feb 22, 2021
****************************************************************************/

package authorization_service.enities;

import lombok.NonNull;
import lombok.Value;

@Value
public class Users {
	@NonNull 
	private String id;
	
	@NonNull 
    private String username;
	
	@NonNull 
    private String password;
}
