package request_interceptor_scheduled.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import request_interceptor_scheduled.clients.configuration.ResponseLogger;
// import request_interceptor_scheduled.clients.configuration.ApiClientConfiguration;
// import request_interceptor_scheduled.clients.configuration.ApiClientResponseInterceptor;

@FeignClient(
        // url = "http://127.0.0.1:52525",
        url = "${service.api.url}",
        name = "test-client",
        configuration = ResponseLogger.class
        // configuration = ApiClientResponseInterceptor.class
        // configuration = ApiClientConfiguration.class
)
public interface ApiClient
{
    @GetMapping(value = "deribit/api/v2/private/get_subaccounts",
                produces = "application/json")
    String getSubAccounts(@RequestParam("accountId") String accountId);
}
