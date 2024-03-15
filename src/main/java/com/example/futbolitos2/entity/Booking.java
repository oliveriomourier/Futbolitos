package com.example.futbolitos2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cancha_id")
    private Cancha cancha;

    @Column(name = "isReserved")
    private Boolean isReserved;

    @Column(name = "time")
    private String time; //modificar para que sea del tipo Date
}
