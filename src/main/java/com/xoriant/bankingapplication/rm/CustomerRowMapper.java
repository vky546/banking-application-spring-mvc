package com.xoriant.bankingapplication.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.bankingapplication.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer=new Customer();
		customer.setCustomerId(rs.getInt("customerId"));
		customer.setLoginName(rs.getString("loginName"));
		customer.setManagerId(rs.getInt("managerId"));
		customer.setPassword(rs.getString("password"));
		customer.setPersonId(rs.getInt("personId"));
		return customer;
	}

}
