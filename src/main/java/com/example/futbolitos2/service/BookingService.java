package com.example.futbolitos2.service;

import com.example.futbolitos2.entity.Booking;
import com.example.futbolitos2.entity.Cancha;
import com.example.futbolitos2.entity.User;
import com.example.futbolitos2.exception.UserNotFoundException;
import com.example.futbolitos2.repository.BookingRepository;
import com.example.futbolitos2.request.CreateBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserService userService;
    @Autowired
    CanchaService canchaService;

    public Booking createBooking(CreateBookingRequest bookingRequest){
        User user = userService.getUserById(bookingRequest.getUserId());
        Cancha cancha = canchaService.getCanchaById(bookingRequest.getCanchaId());
        Booking booking = new Booking(user, cancha, bookingRequest.getIsReserved(), bookingRequest.getTime());

        bookingRepository.save(booking);

        return booking;
    }

    public Booking getBookingById(Integer bookingId) throws UserNotFoundException {
        return bookingRepository
                .findById(Long.valueOf(bookingId))
                .orElseThrow(() -> new UserNotFoundException("Booking with id: " + bookingId + " doesn't exist"));
    }

    public Integer deleteBooking(Integer bookingId){
        Booking booking = getBookingById(bookingId);
        bookingRepository.delete(booking);

        return bookingId;
    }
}
