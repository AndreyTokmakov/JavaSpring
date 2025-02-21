package rate_limiter.experiments;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Log4j2
@Component
public class EndpointImpl implements IEndpoint
{
    public EndpointImpl() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public void getInfo() {
        System.out.println("EndpointImpl::getInfo() called at" + LocalDateTime.now());
    }
}
