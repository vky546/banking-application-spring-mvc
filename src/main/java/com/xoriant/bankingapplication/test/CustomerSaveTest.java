package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;


public class CustomerSaveTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
	      Customer customer=new Customer(); 
	      customer.setLoginName("nidhi123");
	      customer.setPassword("nidhi123");
	      customer.setPersonId(4);
	      customer.setManagerId(2);
	     customerDAO.save(customer);
		System.out.println("customer save sucessfully");
	}

}
