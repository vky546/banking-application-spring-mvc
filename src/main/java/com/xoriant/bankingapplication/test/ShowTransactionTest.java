package com.xoriant.bankingapplication.test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

public class ShowTransactionTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	     TransactionDAO transactionDAO = context.getBean(TransactionDAO.class);
	    // Transaction transaction = transactionDAO.findById(10001);
	    // List<Transaction> transactions = transactionDAO.findAll();
	     List<Transaction> transactions= transactionDAO.findByProperty("fromAccount",1000);
		System.out.println(transactions);
	}

}
