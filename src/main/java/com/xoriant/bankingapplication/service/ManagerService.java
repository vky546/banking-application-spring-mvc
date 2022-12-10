package com.xoriant.bankingapplication.service;

import java.time.LocalDate;

import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;

public interface ManagerService {

	public Manager login(String loginName,String password);
	public void logout();
	public void changePassword(Integer ManagerId, String password);
	public void newCustomer(Customer customer);
	public void deposit(Integer CustomerId, LocalDate dateOfTransaction,Integer amount, String transactionStatus);
	public void editCustomer(String propertyToBeChange, Object propertyToBeChangeValue, String propertName, Object propertyValue);
}
