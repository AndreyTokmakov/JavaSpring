package mdm.controller;


import lombok.extern.log4j.Log4j2;
import mdm.model.Device;
import mdm.model.Group;
import mdm.service.MDMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/group")
public class GroupsController
{
    @Autowired
    private MDMService service;

    public GroupsController() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Group>> getGroupByName(@PathVariable("name") String name)
    {
        log.info("getGroupByName() called");
        try {
            final List<Group> groups = service.findGroupByName(name);
            return new ResponseEntity<>(groups, HttpStatus.OK);
        }  catch (final Exception exc)  {
            System.out.println(exc.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Group> addGroup(@RequestBody Group group)
    {
        log.info("addDevice() called");
        try {
            final Group groupCreated = service.addGroup(group);
            return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
        }  catch (final Exception exc)  {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
