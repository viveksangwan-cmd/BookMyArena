package com.bookmyarena.Backend.Service;

import com.bookmyarena.Backend.Models.Transaction;
import com.bookmyarena.Backend.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User createUser(String email,String password);
    public List<Transaction> getUserTransactionsWithUserId(int id);
}
