package com.xoriant.bankingapplication.model;

public class Customer {
	private Integer CustomerId;
	private String loginName;
	private String password;
	private Integer personId;
	private Integer managerId;
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", loginName=" + loginName + ", password=" + password
				+ ", personId=" + personId + ", managerId=" + managerId + "]";
	}
	

}
