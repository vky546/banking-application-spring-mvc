package com.xoriant.bankingapplication.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person=new Person();
		person.setPersonId(rs.getInt("personId"));
		person.setAddressId(rs.getInt("addressId"));
		person.setPhone(rs.getString("phone"));
		person.setName(rs.getString("name"));
		person.setEmail(rs.getString("email"));
		person.setGender(Gender.valueOf(rs.getString("gender")));
		person.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
		return person;
	}

}
