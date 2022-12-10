package com.xoriant.bankingapplication.model;

public class Manager {
	private Integer ManagerId;
	private String loginName;
	private String password;
	private Integer managerpersonId;
	public Integer getManagerId() {
		return ManagerId;
	}
	public void setManagerId(Integer managerId) {
		ManagerId = managerId;
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
	public Integer getManagerpersonId() {
		return managerpersonId;
	}
	public void setManagerpersonId(Integer managerpersonId) {
		this.managerpersonId = managerpersonId;
	}
	@Override
	public String toString() {
		return "Manager [ManagerId=" + ManagerId + ", loginName=" + loginName + ", password=" + password
				+ ", managerpersonId=" + managerpersonId + "]";
	}
	

}
