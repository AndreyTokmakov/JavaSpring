package value.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Log4j2
@Component
public class RestController
{
    @Value("${notification.email.from}")
    private String from;

    // @Value("${notification.email.to}")
    @Value("#{'${notification.email.to}'.split(',')}")
    private Set<String> to;

    // @Value("${notification.email.to_list}")
    private String to_list;

    public RestController()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @PostConstruct
    public void afterInitialize()
    {
        System.out.println(from);
        System.out.println(to);
    }
}
