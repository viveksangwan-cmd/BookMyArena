package com.bookmyarena.Backend.Models;

import jakarta.persistence.*;
import com.bookmyarena.Backend.Utils.TransactionType;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private TransactionType transactionType;

    @Column(nullable = false)
    private String referenceId;
    @ManyToOne
    private User user;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "transaction")
    private Booking booking;
}
