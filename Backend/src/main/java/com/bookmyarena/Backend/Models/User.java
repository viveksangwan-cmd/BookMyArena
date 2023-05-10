package com.bookmyarena.Backend.Models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String contact;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean isActive;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "ownerId")
    private Set<Arena> arenas = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();
}
