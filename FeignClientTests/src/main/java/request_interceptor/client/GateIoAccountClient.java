package request_interceptor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import request_interceptor.client.config.GateIOAuthDecoratorConfig;

@FeignClient(
        url = "${service.api.url}",
        name = "GateIoAccountClient",
        configuration = GateIOAuthDecoratorConfig.class
)
public interface GateIoAccountClient {
    @GetMapping(value = "api/v4/wallet/sub_account_futures_balances", produces = "application/json")
    public String getAccountBalance(@RequestParam("accountId") String accountId);
}
