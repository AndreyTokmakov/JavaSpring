package service_rate_limiter.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class InfoServiceImpl
{
    @Autowired
    private EternalServiceClient extClient;

    public InfoServiceImpl() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public String getAccount(int accountId)
    {
        final String result = extClient.getAccount((long) accountId);
        // log.info("InfoServiceImpl::getAccount(): " + result);
        return result;
    }
}
