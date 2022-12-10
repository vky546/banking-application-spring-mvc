package com.xoriant.bankingapplication.test;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AccountDAO;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.dao.PersonDAO;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.AccountStatus;
import com.xoriant.bankingapplication.model.AccountType;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Person;

public class AccountSaveTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	    AccountDAO accountDAO = context.getBean(AccountDAO.class);
	     Account account=new Account();
	     account.setCustomerId(2);
	     account.setAccountStatus(AccountStatus.active);
	     account.setAccountType(AccountType.current);
	     account.setCurrentBalance(2000);
	     accountDAO.save(account);
		System.out.println("account save sucessfully");
	}

}
