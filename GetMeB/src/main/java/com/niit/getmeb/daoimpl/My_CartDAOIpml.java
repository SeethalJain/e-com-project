package com.niit.getmeb.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.getmeb.dao.My_CartDAO;
import com.niit.getmeb.domain.My_Cart;
@Component
@Repository("my_CartDAO")
@Transactional
public class My_CartDAOIpml implements My_CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	//user defined constructor with one argument

	public My_CartDAOIpml(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	//save mtd creates record in User table
	//
	
	public boolean save(My_Cart my_Cart) {
	try{
		sessionFactory.getCurrentSession().save(my_Cart);		//getCurrentSession will establish connection to existing DB 
	}
	catch(Exception e){
		e.printStackTrace();								//printStackTrace will print all the exceptions.
		return false;
	}
	return true;
	}


	public boolean update(My_Cart my_Cart) {
		try{
			sessionFactory.getCurrentSession().update(my_Cart);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		}
	
	
	@SuppressWarnings("unchecked")
	
	public List<My_Cart> list() {
		return sessionFactory.getCurrentSession().createQuery("from My_Cart").list();
	}
	
	
	public My_Cart get(String id){															//get method will return object
		return (My_Cart) sessionFactory.getCurrentSession().get(My_Cart.class, id);			//return(User)-->typecast the User into object
		
	}

	


}
