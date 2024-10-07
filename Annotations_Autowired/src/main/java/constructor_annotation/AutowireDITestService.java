/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* AutowireDITestService.java class
*
* @name    : AutowireDITestService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 14, 2020
****************************************************************************/

package constructor_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowireDITestService
{
	private final ISampleService sampleService;
  
	@Autowired
	public AutowireDITestService(ISampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	public void test() {
		this.sampleService.sample();
	}
}