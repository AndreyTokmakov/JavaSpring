/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Config.java class
*
* @name    : Config.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 11, 2021
****************************************************************************/

package qualifier.demo1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public BeanA beanA() {
		return new BeanA();
	}
	
	@Bean
	public BeanA beanA0() {
		return new BeanA("A0");
	}

	@Bean
	@Qualifier
	public BeanA beanA1() {
		return new BeanA("A1");
	}
	
	@Bean
	@Qualifier("A2")
	public BeanA beanA2() {
		return new BeanA("A2");
	}
	
	@Bean
	@Qualifier("A3")
	public BeanA beanA3() {
		return new BeanA("A3");
	}

	@Bean
	@QualifierA4
	public BeanA beanA4() {
		return new BeanA("A4");
	}
}