package com.bookmyarena.Backend.Dao;

import com.bookmyarena.Backend.Models.Address;
import com.bookmyarena.Backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressDao extends JpaRepository<Address,Integer> {
    List<Address> findByUser(User user);
}
