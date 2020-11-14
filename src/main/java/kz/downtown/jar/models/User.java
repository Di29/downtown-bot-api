package kz.downtown.jar.models;

import kz.downtown.jar.dtos.UserRegisterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User(UserRegisterDTO dto) {
        setName(dto.getName());
        setSurname(dto.getSurname());
        setUsername(dto.getUsername());
        setPassword(dto.getPassword());
        setRole(dto.getRole());
    }
}
