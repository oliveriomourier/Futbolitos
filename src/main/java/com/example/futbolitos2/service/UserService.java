package com.example.futbolitos2.service;

import com.example.futbolitos2.entity.User;
import com.example.futbolitos2.exception.UserNotFoundException;
import com.example.futbolitos2.repository.UserRepository;
import com.example.futbolitos2.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer userId) throws UserNotFoundException {
            return userRepository
                    .findById(Long.valueOf(userId))
                    .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " doesn't exist"));
    }

    public User createUser(CreateUserRequest createUserRequest) throws UserNotFoundException {
        String userEmail = createUserRequest.getEmail();

        if(userRepository.existsByEmail(userEmail)){
            throw new UserNotFoundException("User with mail "+ userEmail +" is already register");
        }

        User user = new User(createUserRequest);
        userRepository.save(user);

        return user;
    }

    public Integer userDeleteById(Integer userId) throws UserNotFoundException {
        User user = getUserById(userId);

        userRepository.delete(user);
        return userId;
    }
}
