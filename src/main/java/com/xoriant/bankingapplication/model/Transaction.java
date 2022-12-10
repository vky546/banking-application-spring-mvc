package com.xoriant.bankingapplication.model;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
	private Integer transactionId;
	private LocalDate dateOfTransaction;
	private Integer fromAccount;
	private Integer toAcount;
	private Integer amount;
	private Integer currentBalance;
	private TransactionStatus transactionStatus;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public Integer getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Integer getToAcount() {
		return toAcount;
	}
	public void setToAcount(Integer toAcount) {
		this.toAcount = toAcount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Integer currentBalance) {
		this.currentBalance = currentBalance;
	}
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", dateOfTransaction=" + dateOfTransaction
				+ ", fromAccount=" + fromAccount + ", toAcount=" + toAcount + ", amount=" + amount + ", currentBalance="
				+ currentBalance + ", transactionStatus=" + transactionStatus + "]";
	}
	

}
