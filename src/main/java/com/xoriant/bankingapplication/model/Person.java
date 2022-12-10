package com.xoriant.bankingapplication.model;

import java.time.LocalDate;

public class Person {

	private Integer personId;
	private Integer addressId;
	private String name;
	private String phone;
	private String email;
	private Gender gender;
	private LocalDate dateOfBirth;
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", addressId=" + addressId + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
