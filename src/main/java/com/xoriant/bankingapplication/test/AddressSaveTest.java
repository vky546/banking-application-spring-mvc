package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.model.Address;

public class AddressSaveTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		AddressDAO addressDAO=context.getBean(AddressDAO.class);
		Address address=new Address();
		address.setFlatNumber(22);
		address.setStreet("LIG");
		address.setCity("Indore");
		address.setState("MP");
		address.setPIN(485621);
		addressDAO.save(address);
		System.out.println("address save sucessfully");
	}

}
