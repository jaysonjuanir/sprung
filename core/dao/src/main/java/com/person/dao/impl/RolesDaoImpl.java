package com.person.dao.impl;

/**
 * Hello world!
 *
 */

import com.person.util.UtilSession;
import com.person.model.Roles;
import com.person.dao.RolesDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import java.util.ArrayList;
public class RolesDaoImpl implements RolesDao
{
	//UtilSession utilSession;
	SessionFactory factory;
	public RolesDaoImpl(SessionFactory factory){
		this.factory=factory;	
	}
	
	
	//public RolesDao(){
	//	utilSession = new UtilSession();	
	//}
    public void addRole(Roles roles){
		//UtilSession utilSession = new UtilSession();
		Session session;
		session = factory.openSession();
		session.beginTransaction();
		session.save(roles);
		session.getTransaction().commit();
		session.close();
	}
	public List<Roles> getAllRoles(){
		//UtilSession utilSession = new UtilSession();
		Session session;
		session = factory.openSession();
		List<Roles> roles = null;
		try{
			roles = session.createCriteria(Roles.class).addOrder( Order.asc("id") ).setCacheable(true).list();
			//session.close();
			//session.flush();
		}catch(HibernateException hex){
			hex.printStackTrace();
		}finally{
			session.close();
		}
		//session.close();
		return roles;
	}
	public void updateRole(Roles roles){
		Session session;
		session = factory.openSession();
		Transaction transac=null;
		try{
			transac = session.beginTransaction();
			session.update(roles);
			transac.commit();
		}catch(HibernateException hex){
			if(transac!=null)
				transac.rollback();
			hex.printStackTrace();
		}finally{
			session.close();
		}
	}
	public void deleteRole(Roles deleteThisRole){
		Session session;
		session=factory.openSession();
		Transaction transac=null;
		try{
			transac = session.beginTransaction();
			session.delete(deleteThisRole);
			transac.commit();
		}catch(HibernateException hex){
			if(transac!=null)
				transac.rollback();
			hex.printStackTrace();
		}finally{
			session.close();
		}
	}
	public Roles getRoleById(int id){
		Session session;
		session = factory.openSession();
		Roles thisRole = (Roles)session.get(Roles.class, id);
		session.close();
		return thisRole;
	}
	public Roles getRoleByType(String type){
		Session session;
		session = factory.openSession();
		Roles role = null;
		try{
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Roles.class);
			criteria.add(Restrictions.eq("role_type",type));
			role = (Roles)criteria.uniqueResult();
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return role;
	}
	public void closeSessionFactory(){
		UtilSession.closeSessionFactory();
	}
}
