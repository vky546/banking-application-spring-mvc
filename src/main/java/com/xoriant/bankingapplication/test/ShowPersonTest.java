package com.xoriant.bankingapplication.test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.dao.PersonDAO;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Person;

public class ShowPersonTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
	     PersonDAO personDAO = context.getBean(PersonDAO.class);
//	    Person person = personDAO.findById(2);
//	    System.out.println(person);
//		List<Person> persons = personDAO.findByProperty("gender", "male");
	     
	     List<Person> persons = personDAO.findAll();
		for (Person person : persons) {
			System.out.println(person);
		}
		
	}

}
