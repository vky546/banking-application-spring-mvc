package com.xoriant.bankingapplication.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.AccountStatus;
import com.xoriant.bankingapplication.model.AccountType;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account=new Account();
		account.setAccountNumber(rs.getInt("accountNumber"));
		account.setAccountStatus(AccountStatus.valueOf(rs.getString("accountStatus")));
		account.setAccountType(AccountType.valueOf(rs.getString("accountType")));
		account.setCurrentBalance(rs.getInt("currentBalance"));
		account.setCustomerId(rs.getInt("customerId"));
		return account;
	}

}
