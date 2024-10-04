package com.project.demo.controller;

import com.project.demo.dto.UserDTO;
import com.project.demo.entity.User;
import com.project.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getUser")
    public String getUser(@RequestBody User user) {
        UserDTO userDTO = userService.getUserByEmail(user.getEmailId());
        if(userDTO == null)return "UserNotFound";
        else return user.toString();
    }
    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        System.out.println(user);
        return userService.createUser(user);
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
