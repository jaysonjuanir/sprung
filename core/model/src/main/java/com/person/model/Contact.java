package com.person.model;

import com.person.model.Person;
import java.text.MessageFormat;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "contact")
public class Contact extends BaseEntity{
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="contact_type")
	private ContactType contact_type;
	
	@Column(name="contact_value")
	private String contact_value;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	public Contact(){}

	public Contact(ContactType contact_type, String contact_value, Person person){
		this.contact_type = contact_type;
		this.contact_value = contact_value;
		this.person = person;
	}
	
	public ContactType getContact_type(){
		return contact_type;
	}

	public void setContact_type(ContactType type){
		this.contact_type = type;
	}
	public String getContact_value(){
		return contact_value;
	}

	public void setContact_value(String value){
		this.contact_value = value;
	}
	public Person getContact_person(){
		return person;
	}
	public void setContact_person(Person person){
		this.person=person;
	}
	public String toString(){
		return MessageFormat.format("\tContacts: {0} = {1} ", this.contact_type, this.contact_value);
	}
}
