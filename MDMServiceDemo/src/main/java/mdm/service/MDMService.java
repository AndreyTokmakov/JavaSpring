package mdm.service;


import lombok.extern.log4j.Log4j2;
import mdm.model.Device;
import mdm.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
public class MDMService {

    @Autowired
    DeviceRepository deviceRepository;

    public MDMService() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    public Optional<Device> findDeviceById(String deviceId)
    {
        return deviceRepository.findById(deviceId);
    }

    public Device addDevice(Device device)
    {
        return deviceRepository.save(new Device(device.getId(), device.getRole(), device.getGroup()));
    }
}
