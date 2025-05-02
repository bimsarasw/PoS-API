package PoS.example.PoS.service;



import PoS.example.PoS.dtos.UserDTO;
import PoS.example.PoS.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    User updateUser(String userId,UserDTO userDTO);
    User deleteUser(String userId);



    List<User> getAllUsers();
}

