package asynchronous_execution;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler
{
    @Override
    public void handleUncaughtException(final Throwable throwable,
                                        final Method method,
                                        final Object... obj) {
        System.out.println(LocalDateTime.now() + ": Exception message - " + throwable.getMessage());
        for (final Object param : obj) {
            System.out.println("Param - " + param);
        }
    }
}