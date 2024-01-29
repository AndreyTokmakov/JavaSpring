/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* SomponentsScanControllerTests.java class
*
* @name    : SomponentsScanControllerTests.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

package mapping.comonent_scan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComponentsScanControllerTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	@ParameterizedTest
	@ArgumentsSource(Params.class)
	public void getHello(String url, String responseExpected) {
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        assertThat(response.getBody()).isEqualTo(responseExpected);
	}
	
	/** Test params: **/
	private final static class Params implements ArgumentsProvider {
	    @Override
	    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
	    	return Stream.of(Arguments.of("/info", "<body bgcolor='gray'>Info page</body>"),
					 Arguments.of("/info/ids?id=12345", "<body bgcolor='gray'>Info {12345}</body>"),
					 Arguments.of("/messages", "<body bgcolor='gray'>Messages page</body>"),
					 Arguments.of("/messages/ids?id=12345", "<body bgcolor='gray'>Message {12345}</body>"),
					 Arguments.of("/info/dates?start=2000-10-31&end=2000-10-31", "<body bgcolor='gray'>Info [2000-10-31 - 2000-10-31]</body>")
	    		);
	    }
	}
}
