package com.person.dto;

/**
 * Hello world!
 *
 */

import java.text.MessageFormat;

public class RolesDto extends BaseEntityDto
{
	
	private String role_type;
	
	public RolesDto(){}
	
	public RolesDto(String type){
		role_type=type;
	}
	
	
	public void setRole_type(String type){
		role_type=type;
	}
	public String getRole_type(){
		return role_type;
	}
	@Override
	public String toString(){
		return MessageFormat.format("\tID: {0} Roles: {1} ", this.id, this.role_type);
	}
}
