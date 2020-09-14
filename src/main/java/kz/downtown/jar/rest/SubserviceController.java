package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.SubserviceInsertUpdateDTO;
import kz.downtown.jar.models.Subservice;
import kz.downtown.jar.service.SubserviceService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subservices")
public class SubserviceController {

    private final SubserviceService service;

    public SubserviceController(SubserviceService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllSubservices() {
        List<Subservice> subservices = service.getAllSubservices();
        if (subservices.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(subservices, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubserviceById(@PathVariable("id") Long id) {
        Subservice subservice = service.getSubserviceById(id);
        if (subservice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subservice, HttpStatus.OK);
    }

    @RequestMapping(value = "subservice/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubserviceByServiceId(@PathVariable("id") Long id) {
        List<Subservice> subservice = service.getSubservicesByServiceId(id);
        if (subservice.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(subservice, HttpStatus.OK);
    }

    @RequestMapping(value = "subservice/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubserviceByName(@PathVariable("name") String name) {
        Subservice subservice = service.getSubserviceByName(name);
        if (subservice == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(subservice, HttpStatus.OK);
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public ResponseEntity<?> addSubservice(@RequestBody SubserviceInsertUpdateDTO dto) {
        try {
            service.addSubservice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }
        return ResponseEntity.ok().body("Subservice added");
    }

    @RequestMapping(value = "admin/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeSubservice(@PathVariable("id") Long id) {
        try {
            service.removeSubserviceById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Subservice doesn't exist");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Service deleted");
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubservice(@RequestBody SubserviceInsertUpdateDTO dto) {
        try {
            service.updateSubservice(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Subservice updated");
    }

}
