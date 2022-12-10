package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Manager;


public class ManagerDeleteTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      ManagerDAO managerDAO = context.getBean(ManagerDAO.class);
	      managerDAO.delete(2);
		System.out.println("manager deleted sucessfully");
	}

}
