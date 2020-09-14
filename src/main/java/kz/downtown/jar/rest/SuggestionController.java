package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.SuggestionInsertUpdateDTO;
import kz.downtown.jar.models.Suggestion;
import kz.downtown.jar.service.SuggestionsService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suggestions")
public class SuggestionController {

    private final SuggestionsService service;

    public SuggestionController(SuggestionsService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllSuggestions(){
        List<Suggestion> suggestions = service.getAllSuggestions();
        if (suggestions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(suggestions, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSuggestionById(@PathVariable("id") Long id) {
        Suggestion suggestion = service.getSuggestionById(id);
        if(suggestion == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(suggestion, HttpStatus.OK);
    }

    @RequestMapping(value = "block/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSuggestionsByBlockId(@PathVariable("id") Long id) {
        List<Suggestion> suggestion = service.getAllSuggestionsByBlockId(id);
        if (suggestion.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(suggestion, HttpStatus.OK);
    }

    @RequestMapping(value = "service/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportsByServiceName(@PathVariable("name") String name) {
        List<Suggestion> suggestions = service.getAllSuggestionsByServiceName(name);
        if (suggestions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(suggestions, HttpStatus.OK);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<?> addSuggestion(@RequestBody SuggestionInsertUpdateDTO dto) {
        try {
            service.addSuggestion(dto);
        } catch (Exception e ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }
        return ResponseEntity.ok().body("Suggestion added");
    }

    @RequestMapping(value = "admin/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeReportById(@PathVariable("id") Long id) {
        try {
            service.removeSuggestionById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Suggestion deleted");
    }
}
