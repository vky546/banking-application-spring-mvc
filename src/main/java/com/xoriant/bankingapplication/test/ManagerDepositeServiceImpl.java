package com.xoriant.bankingapplication.test;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.service.ManagerService;

public class ManagerDepositeServiceImpl {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ManagerService managerService = context.getBean(ManagerService.class);
		
		managerService.deposit(2, LocalDate.of( 2022 , 03 , 02 ), 1000, "success");
	}

}
