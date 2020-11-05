package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.CallInsertUpdateDTO;
import kz.downtown.jar.models.Call;
import kz.downtown.jar.service.CallService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calls")
public class CallController {

    private final CallService callService;

    public CallController(CallService callService){
        this.callService = callService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCalls() {
        List<Call> calls = callService.getCallsSorted();
        if (calls.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCallById(@PathVariable("id") Long id) {
        Call call = callService.getCallById(id);
        if (call == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(call, HttpStatus.OK);
    }

    @RequestMapping(value = "block/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCallsByBlockName(@RequestParam("name") String name) {
        if(name == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        List<Call> calls = callService.getCallsByBlockName(name);
        if(calls.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @RequestMapping(value = "block/{bname}/service/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCallsByBlockNameAndServiceName(
            @PathVariable("bname") String blockName,
            @RequestParam("name") String serviceName) {
        if((blockName == null) || (serviceName == null))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        List<Call> calls = callService.getCallsByBlockNameAndServiceName(blockName, serviceName);
        if(calls.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @RequestMapping(value = "records", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRecords() {
        List<String> count = callService.detRecords();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }




    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<?> addCall(@RequestBody CallInsertUpdateDTO dto) {
        try {
            callService.addCall(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok().body("A call was added");
    }

    @RequestMapping(value = "admin/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCallById(@PathVariable("id") Long id) {
        try {
            callService.removeCallById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Call doesn't exist");
        }

        return ResponseEntity.ok().body("Call was deleted");
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCall(@RequestBody CallInsertUpdateDTO dto){
        try {
            callService.updateCall(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok().body("Call was updated");
    }


}
