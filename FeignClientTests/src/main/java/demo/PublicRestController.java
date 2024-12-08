package demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Log4j2
@Controller
@RequestMapping("public")
public class PublicRestController
{
    @Autowired
    private EternalServiceClient extServiceClient;

    public PublicRestController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/info")
    public @ResponseBody String getAccount()
    {
        log.info("PublicRestController::getInfo()");
        String x = extServiceClient.getInfo(1L);
        // return accountService.getAccount(12345);
        return "<html><body bgcolor='gray'>OK</html>";
    }
}

