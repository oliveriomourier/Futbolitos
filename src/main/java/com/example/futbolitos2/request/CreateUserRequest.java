package com.example.futbolitos2.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserRequest {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
