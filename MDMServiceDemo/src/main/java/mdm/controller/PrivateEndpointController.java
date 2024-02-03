package mdm.controller;

import lombok.extern.log4j.Log4j2;

import mdm.service.MDMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/private")
public class PrivateEndpointController
{
    @Autowired
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
        return buildResponse("Hello " + deviceId);
    }
}


