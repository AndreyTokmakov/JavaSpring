package mongodb_tests.repositories;

import mongodb_tests.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DeviceRepository extends MongoRepository<Device, String>
{
    List<Device> findByRole(String role);

    List<Device> findByGroup(String group);
}