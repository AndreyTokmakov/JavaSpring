package users_jpa_repository;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        log.info("UserService::getUserByName({})", name);
        return userRepository.findByName(name);
    }

    public Optional<User> getUserByEmail(String email)
    {
        log.info("UserService::getUserByName(email = {})", email);
        return userRepository.findByEmail(email);
    }
}