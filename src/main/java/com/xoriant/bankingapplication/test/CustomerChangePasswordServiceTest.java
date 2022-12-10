package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.service.CustomerService;

public class CustomerChangePasswordServiceTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      CustomerService customerService = context.getBean(CustomerService.class);
//	      Customer customer=new Customer(); 
	      
//	      customer.setPassword("nidhi12");
//	      
//	      customer.setCustomerId(3);
	     customerService.changePassword(3, "nidhi123");
		System.out.println("customer updated sucessfully");
	}

}
