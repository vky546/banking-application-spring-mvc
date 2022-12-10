package com.xoriant.bankingapplication.test;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.dao.PersonDAO;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Person;

public class PersonSaveTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	     PersonDAO personDAO = context.getBean(PersonDAO.class);
	     Person person=new Person();
	     person.setName("yash");
	     person.setPhone("7444438465");
	     person.setEmail("yash@gmail.com");
	     person.setDateOfBirth(LocalDate.of( 1998 , 5 , 1 ));
	     person.setGender(Gender.male);
	     person.setAddressId(2);
	     personDAO.save(person);
		System.out.println("person save sucessfully");
	}

}
