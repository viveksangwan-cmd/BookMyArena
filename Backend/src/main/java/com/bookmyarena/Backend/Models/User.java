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
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String passsword;
    @Column(nullable = false)
    private boolean isActive;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "users")
    Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "ownerId")
    Set<Arena> arenas = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Transaction> transactions = new HashSet<>();

}
