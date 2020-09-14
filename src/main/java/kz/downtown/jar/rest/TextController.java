package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.BotTextDTO;
import kz.downtown.jar.dtos.TextInsertUpdateDTO;
import kz.downtown.jar.models.BotText;
import kz.downtown.jar.service.TextService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("texts")
public class TextController {

    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllTexts() {
        List<BotText> texts = textService.getAllTexts();

        if(texts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(texts, HttpStatus.OK);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTextByName(@PathVariable("name") String textName) {
        if (textName.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        BotText texts = textService.getTextByTextName(textName);

        if (texts == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(texts, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTextById(@PathVariable("id") Long id) {
        BotText text = textService.getTextById(id);
        if(text == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateService(@RequestBody TextInsertUpdateDTO textDTO) {
        try {
            textService.updateText(textDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok().body("Text updated");
    }

}
