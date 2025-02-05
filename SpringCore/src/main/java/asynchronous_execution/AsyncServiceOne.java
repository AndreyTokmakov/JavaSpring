package asynchronous_execution;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceOne
{
    @Async
    public CompletableFuture<String> asyncGetData() throws InterruptedException
    {
        System.out.println(LocalDateTime.now() + ": AsyncServiceOne::asyncGetData() called");
        Thread.sleep(4000);

        System.out.println(LocalDateTime.now() + ": AsyncServiceOne::asyncGetData() done");
        return new AsyncResult<>(super.getClass().getSimpleName() + " response !!! ").completable();
    }
}