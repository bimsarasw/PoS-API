package PoS.example.PoS.service.Impl;



import PoS.example.PoS.dtos.AdminDTO;
import PoS.example.PoS.dtos.UserDTO;
import PoS.example.PoS.entity.Admin;
import PoS.example.PoS.entity.User;
import PoS.example.PoS.repo.UserRepository;
import PoS.example.PoS.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();

        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(@NotNull String userId, @NotNull UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setEmail(userDTO.getEmail());
            return userRepository.save(user);  // Save the updated user
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

    @Override
    public User deleteUser(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
            return optionalUser.get(); // Return the deleted admin
        }
        throw new RuntimeException("Admin not found with id: " + userId);
    }




}




