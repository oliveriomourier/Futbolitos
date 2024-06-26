package com.example.futbolitos2.controller;

import com.example.futbolitos2.request.CreateUserRequest;
import com.example.futbolitos2.response.UserResponse;
import com.example.futbolitos2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @QueryMapping
    public UserResponse user(@Argument Integer userId){
        return new UserResponse(userService.getUserById(userId));
    }

    @MutationMapping
    public UserResponse createUser(@Argument CreateUserRequest createUserRequest) {
        return new UserResponse(userService.createUser(createUserRequest));
    }

    @MutationMapping
    public Integer deleteUserById(@Argument Integer userId){
        return userService.userDeleteById(userId);
    }
}
