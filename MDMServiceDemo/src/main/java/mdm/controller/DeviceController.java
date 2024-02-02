package mdm.controller;


import lombok.extern.log4j.Log4j2;
import mdm.model.Device;
import mdm.service.MDMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/mdm_api")
public class DeviceController
{
    @Autowired
    // @Qualifier("RemoteService")
    private MDMService service;

    public DeviceController() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") String id)
    {
        log.info("getDeviceById() called");
        try {
            final Optional<Device> device = service.findDeviceById(id);
            return new ResponseEntity<>(device.get(), HttpStatus.OK);
        }  catch (final Exception exc)  {
            System.out.println(exc.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/device")
    public ResponseEntity<Device> addDevice(@RequestBody Device device)
    {
        log.info("addDevice() called");
        try {
            final Device deviceCreated = service.addDevice(device);
            return new ResponseEntity<>(deviceCreated, HttpStatus.CREATED);
        }  catch (final Exception exc)  {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
