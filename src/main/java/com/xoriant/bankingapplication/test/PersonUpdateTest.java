package com.xoriant.bankingapplication.test;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.dao.PersonDAO;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Person;

public class PersonUpdateTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	     PersonDAO personDAO = context.getBean(PersonDAO.class);
	     Person person=new Person();
	     person.setName("nandu");
	     person.setPhone("78484543262");
	     person.setEmail("nandu@gmail.com");
	     LocalDate localDate = LocalDate.of( 2019 , 4 , 12 );
	     person.setDateOfBirth(localDate);
	     person.setGender(Gender.male);
	     person.setAddressId(1);
	     person.setPersonId(2);
	     personDAO.update(person);;
		System.out.println("person updated sucessfully");
	}

}
