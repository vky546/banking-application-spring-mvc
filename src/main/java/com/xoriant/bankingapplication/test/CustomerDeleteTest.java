package com.xoriant.bankingapplication.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;


public class CustomerDeleteTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
	      customerDAO.delete(2);
	      System.out.println("customer deleted successfully");
	}

}
