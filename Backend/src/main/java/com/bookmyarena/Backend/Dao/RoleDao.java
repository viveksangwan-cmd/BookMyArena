package com.bookmyarena.Backend.Dao;

import com.bookmyarena.Backend.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
}
