package com.xoriant.bankingapplication.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.model.TransactionStatus;

public class TransactionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction=new Transaction();
		transaction.setAmount(rs.getInt("amount"));
		transaction.setCurrentBalance(rs.getInt("currentBalance"));
		transaction.setDateOfTransaction(rs.getDate("dateOfTransaction").toLocalDate());
		transaction.setFromAccount(rs.getInt("fromAccount"));
		transaction.setToAcount(rs.getInt("toAcount"));
		transaction.setTransactionId(rs.getInt("transactionId"));
		transaction.setTransactionStatus(TransactionStatus.valueOf(rs.getString("transactionStatus")));
		return transaction;
	}

}
