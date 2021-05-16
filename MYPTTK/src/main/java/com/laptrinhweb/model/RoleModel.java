package com.laptrinhweb.model;

import java.sql.Timestamp;

public class RoleModel extends abstractModel<RoleModel> {

	private String code;
	private String name;

	public RoleModel() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoleModel [code=" + code + ", name=" + name + "]";
	}

}
