/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* WireMockTests.java class
*
* @name    : WireMockTests.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 29, 2021
****************************************************************************/

package experimental_service.WireMock.simple_tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringWireMockTests {
	/** **/
	private final static String mockServiceHost = "127.0.0.1";
	
	/** **/
	private final static int mockServicePort = 52525;
	
	/** **/
	private static WireMockServer wireMockServer = null; 
	
	private static StubMapping stubMapping = null;
	
	@Autowired
	private TestRestTemplate template;
	
    @BeforeAll
    static void setup(){
    	Options options = new WireMockConfiguration().port(mockServicePort).bindAddress(mockServiceHost);
		wireMockServer = new WireMockServer(options);
		wireMockServer.start();
		
		WireMock.configureFor(mockServiceHost, mockServicePort);
		stubMapping = WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/proxy/context"))
				              .willReturn(WireMock.aResponse().withHeader("Content-Type", "text/plain")
	                					   					  .withStatus(200)
	                					   					  .withBody("<html><body bgcolor='gray'>Hello!</body></html>")));
		stubMapping = WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/proxy/context"))
	              .willReturn(WireMock.aResponse().withHeader("Content-Type", "text/plain")
      					   					  .withStatus(200)
      					   					  .withBody("<html><body bgcolor='gray'>Hello!</body></html>")));
    }
    
    @AfterAll
    static void tear(){
    	wireMockServer.stop();
    }
    
	@Test
	public void test1() throws ClientProtocolException, IOException, InterruptedException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet request = new HttpGet(new String("http://").concat(mockServiceHost).concat(":").concat(String.valueOf(mockServicePort)).concat("/context"));
		HttpResponse httpResponse = httpClient.execute(request);

		System.out.println(httpResponse);
		
		// Using AssertJ
		Assertions.assertThat(httpResponse.getStatusLine().getStatusCode()).as("200 OK expeced here").isEqualTo(200);
		
		// TimeUnit.SECONDS.sleep(30);
	}
	
	@Test
	public void test2() throws ClientProtocolException, IOException, InterruptedException {
		
		String url = "/internal/state";
		ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>HelloAll</body>",HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        // Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
  
        // TimeUnit.SECONDS.sleep(10);
	}
}
