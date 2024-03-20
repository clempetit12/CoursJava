package com.m2ibank.controller;

import com.m2ibank.dto.BaseResponseDto;
import com.m2ibank.dto.UserLoginDto;
import com.m2ibank.model.Customer;
import com.m2ibank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/api/auth/register")
    public BaseResponseDto registerUser(@RequestBody Customer customer){
        if(customerService.createUser(customer)){
            return new BaseResponseDto("success");
        }else {
            return new BaseResponseDto("failed");
        }

    }

    @PostMapping("/api/auth/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {
        if(customerService.checkUsernameExists(userLoginDto.getEmail())){
            if(customerService.verifyUser(userLoginDto.getEmail(),userLoginDto.getPassword())){
                Map<String,Object> data =new HashMap<>();
                data.put("token",customerService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
                return new BaseResponseDto("success",data);
            }else{
                return new  BaseResponseDto("wrong password");
            }

        }else{
            return new  BaseResponseDto("user doesn't exist");
        }
    }

}
