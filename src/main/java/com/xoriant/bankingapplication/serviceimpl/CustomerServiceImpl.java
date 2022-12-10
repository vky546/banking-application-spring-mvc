package com.xoriant.bankingapplication.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.rm.CustomerRowMapper;
import com.xoriant.bankingapplication.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseDAO implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public Customer login(String loginName, String password) {
		String sql="select customerId,loginName,password,personId,managerId from customer where"
				+ " loginName=:loginName and password=:password";
		Map m = new HashMap();
		m.put("loginName", loginName);
		m.put("password", password);
		try {
			Customer customer = getNamedParameterJdbcTemplate().queryForObject(sql,m, new CustomerRowMapper());
			System.out.println(customer);
			return customer;
			
		} catch (EmptyResultDataAccessException ex) {
			return null;
			
		}
	}

	@Override
	public void logout() {
		
		
	}

	@Override
	public void changePassword(Integer CustomerId, String password) {
		String sql="update customer set password=:password "
				+ " where CustomerId=:CustomerId";
		Map m = new HashMap();
		
		m.put("password", password);
		
		
		m.put("CustomerId", CustomerId);
		getNamedParameterJdbcTemplate().update(sql, m);
		
		
		
		
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
		
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		String sql="update customer set loginName=:loginName,password=:password,"
				+ "ManagerId=:ManagerId where CustomerId=:CustomerId";
		Map m=new HashMap();
		m.put("loginName", 0);
		m.put("password", 0);
		m.put("ManagerId", 0);
		m.put("CustomerId", customerId);
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public Customer getCustomerByCustomerId(Integer CustomerId) {
		return customerDAO.findById(CustomerId);
	}

	@Override
	public void editCustomer(Customer customer) {
		customerDAO.update(customer);
		
	}

	@Override
	public List<Customer> getByManagerId(Integer ManagerId) {
		String sql="select CustomerId,loginName,password,personId,ManagerId from customer where"
				+ " ManagerId=? ";
		try {
			List<Customer> customers = getJdbcTemplate().query(sql, new CustomerRowMapper(),ManagerId);
			 System.out.println(customers);
			 return customers;	
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	

}
