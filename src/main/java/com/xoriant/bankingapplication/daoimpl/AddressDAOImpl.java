package com.xoriant.bankingapplication.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xoriant.bankingapplication.dao.AddressDAO;
import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.rm.AddressRowMapper;

@Repository
public class AddressDAOImpl extends BaseDAO implements AddressDAO {

	public void save(Address address) {
		String sql = "insert into address (flatNumber,street,city,state,PIN) "
				+ "values(:flatNumber,:street,:city,:state,:PIN)";

		Map m = new HashMap();
		m.put("flatNumber", address.getFlatNumber());
		m.put("street", address.getStreet());
		m.put("city", address.getCity());
		m.put("state", address.getState());
		m.put("PIN", address.getPIN());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
		address.setAddressId(keyHolder.getKey().intValue());

	}

	@Override
	public void update(Address address) {
		String sql = "update address " + "set flatNumber=:flatNumber," + "street=:street," + "city=:city,"
				+ "state=:state," + "PIN=:PIN " + "where addressId=:addressId";

		Map m = new HashMap();
		m.put("flatNumber", address.getFlatNumber());
		m.put("street", address.getStreet());
		m.put("city", address.getCity());
		m.put("state", address.getState());
		m.put("PIN", address.getPIN());
		m.put("addressId", address.getAddressId());
		
		getNamedParameterJdbcTemplate().update(sql, m);
		

	}

	@Override
	public void delete(Address address) {

		this.delete(address.getAddressId());

	}

	@Override
	public void delete(Integer addressId) {
		String sql ="delete from address where addressId=?";
		getJdbcTemplate().update(sql,addressId);

	}

	@Override
	public Address findById(Integer addressId) {
		String sql="select addressId,flatNumber,street,city,state,PIN from address where "
				+ "addressId=?";
		Address address = getJdbcTemplate().queryForObject(sql, new AddressRowMapper(), addressId);
		return address;
	}

	@Override
	public List<Address> findAll() {
		String sql="select addressId,flatNumber,street,city,state,PIN from address";
		List<Address> addlist = getJdbcTemplate().query(sql, new AddressRowMapper());
		return addlist;
	}

	@Override
	public List<Address> findByProperty(String propertName, Object propertyValue) {
		String sql="select addressId,flatNumber,street,city,state,PIN from address "
				+ "where "+propertName+" =?";
		List<Address> addresss = getJdbcTemplate().query(sql, new AddressRowMapper(),propertyValue); 
		return addresss;
	}

}
