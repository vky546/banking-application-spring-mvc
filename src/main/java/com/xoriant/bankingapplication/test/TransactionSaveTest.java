package com.xoriant.bankingapplication.test;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.dao.PersonDAO;
import com.xoriant.bankingapplication.dao.TransactionDAO;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Person;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.model.TransactionStatus;

public class TransactionSaveTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	     TransactionDAO transactionDAO = context.getBean(TransactionDAO.class);
	     Transaction transaction=new Transaction();
	     transaction.setDateOfTransaction(LocalDate.of( 2022 , 03 , 02 ));
	     transaction.setToAcount(1000);
	     transaction.setFromAccount(2);
	     transaction.setAmount(4000);
	     transaction.setCurrentBalance(10000);
	     transaction.setTransactionStatus(TransactionStatus.success);
	     transactionDAO.save(transaction);
		System.out.println("transaction saved sucessfully");
	}

}
