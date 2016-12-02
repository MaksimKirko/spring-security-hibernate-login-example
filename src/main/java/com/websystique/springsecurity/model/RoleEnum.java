package com.websystique.springsecurity.model;

public enum RoleEnum {
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String roleEnum;
	
	private RoleEnum(String roleEnum){
		this.roleEnum = roleEnum;
	}
	
	public String getRoleEnum(){
		return roleEnum;
	}
	
}
