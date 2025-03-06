package users_jpa_repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Log4j2
@Controller
public class RestController
{
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC+04:00"));

    @Autowired
    UserService userService;

    public RestController() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @GetMapping("/get_user")
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

    @GetMapping("/get_user_by_email")
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

    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestParam(value = "userId", required = true) final Integer userId,
                                          @RequestParam(value = "name", required = true) final String name,
                                          @RequestParam(value = "email", required = true) final String email)
    {
        log.info("RestController::addUser({}, {})", name, email);

        final LocalDateTime timestamp = LocalDateTime.now();
        final User user = User.builder().userId(userId).email(email).name(name).build();

        userService.addUser(user);

        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("OK");
    }
}