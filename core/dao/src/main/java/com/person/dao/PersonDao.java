package com.person.dao;

/**
 * Hello world!
 *
 */

 
import com.person.util.UtilSession;
import com.person.model.*;
import com.person.dto.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.apache.commons.beanutils.BeanUtils;
import java.util.*;
public interface PersonDao
{
    public void addPerson(PersonDto personDto);
	public List<PersonDto> getPeople();
	public void updatePerson(PersonDto personDto);
	public void deletePerson(PersonDto deleteThisPerson);
	public List<PersonDto> getPersonByLastName();
	public List<PersonDto> getPersonByGWA();
	public List<PersonDto> getPersonByDateHired();
	public PersonDto getPersonById(int id);
	public PersonDto toDto(Person person);
	public void deleteAllContact(int personId);

	public Person toEntity(PersonDto personDto);
	
	public void closeSessionFactory();
}
