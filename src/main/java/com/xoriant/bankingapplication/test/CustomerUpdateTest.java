package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;


public class CustomerUpdateTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
	      Customer customer=new Customer(); 
	      customer.setLoginName("nidhi33");
	      customer.setPassword("nidhi1234");
	      customer.setPersonId(5);
	      customer.setManagerId(1);
	      customer.setCustomerId(1);
	     customerDAO.update(customer);
		System.out.println("customer updated sucessfully");
	}

}
