package kz.downtown.jar.service;

import kz.downtown.jar.dtos.UserRegisterDTO;
import kz.downtown.jar.models.User;
import kz.downtown.jar.repository.UserRepository;
import kz.downtown.jar.service.interfaces.UserInterface;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public void addUser(UserRegisterDTO userDto) {
        User user = new User(userDto);
        userRepository.save(user);
    }
}
