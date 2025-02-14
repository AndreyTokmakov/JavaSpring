package rate_limiter;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestService
{
    private void Sleep(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @RateLimiter(name = "rateLimiterApi")
    public void callSomeEndpoint()
    {
        System.out.println("TestService::callSomeEndpoint() called at" + LocalDateTime.now());
    }

    public void runTest()
    {
        for (int i = 0; i < 100; ++i) {
            callSomeEndpoint();
            Sleep(10);
        }
    }
}
