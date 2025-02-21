package rate_limiter.rest_service.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rate_limiter.rest_service.service.IService;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@org.springframework.web.bind.annotation.RestController
@RequestMapping("public")
public class RestController
{
    @Autowired
    private IService service;

    public RestController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/get_info")
    public ResponseEntity<String> getInfo(final HttpServletRequest request)
    {
        final String response = service.getInfo();
        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body(response);
    }
}
