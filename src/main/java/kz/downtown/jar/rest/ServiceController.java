package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.ServiceInsertUpdateDTO;
import kz.downtown.jar.models.Service;
import kz.downtown.jar.service.ServiceService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("botservices")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllServices() {
        List<Service> services = service.getAllServices();
        if (services.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getServiceById(@PathVariable("id") Long id) {
        Service service1 = service.getServiceById(id);
        if (service1 == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(service1, HttpStatus.OK);
    }

    @RequestMapping(value = "name/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getServiceByName(@RequestParam("name") String name) {
        Service service1 = service.getServiceByName(name);
        if (service1 == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(service1, HttpStatus.OK);
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public ResponseEntity<?> addService(@RequestBody ServiceInsertUpdateDTO dto) {
        try {
            service.addService(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }
        return ResponseEntity.ok().body("Service added");
    }

    @RequestMapping(value = "admin/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeService(@PathVariable("id") Long id) {
        try {
            service.removeServiceById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Service doesn't exist");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Service deleted");
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateService(@RequestBody ServiceInsertUpdateDTO dto) {
        try {
            service.updateService(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Service updated");
    }
}
