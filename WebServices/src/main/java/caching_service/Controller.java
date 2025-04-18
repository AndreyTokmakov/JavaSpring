package caching_service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class Controller
{
    // @Autowired
    private final InfoCachableService infoCachableService;

    @Autowired
    public Controller(InfoCachableService infoCachableService) {
        this.infoCachableService = infoCachableService;
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/info")
    public String handleHello()
    {
        String response = infoCachableService.getInfo();
        log.info("ServiceController::handleHello() called | " + response);

        return response;
    }
}
