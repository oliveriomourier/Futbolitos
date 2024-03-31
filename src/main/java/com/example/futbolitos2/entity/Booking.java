package com.example.futbolitos2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
@Builder
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

    public Booking(User user, Cancha cancha, Boolean isReserved, String time) {
        this.user = user;
        this.cancha = cancha;
        this.isReserved = isReserved;
        this.time = time;
    }
}
