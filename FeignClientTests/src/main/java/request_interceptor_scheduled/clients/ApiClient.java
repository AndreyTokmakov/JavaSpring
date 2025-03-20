package request_interceptor_scheduled.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://127.0.0.1:52525",
             name = "SomeExternalServiceApiClient"
             //configuration = GateIOAuthDecoratorConfig.class
)
public interface ApiClient
{
    @GetMapping(value = "deribit/api/v2/private/get_subaccounts", produces = "application/json")
    String getSubAccounts(@RequestParam("accountId") String accountId);
}
