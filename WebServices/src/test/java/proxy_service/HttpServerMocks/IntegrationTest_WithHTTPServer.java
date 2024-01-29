/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* IntegrationTest_WithHTTPServer.java class
*
* @name    : IntegrationTest_WithHTTPServer.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 31, 2021
****************************************************************************/

package proxy_service.HttpServerMocks;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.client.ClientProtocolException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import lombok.extern.log4j.Log4j2;

@Log4j2
class StubServer {
	/** Server instance: **/
	private HttpServer server = null;
	
	public StubServer(final String host, int port) throws IOException {
		server = HttpServer.create(new InetSocketAddress(host, port), 0);
	}
	
	public void start() {
		server.start();
	}
	
	public void stop() {
		server.stop(0);
	}
	
	public void addHandler(String context) {
		server.createContext("/", new Handler());
	}

	public void addHandler(String path, String response) {
		server.createContext(path, new Handler(response));
	}
	
	public void replaceHandler(String path, String response) {
		server.removeContext(path);
		server.createContext(path, new Handler(response));
	}
	
	public void removeContext(String path) {
		server.removeContext(path);
	}
}

/** HTTP request handler class: **/
@Log4j2
class Handler implements HttpHandler {
	/** Stud HTTP response: **/
	private String httpResponse = 
			"<html><center><h1>Welcome to test server!</h1></center></html>";
	
	/** Date time formatter: **/
	private final static DateTimeFormatter DATE_FORMATTER = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	// Default Handler class constructor.
	// Returns the default HTML welcome page
	public Handler() {
	}
	
	public Handler(String response) {
		httpResponse = response;
	}
	
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		URI requestURI = httpExchange.getRequestURI();
		
		log.info("proxy_service.HttpServerMocks.Handler::handle() -> [".
				concat(DATE_FORMATTER.format(LocalDateTime.now())).concat("] ").concat(requestURI.toString()));

		httpExchange.sendResponseHeaders(200, httpResponse.getBytes().length);
		OutputStream os = httpExchange.getResponseBody();
		os.write(httpResponse.getBytes());
		os.close();
	}
}


@Log4j2
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest_WithHTTPServer {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate template;
	
	/** **/
	private final static String mockServiceHost = "127.0.0.1";
	/** **/
	private final static int mockServicePort = 52525;
	
	private static StubServer server;
	
	@BeforeAll
	public static void beforeAll() throws IOException {
		log.info("Staring stub server...");
		server = new StubServer(mockServiceHost, mockServicePort);
		server.start();
		log.info(String.format("Started at %s:%d", mockServiceHost, mockServicePort));
	}
	
	@AfterAll
	public static void afterAll() throws IOException {
		//log.info("***AFTER ALL****");
		server.stop();
		log.info("Stub server stopped.");
	}
	
	@Test
	// @Disabled
	public void simpleTest() throws ClientProtocolException, IOException, InterruptedException {
		server.addHandler("/some_external_web_service", "OKKKK");
		
		String url = "/proxy/test";
		ResponseEntity<String> expected = new ResponseEntity<String>("OKKKK",HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
	}
	
	@Test
	// @Disabled
	public void replaceContext() throws ClientProtocolException, IOException, InterruptedException {
		server.replaceHandler("/some_external_web_service", "12345");
		
		String url = "/proxy/test";
		ResponseEntity<String> expected = new ResponseEntity<String>("12345",HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
	}
	
	@Test
	// @Disabled
	public void extContextTest() throws ClientProtocolException, IOException, InterruptedException {
		final String desiredRespone = RandomStringUtils.randomAlphanumeric(32);
		server.addHandler("/some_path", desiredRespone);
		
		String url = "/proxy/ext/some_path";
		ResponseEntity<String> expected = new ResponseEntity<String>(desiredRespone, HttpStatus.OK);
		ResponseEntity<String> response = template.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
	}	
}
