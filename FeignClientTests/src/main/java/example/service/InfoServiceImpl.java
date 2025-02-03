package example.service;

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

    public String getAccount()
    {
        log.info("InfoServiceImpl::getAccount()");
        final String extInfo = extClient.getAccount(1L);
        return "000_100_500";
    }
}
