package mongodb_tests.repositories;


import mongodb_tests.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GroupRepository extends MongoRepository<Group, String>
{
    List<Group> findByName(String name);
}