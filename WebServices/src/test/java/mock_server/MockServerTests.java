/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Experiments_UnitTests.java class
*
* @name    : Experiments_UnitTests.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package mock_server;

import java.util.Map;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockServerTests {
	private final static Gson gson = new Gson();
	
	private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;
	
    public boolean addStub(final Map<String, Object> jsonParams) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(jsonParams)))
                .uri(URI.create("http://localhost:" + port + "/mapping"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

        return response.statusCode() == 200 ? true : false;
    }
	

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
	@Disabled("for demonstration purposes") 
	public void testPost() {
        ResponseEntity<String> response = template.postForEntity("/mapping", String.class, null);
        
        ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>Hello</body>", HttpStatus.OK);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
	}
	
	@Test
	@Disabled("for demonstration purposes") 
	public void testPost1() {
    	Map<String, String> map = new HashMap<String, String> ();
    	map.put("profile", "Developer");
    	map.put("tech", "Java");
        
    	//HttpEntity<String> requestEntity = new HttpEntity<String>(objEmp, headers);
    	
    	ResponseEntity<String> response = template.postForEntity("/mapping", String.class, null, map);
    	
        ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>Hello</body>", HttpStatus.OK);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
	}
	
	@Test
	public void Test1() {
    	Map<String, Object> json = new HashMap<>();
        json.put("request", Map.ofEntries(
        	Map.entry("method", "GET"),
        	Map.entry("url", "/red")
        ));
        
        json.put("response", Map.ofEntries(
    		Map.entry("body", "<body bgcolor='white'>Yep</body>")
        ));
        
        ResponseEntity<String> response = template.getForEntity("/red", String.class);
        Assertions.assertThat(response.getBody()).isEqualTo("<body bgcolor='gray'>Your page ain't here, kid (^_^)</body>");
        
        addStub(json);
        
        response = template.getForEntity("/red", String.class);
        Assertions.assertThat(response.getBody()).isEqualTo("<body bgcolor='white'>Yep</body>");
	}
	
	/** Test parameters: **/
	//  1 Parameter: [url]
	//  2 Parameter: [ResponseEntity. Code + Body]
	//  3 Parameter: [checkBody - if we need to check body]
	private final static class Params implements ArgumentsProvider {
	    @Override
	    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
	    	return Stream.of(
	    		Arguments.of("/", new ResponseEntity<String>("<body bgcolor='gray'>Hello</body>", HttpStatus.NOT_FOUND), false)
	    	);
	    } 
	}
}