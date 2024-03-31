package com.example.futbolitos2.controller;

import com.example.futbolitos2.entity.Booking;
import com.example.futbolitos2.request.CreateBookingRequest;
import com.example.futbolitos2.response.BookingResponse;
import com.example.futbolitos2.response.UserResponse;
import com.example.futbolitos2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @MutationMapping
    public BookingResponse createBooking(@Argument CreateBookingRequest createBookingRequest){
        Booking booking = bookingService.createBooking(createBookingRequest);
        BookingResponse bookingResponse = new BookingResponse(booking);

        return bookingResponse;
    }

    @MutationMapping
    public Integer deleteBookingById(@Argument Integer bookingId){
        return bookingService.deleteBooking(bookingId);
    }

    @QueryMapping
    public BookingResponse booking(@Argument Integer bookingId){
        return new BookingResponse(bookingService.getBookingById(bookingId));
    }
}
