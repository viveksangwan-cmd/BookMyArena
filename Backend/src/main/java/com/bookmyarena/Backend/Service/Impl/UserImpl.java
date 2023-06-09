package com.bookmyarena.Backend.Service.Impl;

import com.bookmyarena.Backend.Dao.TransactionDao;
import com.bookmyarena.Backend.Dao.UserDao;
import com.bookmyarena.Backend.Models.Transaction;
import com.bookmyarena.Backend.Models.User;
import com.bookmyarena.Backend.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    TransactionDao transactionDao;

    @Override
    public User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPasssword(password);
        try{
            userDao.save(user);
            log.info("New User Created");
        }catch (Exception ex){

        }
        return user;
    }

    @Override
    public List<Transaction> getUserTransactionsWithUserId(int id) {
        List<User> userList = userDao.findByUserId(id);
        User user = new User();
        user.setEmail("m@g.com");
        userDao.save(user);
        Transaction transaction = new Transaction();
        return List.copyOf(userList.get(0).getTransactions());
    }
}
