package users_crud_repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/get_user")
    public ResponseEntity<String> getUser(@RequestParam(value = "name", required = true) final String name)
    {
        log.info("RestController::getUser()");
        Optional<User> userResult = userService.getUserByName(name);
        if (userResult.isEmpty())  {
            return ResponseEntity.status(404).body("Failed to find user with name '" + name + "'");
        }

        final User user = userResult.get();
        System.out.println("User(id: " + user.getUserId() + ", name: "
                + user.getName() + ", email: " + user.getEmail() + ")");
        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("User(id: " + user.getUserId() + ", name: "
                        + user.getName() + ", email: " + user.getEmail() + ")");
    }

    @RequestMapping("/get_user_by_email")
    public ResponseEntity<String> getUserByEmail(@RequestParam(value = "email", required = true) final String email)
    {
        log.info("RestController::getUserByEmail()");
        Optional<User> userResult = userService.getUserByEmail(email);
        if (userResult.isEmpty())  {
            return ResponseEntity.status(404).body("Failed to find user with email '" + email + "'");
        }

        final User user = userResult.get();
        System.out.println("User(id: " + user.getUserId() + ", name: "
                + user.getName() + ", email: " + user.getEmail() + ")");
        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("User(id: " + user.getUserId() + ", name: "
                        + user.getName() + ", email: " + user.getEmail() + ")");
    }
}