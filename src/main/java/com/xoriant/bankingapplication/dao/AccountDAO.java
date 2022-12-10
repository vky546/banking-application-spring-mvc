package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.model.Account;

public interface AccountDAO {
	public void  save(Account account);
	public void update(Account account);
	public void delete(Account account);
	public void delete(Integer accountNumber);
	public Account findById(Integer accountNumber);
	public List<Account> findAll();
	public List<Account> findByProperty(String propertName, Object propertyValue);

}
