package request_interceptor_scheduled.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import request_interceptor_scheduled.clients.ApiClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@org.springframework.stereotype.Service
public class Service
{
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss.SSS] ");

    @Autowired
    private ApiClient apiClient;

    public Service() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public String getAccountBalance(String accountId)
    {
        log.info("Service::getAccountBalance() called");
        final String response = apiClient.getSubAccounts(accountId);
        return response;
    }
    private static String getCurrentTime() {
        return formatter.format(LocalDateTime.now());
    }
}
