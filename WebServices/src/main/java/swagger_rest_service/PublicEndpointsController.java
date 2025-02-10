package swagger_rest_service;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/info1")
    public String info1(@RequestParam(required = false) final String name)
    {
        log.info("info1() called. Params: {}", name);
        return "{\"result\": \"OK\"}";
    }

    @GetMapping("/info2")
    public String info2(@RequestParam Optional<String> name) {
        log.info("info2() called. Params: {}", name.orElseGet(() -> "not provided"));
        return "{\"result\": \"OK\"}";
    }

    @GetMapping("/info3")
    public String info3(@RequestParam final Map<String,String> allParams) {
        log.info("info3() called. Params: {}", allParams.entrySet());
        return "{\"result\": \"OK\"}";
    }

    @GetMapping("/info4")
    public String info4(@RequestParam(value = "name", required = false, defaultValue = "Jon Dow") final String name,
                        @RequestParam(value = "id",   required = false, defaultValue = "-1") final int id) {
        log.info("info4() called. name: {}, id: {}", name, id);
        return "{\"result\": \"OK\"}";
    }
}
