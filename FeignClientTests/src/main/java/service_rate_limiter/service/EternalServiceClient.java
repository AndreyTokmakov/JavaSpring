package service_rate_limiter.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@FeignClient(name = "EternalInformationServiceWithRateLimiter",
             url="0.0.0.0:52525/v2/account",
             path = "protected"
)
public interface EternalServiceClient
{
    // will invoke: "GET http://0.0.0.0:52525/v2/account/protected/get_account/1 HTTP/1.1
    @GetMapping(value = "/get_account/{accountId}", produces = "application/json")
    String getAccountPath(@PathVariable("accountId") Long accountId);

    // will invoke: "GET http://0.0.0.0:52525/v2/account/protected/get_account?1 HTTP/1.1
    @RateLimiter(name = "extServiceClient")
    @GetMapping(value = "/get_account", produces = "application/json")
    String getAccount(@RequestParam("accountId") Long accountId);
}