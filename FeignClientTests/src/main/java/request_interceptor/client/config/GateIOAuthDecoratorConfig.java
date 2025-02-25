package request_interceptor.client.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import request_interceptor.service.AuthService;

public class GateIOAuthDecoratorConfig
{
    @Autowired
    private AuthService authService;

    @Bean
    RequestInterceptor requestInterceptor()
    {
        return requestTemplate -> {
            System.out.println("GateIOAuthDecoratorConfig-RequestInterceptor() called");
            final String authToken = authService.authenticate();
            requestTemplate.header("Authorization", "Bearer " + authToken);
        };
    }
}
