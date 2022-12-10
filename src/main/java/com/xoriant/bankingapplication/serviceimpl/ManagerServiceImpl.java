package com.xoriant.bankingapplication.serviceimpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.xoriant.bankingapplication.config.SpringRootConfig;
import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.rm.CustomerRowMapper;
import com.xoriant.bankingapplication.rm.ManagerRowMapper;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.service.ManagerService;

@Service
public  class ManagerServiceImpl extends BaseDAO implements ManagerService {

	@Autowired
	private ManagerDAO managerDAO;
	
	@Override
	public Manager login(String loginName, String password) {
		String sql="select managerId,loginName,password,managerpersonId from manager where"
				+ " loginName=:loginName and password=:password";
		Map m = new HashMap();
		m.put("loginName", loginName);
		m.put("password", password);
		try {
		Manager manager = getNamedParameterJdbcTemplate().queryForObject(sql,m, new ManagerRowMapper());
			return manager;
			
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public void logout() {
	
		
	}

	@Override
	public void changePassword(Integer ManagerId, String password) {
		String sql="update manager set password=:password "
				+ " where ManagerId=:ManagerId";
		Map m = new HashMap();
		
		m.put("password", password);
		
		
		m.put("ManagerId", ManagerId);
		getNamedParameterJdbcTemplate().update(sql, m);
		
		
	}

	@Override
	public void newCustomer(Customer customer) {
		String sql="insert into customer (loginName,password,personId,ManagerId) values "
				+ "(:loginName,:password,:personId,:ManagerId)";
		Map m=new HashMap();
		m.put("loginName", customer.getLoginName());
		m.put("password", customer.getPassword());
		m.put("personId", customer.getPersonId());
		m.put("ManagerId", customer.getManagerId());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
		customer.setCustomerId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void editCustomer(String propertyToBeChange, Object propertyToBeChangeValue, String propertName, Object propertyValue) {
		String sql="Update Customer set" +propertyToBeChange+" = :propertyToBeChangeValue where "
				+propertName+" =:propertyValue";
		Map m = new HashMap();
		
		m.put("propertyToBeChange", propertyToBeChangeValue);
		
		
		m.put("propertName", propertyValue);
		getNamedParameterJdbcTemplate().update(sql, m);
		
		
	}

	@Override
	public void deposit(Integer CustomerId, LocalDate dateOfTransaction, Integer amount, String transactionStatus) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		AccountService accountService = context.getBean(AccountService.class);
		
		Account account  = accountService.getBalance(CustomerId);
		
		Integer newCurrentBalance = account.getCurrentBalance() + amount;
		
		String sql="update account set currentBalance=:currentBalance "
				+ " where CustomerId=:CustomerId";
		Map m = new HashMap();
		
		m.put("currentBalance", newCurrentBalance);
		m.put("CustomerId", CustomerId);
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
		String sql1 ="insert into transaction(dateOfTransaction,fromAccount,amount,currentBalance,"
				+ "transactionStatus) values(:dateOfTransaction,:fromAccount,:amount,:currentBalance,"
				+ ":transactionStatus)";
		
		Map m1 = new HashMap();
		m1.put("dateOfTransaction", dateOfTransaction);
		m1.put("fromAccount", CustomerId);
		
		m1.put("amount", amount);
		m1.put("currentBalance", newCurrentBalance);
		m1.put("transactionStatus", transactionStatus);

		
		getNamedParameterJdbcTemplate().update(sql1, m1);
								
	}

	

	
}
