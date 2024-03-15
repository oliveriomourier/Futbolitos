package com.example.futbolitos2.service;

import com.example.futbolitos2.entity.Booking;
import com.example.futbolitos2.entity.Cancha;
import com.example.futbolitos2.entity.User;
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
        //verificar que user exista
        User user = userService.getUserById(bookingRequest.getUserId());

        //verificar que cancha exista
        Cancha cancha = canchaService.getCanchaById(bookingRequest.getCanchaId());

        // crear la reserva
        Booking booking = new Booking();
        booking.setIsReserved(bookingRequest.getIsReserved());
        booking.setUser(user);
        booking.setCancha(cancha);
        booking.setTime(bookingRequest.getTime());


        //guardar la reserva en la BBDD
        bookingRepository.save(booking);

        return booking;
    }
}
