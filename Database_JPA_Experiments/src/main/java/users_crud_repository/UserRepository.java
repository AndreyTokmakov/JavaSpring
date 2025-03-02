package users_crud_repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String>
{
    Optional<User> findByName(String name);

    @Query("from User u where u.email = :email")
    Optional<User> findByEmail(String email);
}
