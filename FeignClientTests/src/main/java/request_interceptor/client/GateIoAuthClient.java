package request_interceptor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import request_interceptor.client.config.GateIoClientConfig;

@FeignClient(
        url = "${service.api.url}",
        name = "GateIoAuthClient",
        configuration = GateIoClientConfig.class
)
public interface GateIoAuthClient {
    @GetMapping(value = "api/v4/auth", produces = "application/json")
    public String authenticate(@RequestParam("accountId") String accountId);
}