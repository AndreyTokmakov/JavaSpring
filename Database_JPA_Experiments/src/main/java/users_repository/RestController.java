package users_repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Log4j2
@Controller
public class RestController
{
    @Autowired
    UserService userService;

    public RestController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @RequestMapping("/get_users")
    public @ResponseBody String getUser()
    {
        log.info("RestController::getUser()");
        Optional<User> user = userService.getUserByName("admin");
        user.ifPresent(log::info);
        return "";
    }
}