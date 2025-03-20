package request_interceptor_scheduled.clients.configuration;


import feign.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import java.io.IOException;


public class ResponseLogger
{
    @Log4j2
    private final static class DeribitResponseLogger extends Logger
    {
        @Override
        protected void log(String configKey, String format, Object... args)  {
        }

        @Override
        protected Response logAndRebufferResponse(String configKey,
                                                  Level logLevel,
                                                  Response response,
                                                  long elapsedTime) throws IOException
        {
            final Response.Body body = response.body();
            if (null != body)
            {
                byte[] bodyData = Util.toByteArray(body.asInputStream());
                response = response.toBuilder().body(bodyData).build();
                log.info(new String(bodyData));
                log.info("{} {}", response.request().httpMethod().name(), response.request().url());
            }
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
    }

    @Bean
    public Logger logger() {
        return new DeribitResponseLogger();
    }
}
