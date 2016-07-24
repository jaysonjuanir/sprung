package com.person.dto;

/**
 * Hello world!
 *
 */

import java.text.MessageFormat;
import java.util.Set;
import java.util.Date;
import com.person.model.Gender;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

public class PersonDto extends BaseEntityDto 
{
	
	private NameDto name;
	
	private Gender gender;
	
	private AddressDto address;
	
	private Double person_gwa;
	
	private Date birthday;
	
	private boolean isEmployed;
	
	private Date date_hired;
	
	private Set<ContactDto> contact;
	
	private Set<RolesDto> roles;
	
	
	public PersonDto(){}
	
	public PersonDto( NameDto name, AddressDto personAddress, double gwa, Set<ContactDto> contact, Set<RolesDto> roles, Date birthday, Date date_hired, boolean isEmployed){
		this.name = name;
		address = personAddress;
		person_gwa=gwa;
		this.contact=contact;
		this.roles=roles;
		this.birthday=birthday;
		this.date_hired=date_hired;
		this.isEmployed=isEmployed;
	}
	
	
	public void setName(NameDto name){
		this.name=name;
	}
	public NameDto getName(){
		return this.name;
	}
	
	public Gender getGender(){
		return gender;
	}
	public void setGender(Gender gender){
		this.gender=gender;
	}
	public void setAddress(AddressDto address){
		this.address=address;
	}
	public AddressDto getAddress(){
		return this.address;
	}
	
	public void setPerson_GWA(Double gwa){
		person_gwa=gwa;
	}
	public Double getPerson_GWA(){
		return person_gwa;
	}
	
	public void setPerson_contact(Set<ContactDto> contact){
		this.contact=contact;
	}
	public Set<ContactDto> getPerson_contact(){
		return contact;
	}
	
	public void setRoles(Set<RolesDto> roles){
		this.roles=roles;	
	}
	public Set<RolesDto> getRoles(){
		return roles;
	}
	public Date getBirthday(){
		return this.birthday;
	}
	
	
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	public Date getDate_hired(){
		return this.date_hired;
	}
	
	public void setDate_hired(Date date_hired){
		this.date_hired = date_hired;
	}
	
	
	public void setEmployed(boolean employed){
		isEmployed=employed;
	}
	public boolean getEmployed(){
		return isEmployed;
	}
	
	@Override
	public String toString(){
		return MessageFormat.format("{0} Name: {1}\n\tAddress: {2} Gender: {7}\n\tGWA:{3} \n\tBirthday: {4}\n\tEmployed: {5}\tDate Hired: {6}", this.id, this.name, this.address, this.person_gwa, this.birthday, this.isEmployed, this.date_hired, gender);
	}
}
