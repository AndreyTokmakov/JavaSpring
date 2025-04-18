package email_templates_maker.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(path = "/public")
public class PublicController
{
    public PublicController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

}
