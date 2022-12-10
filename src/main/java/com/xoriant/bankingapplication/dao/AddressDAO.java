package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.model.Address;

public interface AddressDAO {
	public void  save(Address address);
	public void update(Address address);
	public void delete(Address address);
	public void delete(Integer addressId);
	public Address findById(Integer addressId);
	public List<Address> findAll();
	public List<Address> findByProperty(String propertName, Object propertyValue);

}
