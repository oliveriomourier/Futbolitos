package com.example.futbolitos2.response;

import com.example.futbolitos2.entity.Booking;
import lombok.Data;

@Data
public class BookingResponse {
    private Long id;
    private UserResponse user;
    private CanchaResponse cancha;
    private Boolean isReserved;
    private String time; //modificar para que sea del tipo Date
    private Booking booking; // no incluir dentro del schema

    public BookingResponse(Booking booking) {
        this.booking = booking;
        this.id = booking.getId();
        this.isReserved = booking.getIsReserved();
        this.time = booking.getTime();
        /* this.user = UserResponse.builder()
                .id(booking.getUser().getId())
                .build();
         */
    }
}
