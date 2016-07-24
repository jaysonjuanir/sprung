package com.person.model;

/**
 * Hello world!
 *
 */

import java.text.MessageFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "roles")
public class Roles extends BaseEntity
{
	
	@Column(name = "role_type")
	private String role_type;
	
	public Roles(){}
	
	public Roles(String type){
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
