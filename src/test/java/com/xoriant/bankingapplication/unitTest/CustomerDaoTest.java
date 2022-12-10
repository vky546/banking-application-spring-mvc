package com.xoriant.bankingapplication.unitTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.model.Customer;

@ComponentScan
public class CustomerDaoTest {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	private Customer vikkey;
	private Customer Yash;
	
	
	

}
