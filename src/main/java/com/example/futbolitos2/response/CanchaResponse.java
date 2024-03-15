package com.example.futbolitos2.response;

import com.example.futbolitos2.entity.Cancha;
import lombok.Data;

import java.util.List;

@Data
public class CanchaResponse {
    private Integer id;
    private String name;
    private String address;
    private Integer capacity;
    private Boolean reserved;

    public CanchaResponse(Cancha cancha) {
        this.id = cancha.getId();
        this.name = cancha.getName();
        this.address = cancha.getAddress();
        this.capacity = cancha.getCapacity();
    }
}
