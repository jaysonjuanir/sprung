package com.person.dto;

import java.text.MessageFormat;
import com.person.model.ContactType;

public class ContactDto extends BaseEntityDto{
	
	private ContactType contact_type;
	private PersonDto person;
	private String contact_value;
	public ContactDto(){}

	public ContactDto(ContactType contact_type, String contact_value, PersonDto person){
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
	public PersonDto getContact_person(){
		return person;
	}
	public void setContact_person(PersonDto person){
		this.person=person;
	}
	public String toString(){
		return MessageFormat.format("{2} {0} = {1} ", this.contact_type, this.contact_value, this.person);
	}
}
