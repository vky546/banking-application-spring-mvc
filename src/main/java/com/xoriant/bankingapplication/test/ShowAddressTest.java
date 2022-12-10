package com.xoriant.bankingapplication.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.model.Address;

public class ShowAddressTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		AddressDAO addressDAO=context.getBean(AddressDAO.class);
	List<Address> list = addressDAO.findAll();
		for (Address address : list) {
			System.out.println(address);		
			}
				
		
	}

}
