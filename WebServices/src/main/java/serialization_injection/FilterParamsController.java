package serialization_injection;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/filters")
public class FilterParamsController
{
    @Autowired
    private FilterHandlerService filterService;

    public FilterParamsController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World!!!") String name)
    {
        // http://localhost:8080/filters/hello?name=2323
        log.info("FilterParamsController::hello(name = {})", name);
        return String.format("Hello %s!", name);
    }

    /** How to call with curl
     *  curl -i \
     *   -H "Accept: application/json" -H "Content-Type:application/json" \
     *   -X POST --data '{"name": "johnny"}' "http://localhost:8080/filters/favorites"
     */
    @PostMapping("/favorites")
    public String handleFavorites(@RequestBody FavoriteSymbolsRes request)
    {
        log.info(request);
        filterService.handleFavorites(request);
        return "OK";
    }
}
