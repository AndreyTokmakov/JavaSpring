/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* HelloControllerTest.java class
*
* @name    : HelloControllerTest.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 27, 2020
****************************************************************************/

package simple_web_app;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
}

/*
 * MockMvc comes from Spring Test and lets you, through a set of convenient builder classes, 
 * send HTTP requests into the DispatcherServlet and make assertions about the result.
 * Note the use of @AutoConfigureMockMvc and @SpringBootTest to inject a MockMvc instance.
 * Having used @SpringBootTest, we are asking for the whole application context to be created.
 * An alternative would be to ask Spring Boot to create only the web layers of the context by using @WebMvcTest.
 * In either case, Spring Boot automatically tries to locate the main application class of your application, 
 * but you can override it or narrow it down if you want to build something different.
 */