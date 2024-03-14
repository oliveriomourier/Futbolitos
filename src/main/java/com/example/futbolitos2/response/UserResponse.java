package com.example.futbolitos2.response;

import com.example.futbolitos2.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private List<BookingResponse> bookingList;

    private String fullName;

    // para uso interno, no agregar al schema.
    private User user;

    public UserResponse(User user) {
        this.user = user;
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    // los DTO's no tienen logica de negocio
}
