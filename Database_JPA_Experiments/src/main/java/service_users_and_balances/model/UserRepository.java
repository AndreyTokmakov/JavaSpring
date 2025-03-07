package service_users_and_balances.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import service_users_and_balances.model.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>
{
    Optional<User> findByName(String name);

    @Query("from User u where u.email = :email")
    Optional<User> findByEmail(String email);

}
