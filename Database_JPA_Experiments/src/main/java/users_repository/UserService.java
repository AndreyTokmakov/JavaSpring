package users_repository;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public UserService()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public Optional<User> getUserByName(String name)
    {
        log.info("UserService::getUserByName()");
        final Optional<User> user = userRepository.findByName(name);
        return user;
    }
}