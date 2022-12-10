package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.model.Customer;


public interface CustomerDAO {
	public void  save(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	public void delete(Integer CustmomerId);
	public Customer findById(Integer CustomerId);
	public List<Customer> findAll();
	public List<Customer> findByProperty(String propertName, Object propertyValue);

}
