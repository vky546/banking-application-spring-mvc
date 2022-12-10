package com.xoriant.bankingapplication.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.model.Address;

public class AddressUpadateTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		AddressDAO addressDAO=context.getBean(AddressDAO.class);
		Address address=new Address();
		address.setFlatNumber(77);
		address.setStreet("LIG");
		address.setCity("pune");
		address.setState("MP");
		address.setPIN(596328);
		address.setAddressId(2);
		addressDAO.update(address);
		System.out.println("address updated sucessfully");
	}

}
