package sprint_clound_config_service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/public")
public class PublicController
{
    @Autowired
    private TestService testService;

    public PublicController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/v1")
    public String test1() {
        System.out.println("PublicController::test1()");
        return testService.getValueWithDelay();
    }

    @GetMapping("/v2")
    public String test2()  {
        System.out.println("PublicController::test2()");
        return testService.getValue();
    }
}
