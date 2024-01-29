/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* SecurityConfiguration.java class
*
* @name    : SecurityConfiguration.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Feb 22, 2021
****************************************************************************/

package authorization_service.service2;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log4j2
@Configuration
@EnableConfigurationProperties
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;
	
	public SecurityConfiguration() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		    .disable()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
	        .and()
	        .sessionManagement()
	        .disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("SecurityConfiguration::passwordEncoder()");
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		log.info("SecurityConfiguration::configure()");
		builder.userDetailsService(userService);
	}
}
