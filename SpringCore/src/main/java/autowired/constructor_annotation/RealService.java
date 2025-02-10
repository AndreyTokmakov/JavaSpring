package autowired.constructor_annotation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RealService implements IService
{
    public RealService()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public void sample()
    {
        log.info("RealService::sample() called");
    }
}
