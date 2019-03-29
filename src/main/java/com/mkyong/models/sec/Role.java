package com.mkyong.models.sec;

import com.mkyong.models.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
Create By: Ron Rith
Create Date: 1/2/2018
*/
@Entity
@Table(name = "role")
public class Role extends BaseEntity{
	private String role;

	public Role(String role) {
		this.role = role;
	}

	public Role() {
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
