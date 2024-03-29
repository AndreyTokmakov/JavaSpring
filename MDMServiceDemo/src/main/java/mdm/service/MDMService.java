package mdm.service;


import lombok.extern.log4j.Log4j2;
import mdm.model.Device;
import mdm.model.Group;
import mdm.repositories.DeviceRepository;
import mdm.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Log4j2
@Component
public class MDMService
{
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    GroupRepository groupRepository;

    public MDMService() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    public Optional<Device> findDeviceById(String deviceId)
    {
        Optional<Device> device = deviceRepository.findById(deviceId);
        if (device.isPresent())
            System.out.println(device);
        else
            System.err.println("Failed to find device with ID: " + deviceId);
        return device;
    }

    public Device addDevice(Device device)
    {
        return deviceRepository.save(new Device(device.getId(), device.getRole(), device.getGroup()));
    }

    public List<Group> findGroupByName(String groupName)
    {
        return groupRepository.findByName(groupName);
    }

    public Group addGroup(Group group)
    {
        return groupRepository.save(new Group(group.getName()));
    }
}
