package com.xoriant.bankingapplication.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;


public class ShowCustomerTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
//	      List<Customer> customers = customerDAO.findAll();
	     // List<Customer> customers = customerDAO.findByProperty("loginName", "john11");
	      Customer customer = customerDAO.findById(2);
	      System.out.println(customer);
	}

}
