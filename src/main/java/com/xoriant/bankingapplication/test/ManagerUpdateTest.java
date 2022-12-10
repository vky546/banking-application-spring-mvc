package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Manager;


public class ManagerUpdateTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      ManagerDAO managerDAO = context.getBean(ManagerDAO.class);
	      Manager manager=new Manager();
	      manager.setLoginName("vk11");
	      manager.setPassword("vk11");
	      manager.setManagerpersonId(3);
	      manager.setManagerId(2);
	     managerDAO.update(manager);;
		System.out.println("manager updated sucessfully");
	}

}
