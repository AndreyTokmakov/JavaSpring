package request_interceptor.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import request_interceptor.client.GateIoAuthClient;

@Log4j2
@Service
public class AuthService
{
    @Autowired
    private GateIoAuthClient authClient;

    public AuthService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public String authenticate()
    {
        final String extInfo = authClient.authenticate("123456789");
        return extInfo;
    }
}
