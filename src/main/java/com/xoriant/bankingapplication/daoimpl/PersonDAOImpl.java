package com.xoriant.bankingapplication.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xoriant.bankingapplication.dao.BaseDAO;
import com.xoriant.bankingapplication.dao.PersonDAO;
import com.xoriant.bankingapplication.model.Person;
import com.xoriant.bankingapplication.rm.PersonRowMapper;

@Repository
public class PersonDAOImpl extends BaseDAO implements PersonDAO {

	@Override
	public void save(Person person) {
		String sql="insert into person (name,gender,dateOfBirth,phone,email,addressId)"
				+ " values(:name,:gender,:dateOfBirth,:phone,:email,:addressId)";
		Map m=new HashMap();
		m.put("name", person.getName());
		m.put("gender", person.getGender().name());
		m.put("dateOfBirth", person.getDateOfBirth());
		m.put("phone", person.getPhone());
		m.put("email", person.getEmail());
		m.put("addressId", person.getAddressId());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
		person.setPersonId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(Person person) {
		String sql="update person set name=:name,gender=:gender,dateOfBirth=:dateOfBirth,"
				+ "phone=:phone,email=:email,addressId=:addressId where personId=:personId";
		
		Map m=new HashMap();
		m.put("name", person.getName());
		m.put("gender", person.getGender().name());
		m.put("dateOfBirth", person.getDateOfBirth());
		m.put("phone", person.getPhone());
		m.put("email", person.getEmail());
		m.put("addressId", person.getAddressId());
		m.put("personId",person.getPersonId());
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
		
	}

	@Override
	public void delete(Person person) {
		this.delete(person.getPersonId());
		
	}

	@Override
	public void delete(Integer personId) {
		String sql="delete from person where personId=?";
		getJdbcTemplate().update(sql,personId);
		
	}

	@Override
	public Person findById(Integer personId) {
		String sql="select personId,name,gender,dateOfBirth,phone,email,addressId from person "
				+ "where personId=?";
		Person person = getJdbcTemplate().queryForObject(sql, new PersonRowMapper(),personId);
		return person;
	}

	@Override
	public List<Person> findAll() {
		String sql="select personId,name,gender,dateOfBirth,phone,email,addressId from person";
		List<Person> persons = getJdbcTemplate().query(sql, new PersonRowMapper());
		return persons;
	}

	@Override
	public List<Person> findByProperty(String propertName, Object propertyValue) {
		String sql="select personId,name,gender,dateOfBirth,phone,email,addressId from person "
				+ "where "+propertName+" =?";
		List<Person> persons = getJdbcTemplate().query(sql, new PersonRowMapper(),propertyValue);
		return persons;
	}

}
