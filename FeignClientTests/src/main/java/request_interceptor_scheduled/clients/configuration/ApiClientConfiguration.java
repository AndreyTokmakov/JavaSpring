package request_interceptor_scheduled.clients.configuration;

import feign.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/*
@Configuration
public class ApiClientConfiguration extends SpringDecoder
{

    public ApiClientConfiguration(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }

    @Override
    public Object decode(final Response response, Type type) throws IOException, FeignException
    {
        try (final Reader reader = response.body().asReader(StandardCharsets.UTF_8)) {
            String body = Util.toString(reader);
            System.out.println(body);
        }

        return "44444";
    }

    @Bean
    public RequestInterceptor requestInterceptor()
    {
        return requestTemplate -> {
            System.out.println("ApiClientConfiguration-RequestInterceptor() called");
            // requestTemplate.header("Authorization", "Bearer " + authToken);
        };
    }
}*/
