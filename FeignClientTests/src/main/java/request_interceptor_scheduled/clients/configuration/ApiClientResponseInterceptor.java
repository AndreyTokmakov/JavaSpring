package request_interceptor_scheduled.clients.configuration;

import feign.InvocationContext;
import feign.ResponseInterceptor;

public class ApiClientResponseInterceptor implements ResponseInterceptor
{
    @Override
    public Object intercept(InvocationContext invocationContext, Chain chain) throws Exception {
        return null;
    }
}
