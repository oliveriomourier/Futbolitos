package com.example.futbolitos2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingRequest {
    private Boolean isReserved;
    private String time;
    private Integer canchaId;
    private Integer userId;
}
