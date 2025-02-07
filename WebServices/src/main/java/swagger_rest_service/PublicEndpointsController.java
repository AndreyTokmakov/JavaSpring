package swagger_rest_service;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import static swagger_rest_service.SpringFoxConfig.INFO_TAG;


@Log4j2
@RestController
@RequestMapping("public")
@Api(tags = { INFO_TAG })
public class PublicEndpointsController
{
    public PublicEndpointsController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/info")
    public @ResponseBody String info()
    {
        log.info("PublicEndpointsController::info()");
        return "{\"result\": \"OK\"}";
    }
}
