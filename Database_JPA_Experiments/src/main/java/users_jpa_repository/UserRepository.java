package users_jpa_repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>
{
    Optional<User> findByName(String name);

    @Query("from User u where u.email = :email")
    Optional<User> findByEmail(String email);

}
