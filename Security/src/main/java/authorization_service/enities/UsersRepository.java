/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* UsersRepository.java class
*
* @name    : UsersRepository.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Feb 22, 2021
****************************************************************************/

package authorization_service.enities;

public interface UsersRepository {
	public Users findByUsername(String username);
}
