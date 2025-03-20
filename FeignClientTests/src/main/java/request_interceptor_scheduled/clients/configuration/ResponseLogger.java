package request_interceptor_scheduled.clients.configuration;


import feign.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class ResponseLogger
{
    @Log4j2
    private final static class SimpleLogger extends Logger
    {
        @Override
        protected void log(String configKey, String format, Object... args)
        {
            //System.err.printf(configKey + " - " + format + "%n", args);
        }

        @Override
        protected Response logAndRebufferResponse(String configKey,
                                                  Level logLevel,
                                                  Response response,
                                                  long elapsedTime) throws IOException
        {
            Response.Body body = response.body();
            if (null != body)
            {
                byte[] bodyData = Util.toByteArray(body.asInputStream());
                response = response.toBuilder().body(bodyData).build();
                Request request = response.request();

                log.info(new String(bodyData));
                log.info("{} {}", request.httpMethod().name(), request.url());
            }
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
    }

    @Bean
    Logger.Level getLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Logger logger() {
        return new SimpleLogger();
    }
}
