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
import com.xoriant.bankingapplication.dao.ManagerDAO;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.rm.ManagerRowMapper;

@Repository
public class ManagerDAOImpl extends BaseDAO implements ManagerDAO{

	@Override
	public void save(Manager manager) {
		String sql="insert into manager (loginName,password,managerpersonId) values "
				+ "(:loginName,:password,:managerpersonId)";
		Map m=new HashMap();
		m.put("loginName", manager.getLoginName());
		m.put("password", manager.getPassword());
		m.put("managerpersonId", manager.getManagerpersonId());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
		manager.setManagerId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(Manager manager) {
		String sql="update manager set loginName=:loginName,password=:password,"
				+ "managerpersonId=:managerpersonId where ManagerId=:ManagerId";
		Map m=new HashMap();
		m.put("loginName", manager.getLoginName());
		m.put("password", manager.getPassword());
		m.put("managerpersonId", manager.getManagerpersonId());
		m.put("ManagerId", manager.getManagerId());
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public void delete(Manager manager) {
		this.delete(manager.getManagerId());
		
	}

	@Override
	public void delete(Integer ManagerId) {
	String sql="delete from manager where ManagerId=?";
	getJdbcTemplate().update(sql,ManagerId);
		
	}

	@Override
	public Manager findById(Integer ManagerId) {
		String sql="select ManagerId,loginName,password,managerpersonId from manager where "
				+ "ManagerId=?";
		Manager manager = getJdbcTemplate().queryForObject(sql, new ManagerRowMapper(), ManagerId);
		return manager;
	}

	@Override
	public List<Manager> findAll() {
		String sql="select ManagerId,loginName,password,managerpersonId from manager";
		List<Manager> managers = getJdbcTemplate().query(sql, new ManagerRowMapper());
		return managers;
	}

	@Override
	public List<Manager> findByProperty(String propertName, Object propertyValue) {
		String sql="select ManagerId,loginName,password,managerpersonId from manager where "
				+propertName+" =?";
		List<Manager> managers = getJdbcTemplate().query(sql, new ManagerRowMapper(), propertyValue);
		return managers;
	}

}
