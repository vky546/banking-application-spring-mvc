package com.xoriant.bankingapplication.test;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.model.TransactionStatus;
import com.xoriant.bankingapplication.service.AccountService;

public class CustomerFundTransferService {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		AccountService accountService = context.getBean(AccountService.class);
		
		accountService.FundTransfer(2, 32, LocalDate.of( 2022 , 03 , 02 ), 600, "success");
		
		
	}

}
