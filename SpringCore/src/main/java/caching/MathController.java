package caching;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/math")
public class MathController
{
    @Autowired
    private MathService mathService;

    public MathController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    // http://localhost:8080/math/square?value=2
    @GetMapping("/square")
    public String square(@RequestParam(value = "value", required = false, defaultValue = "0") final int value) {
        final int result = mathService.square(value);
        System.out.println("MathController::println(): value = " + value + ", square =" + result);
        return String.valueOf(result);
    }
}
