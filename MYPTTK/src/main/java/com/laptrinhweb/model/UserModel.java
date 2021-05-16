package com.laptrinhweb.model;

import java.sql.Timestamp;

public class UserModel extends abstractModel<UserModel> {
	private String userName;
	private String password;
	private String fullName;
	private int status;
	private Long roleID;
	private RoleModel role = new RoleModel();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public static void main(String[] args) {

	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", password=" + password + ", status=" + status + ", roleID="
				+ roleID + ", role=" + role + "]";
	}
	
}
