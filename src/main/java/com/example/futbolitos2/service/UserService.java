package com.example.futbolitos2.service;

import com.example.futbolitos2.entity.Booking;
import com.example.futbolitos2.entity.Cancha;
import com.example.futbolitos2.entity.User;
import com.example.futbolitos2.exception.UserNotFoundException;
import com.example.futbolitos2.repository.BookingRepository;
import com.example.futbolitos2.repository.CanchaRepository;
import com.example.futbolitos2.repository.UserRepository;
import com.example.futbolitos2.request.BookingRequest;
import com.example.futbolitos2.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CanchaRepository canchaRepository;
    @Autowired
    BookingRepository bookingRepository;
    public User getUserById(Integer userId) throws UserNotFoundException
    {
            return userRepository.findById(Long.valueOf(userId))
                    .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " doesn't exist"));
    }

    public User createUser(CreateUserRequest createUserRequest) throws UserNotFoundException
    {
        if(userExist(createUserRequest.getEmail())){
            throw new UserNotFoundException("User with mail "+ createUserRequest.getEmail()+" is already register");
        }

        User user = new User(createUserRequest);
        userRepository.save(user);

        List<Booking> bookingList = new ArrayList<Booking>();

        if(createUserRequest.getBookingList() != null){
            for(BookingRequest bookingRequest : createUserRequest.getBookingList()){
                Booking booking = new Booking();
                booking.setIsReserved(bookingRequest.getIsReserved());
                booking.setTime(bookingRequest.getTime());

                Cancha cancha = new Cancha(bookingRequest.getCancha());
                booking.setCancha(cancha);

                bookingList.add(booking);
            }
            bookingRepository.saveAll(bookingList);
        }
        user.setBookingList(bookingList);
        return user;
    }

    private Boolean userExist(String userEmail){
        User user = userRepository.findByEmail(userEmail);
        return user != null;
    }

    public Integer userDeleteById(Integer userId) throws UserNotFoundException{
        //verify if the user exist
        User user = getUserById(userId);

        // delete user
        userRepository.delete(user);
        return userId;
    }
}
