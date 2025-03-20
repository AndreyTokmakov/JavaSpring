
package resource;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import resource.services.IService;
import javax.annotation.Resource;

@Log4j2
@RestController
public final class Controller
{
    @Resource(name="${application_params.service_type}")
    private IService service;

    public Controller()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/call_service")
    public ResponseEntity<String> callService()
    {
        final String info = service.getInfo();
        log.info("checkResource() called for {}", info);
        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("<body bgcolor='gray'>" + info + "</body>");
    }
}

