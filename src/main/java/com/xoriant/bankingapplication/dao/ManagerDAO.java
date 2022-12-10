package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.model.Manager;

public interface ManagerDAO {
	public void  save(Manager manager);
	public void update(Manager manager);
	public void delete(Manager manager);
	public void delete(Integer ManagerId);
	public Manager findById(Integer ManagerId);
	public List<Manager> findAll();
	public List<Manager> findByProperty(String propertName, Object propertyValue);
}
