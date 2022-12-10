package com.xoriant.bankingapplication.model;

/**
 * This is Account model class which is used as data traveller between different
 * layers
 */
public class Account {
	/**
	 * accountNumer filed is used to uniquely identifiy the account
	 */
	private Integer accountNumber;
	/**
	 * coutomerId field is used as a fk over here
	 */
	
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

	public void setCustomerId(Integer CustomerId) {
		this.CustomerId = CustomerId;
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

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", CustomerId=" + CustomerId + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", currentBalance=" + currentBalance + "]";
	}

}
