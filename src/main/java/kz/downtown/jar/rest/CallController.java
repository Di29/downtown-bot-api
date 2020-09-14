package kz.downtown.jar.rest;

import kz.downtown.jar.models.Call;
import kz.downtown.jar.service.CallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        List<Call> calls = callService.getAllCalls();
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

//    @RequestMapping(value = "")
}
