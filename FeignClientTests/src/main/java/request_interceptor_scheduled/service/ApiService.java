package request_interceptor_scheduled.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import request_interceptor_scheduled.clients.ApiClient;
import request_interceptor_scheduled.clients.ApiClientSecond;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@Service
public class ApiService
{
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss.SSS] ");

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private ApiClientSecond apiClientSecond;

    public ApiService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public String getAccountBalance(String accountId)
    {
        // log.info("Service::getAccountBalance() called");
        final String subAccounts = apiClient.getSubAccounts(accountId);
        final String currencies = apiClientSecond.getCurrencies(accountId);

        // System.out.println("=".repeat(180));
        System.out.println(subAccounts.length());
        System.out.println(currencies.length());
        // System.out.println("=".repeat(180));

        return subAccounts;
    }
    private static String getCurrentTime() {
        return formatter.format(LocalDateTime.now());
    }
}
