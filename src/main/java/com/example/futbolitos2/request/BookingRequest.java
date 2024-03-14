package com.example.futbolitos2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    private Boolean is_reserver;
    private String time;
    private CreateCanchaRequest cancha;
}
