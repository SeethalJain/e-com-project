package com.niit.getmeb.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.getmeb.dao.ProductDAO;
import com.niit.getmeb.domain.Product;
@Component
@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	//user defined constructor with one argument

	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	//save mtd creates record in User table
	//
	
	public boolean save(Product product) {
	try{
		sessionFactory.getCurrentSession().save(product);		//getCurrentSession will establish connection to existing DB 
	}
	catch(Exception e){
		e.printStackTrace();								//printStackTrace will print all the exceptions.
		return false;
	}
	return true;
	}


	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		}
	
	
	@SuppressWarnings("unchecked")
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	
	public Product get(String id){															//get method will return object
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);			//return(User)-->typecast the User into object
		
	}

	
}
