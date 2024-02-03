package mongodb_tests.tests;

import mongodb_tests.model.Device;
import mongodb_tests.repositories.DeviceRepository;
import mongodb_tests.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Tester
{
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    GroupRepository groupRepository;

    public void readDevice()
    {
        Optional<Device> device = deviceRepository.findById("12345");
    }
}


