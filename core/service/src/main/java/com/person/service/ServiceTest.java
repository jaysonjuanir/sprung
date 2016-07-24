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
public interface ServiceTest
{
	
	public List<Roles> getAllRoles();	
	
}
