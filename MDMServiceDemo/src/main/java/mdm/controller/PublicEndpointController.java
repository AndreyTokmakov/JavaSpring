package mdm.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import mdm.service.MDMService;
import mdm.responses.HealthStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import org.springframework.beans.factory.annotation.Autowired;


@Log4j2
// @CrossOrigin("http://0.0.0.0:8080")
@RestController
@RequestMapping("/public")
public class PublicEndpointController
{
    @Autowired
    // @Qualifier("RemoteService")
    private MDMService service;

    public PublicEndpointController() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    protected String buildResponse(String name) {
        return "<body bgcolor='gray'>" + name + "</body>";
    }

    @GetMapping("/info")
    public String info(@RequestParam(value = "deviceId", required = false) final String deviceId) {
        log.info("PublicEndpointController::handleInfo(). Params: " + deviceId);
        return buildResponse("Hello " + deviceId);
    }

    /*
    @RequestMapping(method = RequestMethod.GET, value = "put_device_info/{deviceId}")
    public String putDeviceInfo(@PathVariable String deviceId,
                                @RequestParam(value = "info", defaultValue = "None") String info,
                                HttpServletResponse response)
    {
        log.info("PublicEndpointController::putDeviceInfo() called.");
        log.info("info = " + info);
        return buildResponse("Hello for {" + deviceId + "}");
    }
    */

    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HealthStatus getHealth() {
        log.info("PublicEndpointController::getHealth() called");
        return new HealthStatus("OK");
    }

    @RequestMapping(value = "/health_old", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getHealthOld() {
        log.info("PublicEndpointController::getHealth() called");
        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("Health response.");
    }

    // curl -X POST http://127.0.0.0:8080/public/debug -d "key=value"
    @RequestMapping(path = "/debug", method = RequestMethod.POST)
    public ResponseEntity<String>  debugHandler(@RequestBody String body,
                                                final HttpServletRequest request) {
        log.info("* * * * * * * * * PublicEndpointController::debugHandler * * * * * * * * * * ");
        log.info(request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
        log.info("----------------- Headers: ------------------");
        for (Enumeration<String> v = request.getHeaderNames(); v.hasMoreElements();) {
            String name = v.nextElement();
            log.info("   [" + name + " = " + request.getHeader(name) + "]");
        }
        log.info("----------------- Body: ------------------");
        log.info(body);

        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("OK");
    }

    /*
    @GetMapping(value = "/health/state")
    public void setState(@RequestParam(value = "state", required = false, defaultValue = "true") boolean state) {
        log.info("PublicEndpointController::setHealthCheckState(): state = " + state);
    }
    */
}


