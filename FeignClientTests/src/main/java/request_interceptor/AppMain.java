package request_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients(basePackages = "request_interceptor.client")
// @PropertySource(name = "GateIOParams", value = "application.yml")
public class AppMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class, args);
    }
}


// When calling "public/account_balance"
// will result calling
//   - GateIOAuthDecoratorConfig::requestInterceptor() called per each call
//
// Logs from Py Server:
//  INFO:     127.0.0.1:52100 - "GET /api/v4/auth?accountId=123456789 HTTP/1.1" 200 OK
//  INFO:     127.0.0.1:52100 - "GET /api/v4/wallet/sub_account_futures_balances?accountId=111222222 HTTP/1.1" 200 OK