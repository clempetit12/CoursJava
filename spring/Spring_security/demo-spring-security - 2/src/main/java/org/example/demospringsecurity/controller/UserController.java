package org.example.demospringsecurity.controller;

import org.example.demospringsecurity.dto.BaseResponseDto;
import org.example.demospringsecurity.dto.UserLoginDto;
import org.example.demospringsecurity.entity.User;
import org.example.demospringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    UserService userService;

    //Comme c'est une info extérieure il faudrait utiliser un userdto
    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User user){
        if(userService.createUser(user)){
            return new BaseResponseDto("success");
        }else {
            return new BaseResponseDto("failed");
        }

    }

    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {
        if(userService.checkUsernameExists(userLoginDto.getEmail())){
            if(userService.verifyUser(userLoginDto.getEmail(),userLoginDto.getPassword())){
                Map<String,Object> data =new HashMap<>();
                data.put("token",userService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
                return new BaseResponseDto("success",data);
            }else{
                return new  BaseResponseDto("wrong password");
            }

        }else{
            return new  BaseResponseDto("user doesn't exist");
        }
    }
}
