package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.service.ManagerService;

public class ManagerChangePasswordServiceTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		  ManagerService managerService = context.getBean(ManagerService.class);
//	      Manager manager=new Manager();
//	     
//	      manager.setPassword("vinay123");
//	     
//	      manager.setManagerId(2);
	     managerService.changePassword(2, "vinay12");;
		System.out.println("manager updated sucessfully");
	}

}
