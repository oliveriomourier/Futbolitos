package com.example.futbolitos2.controller;

import com.example.futbolitos2.entity.Booking;
import com.example.futbolitos2.request.CreateBookingRequest;
import com.example.futbolitos2.response.BookingResponse;
import com.example.futbolitos2.response.CanchaResponse;
import com.example.futbolitos2.response.UserResponse;
import com.example.futbolitos2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @MutationMapping
    public BookingResponse createBooking(@Argument CreateBookingRequest createBookingRequest){
        Booking booking = bookingService.createBooking(createBookingRequest);
        CanchaResponse canchaResponse = new CanchaResponse(booking.getCancha());
        UserResponse userResponse = new UserResponse(booking.getUser());

        BookingResponse bookingResponse = new BookingResponse(booking);
        bookingResponse.setCancha(canchaResponse);
        bookingResponse.setUser(userResponse);

        return bookingResponse;
    }
}
