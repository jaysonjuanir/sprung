package com.person.service;

/**
 * Hello world!
 *
 */

import com.person.dao.PersonDao;
import com.person.model.Person;

import com.person.dao.RolesDao;
import com.person.model.Roles;

import com.person.model.Address;
import com.person.model.Name;

import com.person.model.Contact;
import com.person.model.ContactType;

import com.person.dto.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.person.util.UtilSession;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import java.util.Date;
public interface Service
{	
	public void printAllPeople(List<PersonDto> people);
	
	//Person newPerson = new Person("a", "b", "c", "d", "e");
	public void executeCreatePerson(PersonDto newPerson);
	public void executeUpdatedPerson(PersonDto updatedPerson);
	public void deletePerson(PersonDto deletePerson);
	public PersonDto toDto(Person person);
	public Person toEntity(PersonDto personDto);
	public PersonDto getPersonById(int personId);
	public List<PersonDto> getPersonByLastName();
	public List<PersonDto> getPersonByGWA();
	public List<PersonDto> getPersonByDateHired();
	public List<PersonDto> getPeople();
	public boolean checkRequired(String firstName, String middleName, String lastName, String streetNumber, String barangay, String city, String zipcode);
	public boolean checkDate(String date);
	public boolean checkEmployed(String dateHired, String [] roles);
	public boolean checkDecimal(String dec);
	public Date convertDate(String date)throws Exception;
	public PersonDto createPerson(String personId, String firstName, String middleName, String lastName, String suffix, String title, String gender, String birthday, String employed, String dateHired, String gwa, String [] roles, String streetNumber, String barangay, String city, String zipcode, String [] type, String emailValue, String mobileValue, String landlineValue, String emailId, String mobileId, String landlineId);
	//-----------------------------ROLES--------------------------------------------------------
	
	public void printAllRoles();
	public List<Roles> getAllRoles();
	public Roles getRoleById(int roleId);
	public RolesDto getRoleByType(String type);
	public void executeCreateRole(Roles newRole);
	public void executeUpdatedRole(Roles updatedRole);
	public Roles updateRole(Roles tbUpdateRole, String type);
	public void deleteRole(Roles deleteRole);
	public void endProgram();
}
