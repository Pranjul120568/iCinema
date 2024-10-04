package com.project.demo.services;

import com.project.demo.dto.UserDTO;
import com.project.demo.entity.User;
import com.project.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmailId(email);
        UserDTO userDTO = null;
        if(user.isPresent()){
            userDTO = new UserDTO();
            userDTO.mapUser(user.get());
        }
        return userDTO;
    }
    public String createUser(User user){
        try {
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getCause().toString());
            return "Unable to create user";
        }
        return "User created successfully";
    }


    public String updateUser(User user) {
        Integer userId=null;
        try {
            userId = userRepository.findByEmailId(user.getEmailId()).get().getUserId();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "User doesn't exists!!!";
        }
        user.setUserId(userId);
        try {
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Unable to update user";
        }
        return "User updated successfully";
    }
}
