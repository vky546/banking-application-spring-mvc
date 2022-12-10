package com.xoriant.bankingapplication.service;

import java.util.List;

import com.xoriant.bankingapplication.model.Customer;

public interface CustomerService {

	public Customer login(String loginName,String password);
	public void logout();
	public void changePassword(Integer CustomerId, String password);
	public List<Customer> getAllCustomers() ;
	public void deleteCustomer(Integer CustomerId);
	public Customer getCustomerByCustomerId(Integer CustomerId);
	public void editCustomer(Customer customer);
	public List<Customer> getByManagerId(Integer ManagerId) ;
}
