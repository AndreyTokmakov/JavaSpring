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
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

public class WireMockTests {
	/** **/
	private final static String host = "127.0.0.1";
	/** **/
	private final static int port = 52525;
	/** **/
	private static WireMockServer wireMockServer = null; 
	
	private static StubMapping stubMapping = null;
	
    @BeforeAll
    static void setup(){
    	Options options = new WireMockConfiguration().port(port).bindAddress(host);
		wireMockServer = new WireMockServer(options);
		wireMockServer.start();
		
		WireMock.configureFor(host, port);
		stubMapping = WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/context"))
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
		
		HttpGet request = new HttpGet(new String("http://").concat(host).concat(":").concat(String.valueOf(port)).concat("/context"));
		HttpResponse httpResponse = httpClient.execute(request);

		// Using AssertJ
		Assertions.assertThat(httpResponse.getStatusLine().getStatusCode()).as("200 OK expeced here").isEqualTo(200);
		
		TimeUnit.SECONDS.sleep(10);
	}
}
