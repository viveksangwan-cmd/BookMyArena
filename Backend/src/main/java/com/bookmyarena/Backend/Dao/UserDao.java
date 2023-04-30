package com.bookmyarena.Backend.Dao;

import com.bookmyarena.Backend.Models.Transaction;
import com.bookmyarena.Backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findByUserId(int id);
}
