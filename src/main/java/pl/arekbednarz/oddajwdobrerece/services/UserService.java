package pl.arekbednarz.oddajwdobrerece.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.arekbednarz.oddajwdobrerece.DTO.UserDTO;
import pl.arekbednarz.oddajwdobrerece.entity.User;

public interface UserService extends UserDetailsService {
    User editUser(User user);
    User save(User user);
    User saveByDTO(UserDTO userDTO);
    User findUserByEmail(String email);
    void deleteById(Long id);
    User findById(Long id);
    User saveAdmin(User user);
    User saveUser(User user);
}

