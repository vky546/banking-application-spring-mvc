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

public class TransactionUpdateTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	     TransactionDAO transactionDAO = context.getBean(TransactionDAO.class);
	     Transaction transaction=new Transaction();
	     transaction.setDateOfTransaction(LocalDate.of( 2022 , 02 , 01 ));
	     transaction.setToAcount(1000);
	     transaction.setFromAccount(1000);
	     transaction.setAmount(4000);
	     transaction.setCurrentBalance(14000);
	     transaction.setTransactionStatus(TransactionStatus.success);
	     transaction.setTransactionId(10001);
	     transactionDAO.update(transaction);
		System.out.println("transaction updated sucessfully");
	}

}
