package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.UserRegisterDTO;
import kz.downtown.jar.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserRegisterDTO userDto) {
        try {
            userService.addUser(userDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    e.getMessage()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body("New user added");
    }
}
