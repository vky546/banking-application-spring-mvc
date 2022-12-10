package com.xoriant.bankingapplication.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.serviceimpl.AccountServiceImpl;

public class miniStatementServiceTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		AccountService accountService = context.getBean(AccountServiceImpl.class);
		
		List<Transaction> t  = accountService.getMiniStatement(3);
		for(Transaction tans:t) {
		System.out.println(tans);
		}
	}
	
	

}
