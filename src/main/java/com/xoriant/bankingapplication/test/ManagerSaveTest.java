package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Manager;


public class ManagerSaveTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	      ManagerDAO managerDAO = context.getBean(ManagerDAO.class);
	      Manager manager=new Manager();
	      manager.setLoginName("sunil");
	      manager.setPassword("suunil11");
	      manager.setManagerpersonId(4);
	     managerDAO.save(manager);
		System.out.println("manager save sucessfully");
	}

}
