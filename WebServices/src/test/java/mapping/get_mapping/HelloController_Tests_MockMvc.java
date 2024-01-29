/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* HelloTest1.java class
*
* @name    : HelloTest1.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

package mapping.get_mapping;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloController_Tests_MockMvc {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHello() throws Exception {
		String url = "/hello";
		String responseExpected = "<body bgcolor='gray'>Hello</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));	
	}
	
	@Test
	public void testInfoContext_WithName() throws Exception {
		String url = "/info?name=SomeName";
		String responseExpected = "Hello, SomeName";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));	
	}
	
	@Test
	public void testInfoContext_NoName() throws Exception {
		String url = "/info";
		String responseExpected = "Hello, Anonymous";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));		
	}
	
	@Test
	public void testInfo1Context_WithParam() throws Exception {
		String url = "/info1";
		String responseExpected = "<body bgcolor='gray'>handleInfoWithParam1</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo(responseExpected)));		
	}
	
	@Test
	public void testInfo2Context_WithParam() throws Exception {
		String url = "/info2?name=SomeName123";
		String responseExpected = "<body bgcolor='gray'>Hello for SomeName123</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}
	
	@Test
	public void testInfo2Context_NoName() throws Exception {
		String url = "/info2";
		String responseExpected = "<body bgcolor='gray'>Hello for not provided</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}
	
	@Test
	public void testInfo3Context_WithParam() throws Exception {
		String url = "/info3?name=SomeName123";
		String responseExpected = "<body bgcolor='gray'>Hello for SomeName123</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}
	
	@Test
	public void testInfo32Context_NoName() throws Exception {
		String url = "/info3";
		String responseExpected = "<body bgcolor='gray'>Hello for Jonh Dow</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}	
	
	@Test
	public void testInfo4Context_WithParam() throws Exception {
		String url = "/info4?param1=value1&param2=value2&param3=value3";
		String responseExpected = "<body bgcolor='gray'>Params: [param1=value1, param2=value2, param3=value3]</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}
	
	@Test
	public void testMessages_WithID() throws Exception {
		String url = "/messages/123";
		String responseExpected = "<body bgcolor='gray'>Message id: 123</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}
	
	@Test
	public void testInputParamList() throws Exception {
		String url = "/param_list?names=1,2,3,4,5";
		String responseExpected = "<body bgcolor='gray'>Names: [1, 2, 3, 4, 5]</body>";
		
		mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(responseExpected)));
	}
	

}
