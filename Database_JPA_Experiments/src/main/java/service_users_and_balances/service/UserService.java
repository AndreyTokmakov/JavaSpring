package service_users_and_balances.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service_users_and_balances.model.entities.User;
import service_users_and_balances.model.UserRepository;

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

    public boolean addUser(User user)
    {
        log.info("UserService::addUser {})", user);
        var result =  userRepository.saveAndFlush(user);
        return true;
    }
}