package com.example.futbolitos2.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCanchaRequest {
    private String address;
    private Integer capacity;
    private String name;
}
