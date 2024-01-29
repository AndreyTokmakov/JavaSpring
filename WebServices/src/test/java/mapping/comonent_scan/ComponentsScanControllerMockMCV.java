/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* SomponentsScanController_MockMcv.java class
*
* @name    : SomponentsScanController_MockMcv.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

package mapping.comonent_scan;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
// @WebMvcTest(MessagesContoller.class)
public class ComponentsScanControllerMockMCV {
	
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

	@Autowired
	private MockMvc mcvMock;
	
	@ParameterizedTest
	@ArgumentsSource(Params.class)
	public void getHello(String url, String responseExpected) throws Exception {
		mcvMock.perform(MockMvcRequestBuilders
		       .get(url)
		       .accept(MediaType.APPLICATION_JSON))
		       .andExpect(status().isOk())
		       .andExpect(content().string(equalTo(responseExpected)));
	}
	
	@Test
	public void testNonExistingContext() throws Exception {
		String url = "/non_existing";

		mcvMock.perform(MockMvcRequestBuilders
			       .get(url)
			       .accept(MediaType.ALL))
			       .andExpect(status().isNotFound());
	}
	
	@Test
	public void testError_503() throws Exception {
		String url = "/custom_error_503";

		mcvMock.perform(MockMvcRequestBuilders
			       .get(url)
			       .accept(MediaType.ALL))
			       .andExpect(status().is(503));
	}
}
