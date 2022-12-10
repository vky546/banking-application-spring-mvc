package com.xoriant.bankingapplication.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.dao.CustomerDAO;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.rm.CustomerRowMapper;

@Repository
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO{

	@Override
	public void save(Customer customer) {
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
	public void update(Customer customer) {
		String sql="update customer set loginName=:loginName,password=:password,"
				+ "personId=:personId,ManagerId=:ManagerId where CustomerId=:CustomerId";
		Map m=new HashMap();
		m.put("loginName", customer.getLoginName());
		m.put("password", customer.getPassword());
		m.put("personId", customer.getPersonId());
		m.put("ManagerId", customer.getManagerId());
		m.put("CustomerId", customer.getCustomerId());
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public void delete(Customer customer) {
		this.delete(customer.getCustomerId());
		
	}

	@Override
	public void delete(Integer CustomerId) {
		String sql="delete from customer where CustomerId=?";
		getJdbcTemplate().update(sql,CustomerId);
		
	}

	@Override
	public Customer findById(Integer CustomerId) {
		String sql="select CustomerId,loginName,password,personId,managerId from customer where"
				+ " CustomerId=? ";
		Customer customer = getJdbcTemplate().queryForObject(sql, new CustomerRowMapper(),CustomerId);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		String sql="select CustomerId,loginName,password,personId,ManagerId from customer";
		List<Customer> customers = getJdbcTemplate().query(sql, new CustomerRowMapper());
		return customers;
	}

	@Override
	public List<Customer> findByProperty(String propertName, Object propertyValue) {
		String sql="select CustomerId,loginName,password,personId,managerId from customer where "
				+propertName+" =?";
		List<Customer> customers = getJdbcTemplate().query(sql, new CustomerRowMapper(),propertyValue);
		return customers;
	}

}
