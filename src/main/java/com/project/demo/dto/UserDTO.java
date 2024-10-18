package com.project.demo.dto;

import com.project.demo.entity.User;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String emailId;
    private String phoneNumber;
    private String imageUrl;
    private String password;

    public UserDTO mapUser(User user){
        UserDTO userDTO =new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmailId(user.getEmailId());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setImageUrl(user.getImageUrl());
        return userDTO;
    }

}
