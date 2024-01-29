/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* HelloControllerIT.java class
*
* @name    : HelloControllerIT.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 27, 2020
****************************************************************************/

package simple_web_app;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

// The embedded server starts on a random port because of webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
// and the actual port is discovered at runtime with @LocalServerPort.

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }
}