package com.example.futbolitos2.entity;

import com.example.futbolitos2.request.CreateCanchaRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cancha")
public class Cancha
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address; //cambiar esto por alguna clase Address que brinde mas informacion.

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "cancha", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Booking> bookingList;

    public Cancha(CreateCanchaRequest createCanchaRequest) {
        this.name = createCanchaRequest.getName();
        this.address = createCanchaRequest.getAddress();
        this.capacity = createCanchaRequest.getCapacity();
        this.bookingList = new ArrayList<>();
    }
}
