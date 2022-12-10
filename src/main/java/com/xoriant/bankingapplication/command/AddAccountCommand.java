package com.xoriant.bankingapplication.command;

import com.xoriant.bankingapplication.model.AccountStatus;
import com.xoriant.bankingapplication.model.AccountType;

public class AddAccountCommand {
	private Integer accountNumber;
	private Integer CustomerId;
	private AccountType accountType;
	private AccountStatus accountStatus;
	private Integer currentBalance;

	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Integer getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Integer currentBalance) {
		this.currentBalance = currentBalance;
	}
	


}
