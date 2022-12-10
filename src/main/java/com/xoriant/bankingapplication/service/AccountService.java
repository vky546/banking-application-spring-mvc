package com.xoriant.bankingapplication.service;

import java.time.LocalDate;
import java.util.List;

import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.model.TransactionStatus;

public interface AccountService {
	public Account getBalance(Integer CustomerId);
	public List<Transaction> getMiniStatement(Integer CustomerId);
	public void FundTransfer(Integer CustomerId, Integer toAcount, LocalDate dateOfTransaction,Integer amount, String transactionStatus);
	public void deleteAccount(Integer accountNumber);
	public void create(Account account);
	public void editAccount(Account account);
	public List<Account> getAccountsByCustomerId(Integer customerId);
	
}
