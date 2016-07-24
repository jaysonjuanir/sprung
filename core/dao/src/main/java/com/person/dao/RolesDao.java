package com.person.dao;

/**
 * Hello world!
 *
 */

import com.person.util.UtilSession;
import com.person.model.Roles;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import java.util.ArrayList;
public interface RolesDao
{
    public void addRole(Roles roles);
	public List<Roles> getAllRoles();
	public void updateRole(Roles roles);
	public void deleteRole(Roles deleteThisRole);
	public Roles getRoleById(int id);
	public Roles getRoleByType(String type);
	public void closeSessionFactory();
}
