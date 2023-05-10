package com.bookmyarena.Backend.Models;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    private int bookingId;

    @ManyToOne
    private User user;

    @ManyToOne
    private User owner;

    @OneToOne
    private Transaction transaction;
}
