/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Experiments_UnitTests.java class
*
* @name    : Experiments_UnitTests.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package mapping.experiments;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Experiments_UnitTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	@ParameterizedTest
	@ArgumentsSource(Params.class)
	public void getParamTest(String url, ResponseEntity<String> expected, boolean checkBody) {
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        if (true == checkBody) {
        	Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
        }
	}
	
	@Test
	public void TEST() {
		String url = "/hello/343434";
		ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>HelloAll</body>",HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
	}

	@Test
	public void getNotExistingPage() {
		String url = "/some_non_existing_path";

		ResponseEntity<String> expected = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        ResponseEntity<String> actual = template.getForEntity(url, String.class);     
        
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(expected.getStatusCode());
	}
	
	
	
	/** Test parameters: **/
	//  1 Parameter: [url]
	//  2 Parameter: [ResponseEntity. Code + Body]
	//  3 Parameter: [checkBody - if we need to check body]
	private final static class Params implements ArgumentsProvider {
	    @Override
	    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
	    	return Stream.of(
	    			 Arguments.of("/hello", new ResponseEntity<String>("<body bgcolor='gray'>Hello</body>", HttpStatus.OK), true),
	    			 Arguments.of("/hello/bla_bla", new ResponseEntity<String>("<body bgcolor='gray'>HelloAll</body>", HttpStatus.OK), true),
	    			 
	    			 Arguments.of("/info",  new ResponseEntity<String>("<body bgcolor='gray'>Hello null</body>", HttpStatus.OK), true),
	    			 Arguments.of("/info?name=Jonh", new ResponseEntity<String>("<body bgcolor='gray'>Hello Jonh</body>", HttpStatus.OK), true),

	    			 Arguments.of("/multiple/one", new ResponseEntity<String>("<body bgcolor='gray'>handleMultiple</body>", HttpStatus.OK), true),
	    			 Arguments.of("/multiple/two", new ResponseEntity<String>("<body bgcolor='gray'>handleMultiple</body>", HttpStatus.OK), true),
	    			 Arguments.of("/multiple/three", new ResponseEntity<String>("<body bgcolor='gray'>handleMultiple</body>", HttpStatus.OK), true),
	    			 Arguments.of("/multiple/four", new ResponseEntity<String>(HttpStatus.NOT_FOUND), false),
	    			 
	    			 Arguments.of("/inspect", new ResponseEntity<String>(HttpStatus.OK), false),
	    			 
	    			 Arguments.of("/custom_error_500", new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR), false),
	    			 Arguments.of("/custom_error_503", new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE), false)
	    		);
	    } 
	}
}