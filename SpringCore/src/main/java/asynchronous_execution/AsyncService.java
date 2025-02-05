package asynchronous_execution;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class AsyncService
{
    @Autowired
    private AsyncServiceOne firstService;

    @Autowired
    private AsyncServiceTwo secondService;

    public CompletableFuture<String> asyncMergeServicesResponse() throws InterruptedException
    {
        System.out.println(LocalDateTime.now() + ": AsyncService::asyncMergeServicesResponse() - before firstService.asyncGetData()");
        CompletableFuture<String> firstServiceResponse = firstService.asyncGetData();

        System.out.println(LocalDateTime.now() + ": AsyncService::asyncMergeServicesResponse() - before secondService.asyncGetData()");
        CompletableFuture<String> secondServiceResponse = secondService.asyncGetData();

        // Merge responses from FirstAsyncService and SecondAsyncService
        return firstServiceResponse.thenCompose(firstValue -> secondServiceResponse
                .thenApply(secondServiceValue -> firstValue + secondServiceValue));
    }
}
