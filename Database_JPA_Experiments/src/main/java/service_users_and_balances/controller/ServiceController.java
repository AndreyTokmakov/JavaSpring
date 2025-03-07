package service_users_and_balances.controller;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import service_users_and_balances.model.entities.AccountType;
import service_users_and_balances.model.entities.BalanceBase;
import service_users_and_balances.model.entities.SpotBalance;
import service_users_and_balances.model.entities.User;
import service_users_and_balances.service.BalancesService;
import service_users_and_balances.service.UserService;

import static service_users_and_balances.swagger.SwaggerConfig.INFO_TAG;


@Log4j2
@RestController
@Api(tags = { INFO_TAG })
public class ServiceController
{
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC+04:00"));

    @Autowired
    UserService userService;

    @Autowired
    BalancesService balancesService;

    public ServiceController() {
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
        System.out.println("User(id: " + user.getUserId() + ", name: " + user.getName() + ", email: " + user.getEmail() + ")");
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
    public ResponseEntity<String> addUser(@RequestParam(value = "name", required = true) final String name,
                                          @RequestParam(value = "email", required = true) final String email)
    {
        log.info("RestController::addUser({}, {})", name, email);

        final LocalDateTime timestamp = LocalDateTime.now();
        final User user = User.builder().email(email).name(name).build();

        userService.addUser(user);

        return ResponseEntity.status(200)
                .header("Custom-Header", "foo")
                .body("OK");
    }

    @GetMapping("/get_balance")
    public ResponseEntity<String> getBalance()
    {
        log.info("RestController::getBalance()");
        balancesService.findByAccount();
        return ResponseEntity.status(200).header("Custom-Header", "foo").body("OK");
    }

    @PostMapping("/add_balance")
    public ResponseEntity<String> addBalance(@RequestParam(value = "accountType", required = true) final AccountType accountType,
                                             @RequestParam(value = "subAccountEmail", required = true) final String subAccountEmail,
                                             @RequestParam(value = "free", required = true) final BigDecimal free,
                                             @RequestParam(value = "locked", required = true) final BigDecimal locked)
    {
        log.info("RestController::addBalance()");
        final SpotBalance balance = SpotBalance.builder()
                .id(UUID.randomUUID())
                .accountType(accountType)
                .subAccountEmail(subAccountEmail)
                .free(free)
                .locked(locked)
                .build();

        balancesService.addBalance(balance);
        return ResponseEntity.status(200).header("Custom-Header", "foo").body("OK");
    }
}