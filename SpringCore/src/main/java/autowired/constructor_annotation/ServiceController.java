package autowired.constructor_annotation;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ServiceController
{
    private final IService sampleService;

    @Autowired
    public ServiceController(IService service)
    {
        log.info("{} created!", this.getClass().getSimpleName());
        this.sampleService = service;
    }

    public void test() {
        this.sampleService.sample();
    }
}