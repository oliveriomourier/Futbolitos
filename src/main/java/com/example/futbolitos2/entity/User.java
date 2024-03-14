package com.example.futbolitos2.entity;

import com.example.futbolitos2.request.CreateUserRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Booking> bookingList;

    public User(CreateUserRequest createUserRequest) {
        this.name = createUserRequest.getName();
        this.lastName = createUserRequest.getLastName();
        this.email = createUserRequest.getEmail();
        this.password = createUserRequest.getPassword();
    }
}
