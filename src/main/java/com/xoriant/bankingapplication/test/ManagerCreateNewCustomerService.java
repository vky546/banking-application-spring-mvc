package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.service.CustomerService;
import com.xoriant.bankingapplication.service.ManagerService;

public class ManagerCreateNewCustomerService {
	
	public static void main(String[] args) {
		
	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	
    ManagerService managerService = context.getBean(ManagerService.class);
    Customer customer = new Customer(); 
    customer.setLoginName("yash12");
    customer.setPassword("yash123");
    customer.setPersonId(6);
    customer.setManagerId(2);
    managerService.newCustomer(customer);
	System.out.println("customer save sucessfully");
	}
}
