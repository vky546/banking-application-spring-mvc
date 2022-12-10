package com.xoriant.bankingapplication.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xoriant.bankingapplication.dao.AccountDAO;
import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.rm.AccountRowMapper;

@Repository
public class AccountDAOImpl extends BaseDAO implements AccountDAO {

	@Override
	public void save(Account account) {
		String sql="insert into account (CustomerId,accountType,accountStatus,currentBalance) values"
				+ "(:CustomerId,:accountType,:accountStatus,:currentBalance)";
		Map m = new HashMap();
		m.put("CustomerId", account.getCustomerId());
		m.put("accountType", account.getAccountType().name());
		m.put("accountStatus", account.getAccountStatus().name());
		m.put("currentBalance", account.getCurrentBalance());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
		account.setAccountNumber(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(Account account) {
		String sql="update account set CustomerId=:CustomerId,accountType=:accountType,"
				+ "accountStatus=:accountStatus,currentBalance=:currentBalance where accountNumber=:accountNumber";
		Map m = new HashMap();
		m.put("CustomerId", account.getCustomerId());
		m.put("accountType", account.getAccountType().name());
		m.put("accountStatus", account.getAccountStatus().name());
		m.put("currentBalance", account.getCurrentBalance());
		m.put("accountNumber", account.getAccountNumber());
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public void delete(Account account) {
		this.delete(account.getAccountNumber());
		
	}

	@Override
	public void delete(Integer accountNumber) {
		String sql="delete from account where accountNumber=?";
		getJdbcTemplate().update(sql,accountNumber);
		
	}

	@Override
	public Account findById(Integer accountNumber) {
		String sql="select accountNumber,CustomerId,accountType,accountStatus,currentBalance from account "
				+ "where accountNumber=?";
		Account account = getJdbcTemplate().queryForObject(sql, new AccountRowMapper(),accountNumber);
		return account;
	}

	@Override
	public List<Account> findAll() {
		String sql="select accountNumber,CustomerId,accountType,accountStatus,currentBalance from account";
		List<Account> accounts = getJdbcTemplate().query(sql, new AccountRowMapper());
		return accounts;
	}

	@Override
	public List<Account> findByProperty(String propertName, Object propertyValue) {
		String sql="select accountNumber,CustomerId,accountType,accountStatus,currentBalance from account "
				+ "where "+propertName+" =?";
		List<Account> accounts = getJdbcTemplate().query(sql, new AccountRowMapper(),propertyValue);
		return accounts;
	}

}
