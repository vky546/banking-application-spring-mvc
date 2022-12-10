package com.xoriant.bankingapplication.command;

import java.time.LocalDate;

public class FundTransferCommand {
	private Integer CustomerId;
	private Integer toAcount;
	private LocalDate dateOfTransaction;
	private Integer amount;
	private String transactionStatus;
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}
	public Integer getToAcount() {
		return toAcount;
	}
	public void setToAcount(Integer toAcount) {
		this.toAcount = toAcount;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}
