package mdm;

import lombok.extern.log4j.Log4j2;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/private")
public class PrivateEndpointController
{
    @Autowired
    // @Qualifier("RemoteService")
    private MDMService service;

    public PrivateEndpointController() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    protected String buildResponse(String name) {
        return "<body bgcolor='gray'>" + name + "</body>";
    }
    @GetMapping("/info")
    public String info(@RequestParam(value = "deviceId", required = false) final String deviceId) {
        log.info("PrivateEndpointController::handleInfo(). Params: " + deviceId);
        return buildResponse("Hello " + deviceId + ", counter: " + service.getCounter());
    }
}


