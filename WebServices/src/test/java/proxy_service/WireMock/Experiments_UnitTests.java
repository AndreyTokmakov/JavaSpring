/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Experiments_UnitTests.java class
*
* @name    : Experiments_UnitTests.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package proxy_service.WireMock;

import java.io.IOException;

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
public class Experiments_UnitTests {
	// @LocalServerPort
	// private int port;

	@Autowired
	private TestRestTemplate template;
	
	/** **/
	private final static String mockServiceHost = "127.0.0.1";
	
	/** **/
	private final static int mockServicePort = 52525;
	
	/** **/
	private static WireMockServer wireMockServer = null; 
	
	private static StubMapping stubMapping = null;
	
    @BeforeAll
    static void setUp() {
    	Options options = new WireMockConfiguration().port(mockServicePort).bindAddress(mockServiceHost);
		wireMockServer = new WireMockServer(options);
		wireMockServer.start();
		
		WireMock.configureFor(mockServiceHost, mockServicePort);
		
		stubMapping = WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/context"))
				              .willReturn(WireMock.aResponse().withHeader("Content-Type", "text/plain")
	                					   					  .withStatus(200)
	                					   					  .withBody("<html><body bgcolor='gray'>Hello! Okkkkkkkkkkk</body></html>")));
		stubMapping = WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/some_external_web_service"))
	              .willReturn(WireMock.aResponse().withHeader("Content-Type", "text/plain")
    					   					  .withStatus(200)
    					   					  .withBody("<html><body bgcolor='gray'>SOME_EXTERNAL_WEB_SERVICE_NEW</body></html>")));
    }
    
    @AfterAll
    static void tearDown() {
    	/** Stop WireMock service. **/
    	wireMockServer.stop();
    }
	
	@Test
	public void test1() throws ClientProtocolException, IOException, InterruptedException {
		String url = "/internal/state";
		ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>HelloAll</body>",HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        // Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
	}
	
	@Test
	// @Disabled
	public void test2() throws ClientProtocolException, IOException, InterruptedException {
		String url = "/proxy/test";
		ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>HelloAll</body>",HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        // Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
	}
	
	@Test
	@Disabled
	public void wireMockTest() throws ClientProtocolException, IOException, InterruptedException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet request = new HttpGet(new String("http://").concat(mockServiceHost).concat(":").concat(String.valueOf(mockServicePort)).concat("/context"));
		HttpResponse httpResponse = httpClient.execute(request);

		// Using AssertJ
		Assertions.assertThat(httpResponse.getStatusLine().getStatusCode()).as("200 OK expeced here").isEqualTo(200);
	}
}