package com.bookmyarena.Backend.Models;

import com.bookmyarena.Backend.Utils.ArenaVenueType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Arena {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int arenaId;

    private ArenaVenueType venueType;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User ownerId;
}
