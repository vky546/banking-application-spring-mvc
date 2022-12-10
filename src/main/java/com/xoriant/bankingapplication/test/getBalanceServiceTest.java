package com.xoriant.bankingapplication.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.serviceimpl.AccountServiceImpl;

public class getBalanceServiceTest {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		AccountService accountService = context.getBean(AccountService.class);
		
		Account account  = accountService.getBalance(2);
		
		System.out.println(account);
		
	}
}
