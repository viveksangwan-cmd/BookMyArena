package com.bookmyarena.Backend.Dao;

import com.bookmyarena.Backend.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDao extends JpaRepository<Transaction,Integer> {
    Transaction findByTransactionId(int id);

}
