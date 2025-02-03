package example.service;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

class OneLineLogger extends Logger
{
    @Override
    protected void log(String configKey, String format, Object... args)
    {
        System.err.printf("CUSTOM LOG: " + configKey + " - " + format + "%n", args);
    }
}

@Configuration
class FeignClientConfig
{
    // Set the logging level
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Adjust this based on your requirement
    }

    // Register the custom logger
    @Bean
    public Logger logger() {
        return new OneLineLogger(); // Your custom logger
    }
}


@FeignClient(name = "EternalInformationService",
             url="0.0.0.0:52525/v2/account",
             path = "protected",
             configuration = FeignClientConfig.class
)
public interface EternalServiceClient
{
    // will invoke: "GET http://0.0.0.0:52525/v2/account/protected/get_account/1 HTTP/1.1
    @GetMapping(value = "/get_account/{accountId}", produces = "application/json")
    public String getAccountPath(@PathVariable("accountId") Long accountId);

    // will invoke: "GET http://0.0.0.0:52525/v2/account/protected/get_account?1 HTTP/1.1
    @GetMapping(value = "/get_account", produces = "application/json")
    public String getAccount(@RequestParam("accountId") Long accountId);
}