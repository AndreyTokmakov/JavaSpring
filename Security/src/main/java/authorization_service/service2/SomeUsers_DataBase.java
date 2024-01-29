/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* SomeUsers_DataBase.java class
*
* @name    : SomeUsers_DataBase.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Feb 22, 2021
****************************************************************************/

package authorization_service.service2;

import authorization_service.enities.Users;
import authorization_service.enities.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SomeUsers_DataBase implements UsersRepository {

	public SomeUsers_DataBase() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	@Override
	public Users findByUsername(String username) {
		log.info("SomeUsers_DataBase::findByUsername(): User = " + username);
		return new Users("007", "tester", "$2y$12$0bC0p9c6W0M0caorkoz3.eLCtTJq2L09/IuXvX1kySblvVThuyIQK"); // pass = 12345
	}

}
