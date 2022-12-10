package com.xoriant.bankingapplication.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class BaseDAO extends NamedParameterJdbcDaoSupport {
	
	@Autowired
	public void setDataSource1(DataSource ds)
	{
		super.setDataSource(ds);
	}

}
