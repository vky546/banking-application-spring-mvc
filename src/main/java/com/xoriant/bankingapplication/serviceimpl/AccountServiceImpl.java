package com.xoriant.bankingapplication.serviceimpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.AccountDAO;
import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.rm.AccountRowMapper;
import com.xoriant.bankingapplication.rm.TransactionRowMapper;
import com.xoriant.bankingapplication.service.AccountService;

@Service
public class AccountServiceImpl extends BaseDAO implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public Account getBalance(Integer CustomerId) {
		String sql =  "select accountNumber, CustomerId, accountType, accountStatus, currentBalance from "
				+ "account where CustomerId=?";
		Account account = getJdbcTemplate().queryForObject(sql, new AccountRowMapper(),CustomerId);
		return account;
	}

	@Override
	public List<Transaction> getMiniStatement(Integer CustomerId ) {
		String sql="select transactionId, dateOfTransaction, fromAccount, toAcount, amount, currentBalance, transactionStatus from "
				+ "transaction where fromAccount=?";
		List<Transaction> transaction = getJdbcTemplate().query(sql, new TransactionRowMapper(),CustomerId);
		return  transaction;
	}

	@Override
	public void FundTransfer(Integer CustomerId, Integer toAcount, LocalDate dateOfTransaction, Integer amount,  String transactionStatus) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		AccountService accountService = context.getBean(AccountService.class);
		
		Account account  = accountService.getBalance(CustomerId);
		
		Integer newCurrentBalance = account.getCurrentBalance() - amount;
		
		String sql="update account set currentBalance=:currentBalance "
				+ " where CustomerId=:CustomerId";
		Map m = new HashMap();
		
		m.put("currentBalance", newCurrentBalance);
		m.put("CustomerId", CustomerId);
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
		String sql1="insert into transaction(dateOfTransaction,fromAccount,toAcount,amount,currentBalance,"
				+ "transactionStatus) values(:dateOfTransaction,:fromAccount,:toAcount,:amount,:currentBalance,"
				+ ":transactionStatus)";
		
		Map m1 = new HashMap();
		m1.put("dateOfTransaction", dateOfTransaction);
		m1.put("fromAccount", CustomerId);
		m1.put("toAcount", toAcount);
		m1.put("amount", amount);
		m1.put("currentBalance", newCurrentBalance);
		m1.put("transactionStatus", transactionStatus);

		
		getNamedParameterJdbcTemplate().update(sql1, m1);
								
		
		
	}

	@Override
	public void deleteAccount(Integer accountNumber) {
		String sql="update account set accountStatus=:accountStatus where accountNumber=:accountNumber";
		Map m = new HashMap();
		m.put("accountStatus", "inactive");
		m.put("accountNumber", accountNumber);
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public void create(Account account) {
		accountDAO.save(account);
		
	}

	@Override
	public void editAccount(Account account) {
		accountDAO.update(account);
		
	}

	@Override
	public List<Account> getAccountsByCustomerId(Integer CustomerId) {
		String sql="select accountNumber,CustomerId,accountType,accountStatus,balance from account "
				+ "where CustomerId=?";
		try {
			List<Account> accounts = getJdbcTemplate().query(sql, new AccountRowMapper(),CustomerId);
			return accounts;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	

	

}
