package com.xoriant.bankingapplication.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.bankingapplication.model.Address;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address=new Address();
		address.setAddressId(rs.getInt("addressId"));
		address.setFlatNumber(rs.getInt("flatNumber"));
		address.setStreet(rs.getString("street"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setPIN(rs.getInt("PIN"));
		return address;
	}

}
