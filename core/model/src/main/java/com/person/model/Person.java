package com.person.model;

/**
 * Hello world!
 *
 */

import java.text.MessageFormat;
import java.util.Set;
import java.util.Date;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="person")
@Table(name="person")
public class Person extends BaseEntity 
{
	
	
	@Embedded
	private Name name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Embedded
	private Address address;
	
	@Column(name = "gwa")
	private Double person_gwa;
	
	@Column(name = "person_birthday")
	private Date birthday;
	
	@Column(name = "person_employed")
	private boolean isEmployed;
	
	
	@Column(name = "person_date_hired")
	private Date date_hired;
	
	@OneToMany(targetEntity = Contact.class, fetch = FetchType.LAZY, mappedBy = "person", cascade = {CascadeType.ALL})
	//@Cascade(CascadeType.)
	private Set<Contact> contact;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "personrole", joinColumns = {
			@JoinColumn(name = "person_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id", 
					nullable = false, updatable = false) })
	private Set<Roles> roles;
	
	
	public Person(){}
	
	public Person( Name name, Address personAddress, double gwa, Set<Contact> contact, Set<Roles> roles, Date birthday, Date date_hired, boolean isEmployed){
		this.name = name;
		address = personAddress;
		person_gwa=gwa;
		this.contact=contact;
		this.roles=roles;
		this.birthday=birthday;
		this.date_hired=date_hired;
		this.isEmployed=isEmployed;
	}
	
	
	public void setName(Name name){
		this.name=name;
	}
	public Name getName(){
		return this.name;
	}
	
	public Gender getGender(){
		return gender;
	}
	public void setGender(Gender gender){
		this.gender=gender;
	}
	public void setAddress(Address address){
		this.address=address;
	}
	public Address getAddress(){
		return this.address;
	}
	
	public void setPerson_GWA(Double gwa){
		person_gwa=gwa;
	}
	public Double getPerson_GWA(){
		return person_gwa;
	}
	
	public void setPerson_contact(Set<Contact> contact){
		this.contact=contact;
	}
	public Set<Contact> getPerson_contact(){
		return contact;
	}
	
	public void setRoles(Set<Roles> roles){
		this.roles=roles;	
	}
	public Set<Roles> getRoles(){
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
		return MessageFormat.format("{0} Name: {1}\n\tAddress: {2} \n\tGWA:{3} \n\tBirthday: {4}\n\tEmployed: {5}\tDate Hired: {6}", this.id, this.name, this.address, this.person_gwa, this.birthday, this.isEmployed, this.date_hired);
	}
}
