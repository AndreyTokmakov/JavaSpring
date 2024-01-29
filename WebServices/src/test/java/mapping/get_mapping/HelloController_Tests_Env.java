/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* HelloController_Tests_2.java class
*
* @name    : HelloController_Tests_2.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

package mapping.get_mapping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

class MyTestParams implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
    	return Stream.of(Arguments.of("/hello", "<body bgcolor='gray'>Hello</body>"),
						 Arguments.of("/info?name=SomeName", "Hello, SomeName"),
						 Arguments.of("/info", "Hello, Anonymous"),
    					 Arguments.of("/info1", "<body bgcolor='gray'>handleInfoWithParam1</body>"),
    					 Arguments.of("/info2?name=SomeName123", "<body bgcolor='gray'>Hello for SomeName123</body>"),
    					 Arguments.of("/info2", "<body bgcolor='gray'>Hello for not provided</body>"),	
    					 Arguments.of("/info3?name=SomeName123", "<body bgcolor='gray'>Hello for SomeName123</body>"),
    					 Arguments.of("/info3", "<body bgcolor='gray'>Hello for Jonh Dow</body>"),	
    					 Arguments.of("/info4?param1=value1&param2=value2&param3=value3", "<body bgcolor='gray'>Params: [param1=value1, param2=value2, param3=value3]</body>"),
    					 
    					 Arguments.of("/messages/123", "<body bgcolor='gray'>Message id: 123</body>"),
    					 //Arguments.of("/messages_ex/123", "<body bgcolor='gray'>Message id: 123</body>"),
    					 
    					 Arguments.of("/param_list?names=1,2,3,4,5", "<body bgcolor='gray'>Names: [1, 2, 3, 4, 5]</body>"),
    					 
    					 Arguments.of("/two_params", "<body bgcolor='gray'>Hello for Jonh Dow with id = -1</body>"),
    					 Arguments.of("/two_params?name=McClane", "<body bgcolor='gray'>Hello for McClane with id = -1</body>"),
    					 Arguments.of("/two_params?name=McClane&id=123", "<body bgcolor='gray'>Hello for McClane with id = 123</body>")
        );
    }
}

//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloController_Tests_Env {

	@LocalServerPort
	private int port;

	//private URL base;

	@Autowired
	private TestRestTemplate template;

	/*
    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }
    */

	@ParameterizedTest
	@ArgumentsSource(MyTestParams.class)
	public void getHello(String url, String responseExpected) {
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        assertThat(response.getBody()).isEqualTo(responseExpected);
	}
}