package rate_limiter.experiments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService
{
    @Autowired
    private IEndpoint endpoint;

    private void Sleep(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void runTest()
    {
        for (int i = 0; i < 100; ++i) {
            endpoint.getInfo();
            Sleep(10);
        }
    }
}
