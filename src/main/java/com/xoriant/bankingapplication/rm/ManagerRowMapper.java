package com.xoriant.bankingapplication.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.bankingapplication.model.Manager;

public class ManagerRowMapper implements RowMapper<Manager> {

	@Override
	public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
		Manager manager=new Manager();
		manager.setManagerId(rs.getInt("managerId"));
		manager.setLoginName(rs.getString("loginName"));
		manager.setPassword(rs.getString("password"));
		manager.setManagerpersonId(rs.getInt("managerpersonId"));
		return manager;
	}

}
