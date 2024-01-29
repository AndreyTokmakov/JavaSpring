/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* UserDetailsService.java class
*
* @name    : UserDetailsService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Feb 22, 2021
****************************************************************************/

package authorization_service.service2;

import authorization_service.enities.Users;
import authorization_service.enities.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Component
public class UserService implements UserDetailsService {
	@Autowired
	private UsersRepository repository;
	
	public UserService() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername() called");
		
		Users user = repository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}
