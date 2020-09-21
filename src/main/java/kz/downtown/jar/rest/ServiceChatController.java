package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.ServiceChatInsertUpdateDTO;
import kz.downtown.jar.models.ServiceChat;
import kz.downtown.jar.service.ServiceChatService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chats")
public class ServiceChatController {

    private final ServiceChatService service;

    public ServiceChatController(ServiceChatService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllChats(){
        List<ServiceChat> chats = service.getAllServiceChats();
        if (chats.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChatById(@PathVariable("id") Long id) {
        ServiceChat chat = service.getServiceChatById(id);
        if (chat == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }

    @RequestMapping(value = "chat/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChatByChatId(@PathVariable("id") Long id) {
        ServiceChat chat = service.getServiceChatByChatId(id);
        if (chat == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }

    @RequestMapping(value = "service/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChatByServiceId(@PathVariable("id") Long id) {
        List<ServiceChat> chats = service.getServiceChatsByServiceId(id);
        if (chats.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @RequestMapping(value = "block/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChatsByBlockId(@PathVariable("id") Long id) {
        List<ServiceChat> chats = service.getServiceChatsByBlockId(id);
        if (chats.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @RequestMapping(value = "block/{bId}/service/{sId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChatsByBlockId(@PathVariable("bId") Long blockId, @PathVariable("sId") Long serviceId) {
        List<ServiceChat> chats = service.getServiceChatsByBlockIdAndServiceId(blockId, serviceId);
        if (chats.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }


    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public ResponseEntity<?> addChat(@RequestBody ServiceChatInsertUpdateDTO dto) {
        try {
            service.addServiceChat(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Service chat added");
    }

    @RequestMapping(value = "admin/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeChat(@PathVariable("id") Long id) {
        try {
            service.removeServiceChatById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Chat doesn't exist");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }
        return ResponseEntity.ok().body("Chat deleted");
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateChat(@RequestBody ServiceChatInsertUpdateDTO dto) {
        try {
            service.updateServiceChat(dto);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }
        return ResponseEntity.ok().body("Chat updated");
    }
}
