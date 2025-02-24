package simple_example;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// The embedded server starts on a random port because of webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
// and the actual port is discovered at runtime with @LocalServerPort.

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleExampleTest
{

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
    public void getHelloOK() throws Exception
    {
        final String messageExpected = "Test message from Controller::index() method";
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        assertThat(response.getBody()).isEqualTo(messageExpected);
    }

    @Test
    public void getHello_ShallFail() throws Exception
    {
        final String messageExpected = "Test message from Controller::index() method BADDDD";
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        assertThat(response.getBody()).isEqualTo(messageExpected);
    }
}