package com.example.futbolitos2.controller;

import com.example.futbolitos2.request.CreateBookingRequest;
import com.example.futbolitos2.response.BookingResponse;
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
        return new BookingResponse(bookingService.createBooking(createBookingRequest));
    }
}
