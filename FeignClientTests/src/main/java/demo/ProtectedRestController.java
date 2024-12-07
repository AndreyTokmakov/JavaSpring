package demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequestMapping("protected")
public class ProtectedRestController
{
    public ProtectedRestController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/info")
    public @ResponseBody String getInfo()
    {
        log.info("ProtectedRestController::getInfo()");
        // return accountService.getAccount(12345);
        return "<html><body bgcolor='gray'>OK - protected</html>";
    }
}

