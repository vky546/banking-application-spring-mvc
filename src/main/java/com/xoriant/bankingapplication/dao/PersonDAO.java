package com.xoriant.bankingapplication.dao;

import java.util.List;
import com.xoriant.bankingapplication.model.Person;

public interface PersonDAO {
	public void  save(Person person);
	public void update(Person person);
	public void delete(Person person);
	public void delete(Integer personId);
	public Person findById(Integer personId);
	public List<Person> findAll();
	public List<Person> findByProperty(String propertName, Object propertyValue);

}
