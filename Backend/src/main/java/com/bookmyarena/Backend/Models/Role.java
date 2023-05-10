package com.bookmyarena.Backend.Models;

import com.bookmyarena.Backend.Utils.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    @Column(nullable = false)
    private RoleType roleType;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
