package com.bookmyarena.Backend;

import com.bookmyarena.Backend.Models.Transaction;
import com.bookmyarena.Backend.Service.UserService;
import com.bookmyarena.Backend.Utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class BackedForBookMyArenaApplication  implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BackedForBookMyArenaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		userService.createUser("Mohit","abc@gmail.com");
		//userService.getUserTransactionsWithUserId(1);
	}
}
