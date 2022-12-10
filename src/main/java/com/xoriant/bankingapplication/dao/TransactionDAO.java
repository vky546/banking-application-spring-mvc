package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.model.Transaction;

public interface TransactionDAO {
	public void  save(Transaction transaction);
	public void update(Transaction transaction);
	public void delete(Transaction transaction);
	public void delete(Integer transactionId);
	public Transaction findById(Integer transactionId);
	public List<Transaction> findAll();
	public List<Transaction> findByProperty(String propertName, Object propertyValue);
}
