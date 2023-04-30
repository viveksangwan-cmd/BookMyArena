package com.bookmyarena.Backend.Dao;

import com.bookmyarena.Backend.Models.Arena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArenaDao extends JpaRepository<Arena,Integer> {
}
