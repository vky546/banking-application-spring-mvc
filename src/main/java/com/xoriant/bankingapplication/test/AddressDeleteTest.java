package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.model.Address;

public class AddressDeleteTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		AddressDAO addressDAO=context.getBean(AddressDAO.class);
		addressDAO.delete(2);
		
		System.out.println("address deleted sucessfully");
	}

}
