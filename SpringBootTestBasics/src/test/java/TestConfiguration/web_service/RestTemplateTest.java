/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* RestTemplateTest.java class
*
* @name    : RestTemplateTest.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 29, 2021
****************************************************************************/

package TestConfiguration.web_service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfig.class)
public class RestTemplateTest {
	@LocalServerPort
	private int port;

    @Autowired
    private TestRestTemplate service;

    @Test
    public void Test1()
    {
		String url = "/resource";
		ResponseEntity<String> expected = new ResponseEntity<String>("<body bgcolor='gray'>REMOTE_RESOURCE</body>", HttpStatus.OK);
		ResponseEntity<String> response = service.getForEntity(url, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(expected.getStatusCode());
        Assertions.assertThat(response.getBody()).isEqualTo(expected.getBody());
    }
}