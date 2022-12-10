package com.xoriant.bankingapplication.model;

public class Address {
	private Integer addressId;
	private Integer flatNumber;
	private String street;
	private String city;
	private String state;
	private Integer PIN;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(Integer flatNumber) {
		this.flatNumber = flatNumber;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPIN() {
		return PIN;
	}
	public void setPIN(Integer pIN) {
		PIN = pIN;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNumber=" + flatNumber + ", street=" + street + ", city="
				+ city + ", state=" + state + ", PIN=" + PIN + "]";
	}
	
	

}
