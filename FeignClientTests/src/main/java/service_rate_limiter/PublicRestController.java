package service_rate_limiter;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service_rate_limiter.service.InfoServiceImpl;

@Log4j2
@Controller
@RequestMapping("public")
public class PublicRestController
{
    @Autowired
    private InfoServiceImpl infoService;

    public PublicRestController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/info")
    public @ResponseBody String getAccount(@RequestParam(value = "accountId", required = true) final int accountId)
    {
        // log.info("PublicRestController::getAccount()");
        final String infoString = infoService.getAccount(accountId);
        return infoString;
    }
}

