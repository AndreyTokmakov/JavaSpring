/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* GreetingBean.java class
*
* @name    : GreetingBean.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package bean.demo1;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component("greetingBean")
public class GreetingBean {
	
	public GreetingBean() {
		log.info(this.getClass().getSimpleName() + " created!");
	}

    public void sayHello() {
        System.out.println("Hello!");
    }
}
