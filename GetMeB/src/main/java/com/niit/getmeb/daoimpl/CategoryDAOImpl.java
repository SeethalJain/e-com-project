package com.niit.getmeb.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.getmeb.dao.CategoryDAO;
import com.niit.getmeb.domain.Category;
@Component
@Repository("categoryDAO")											//to create a singleton instance 
@Transactional														//to create connection
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	//user defined constructor with one argument

	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	//save mtd creates record in User table
	
	
	public boolean save(Category category) {
	try{
		sessionFactory.getCurrentSession().save(category);		//getCurrentSession will establish connection to existing DB 
	}
	catch(Exception e){
		e.printStackTrace();								//printStackTrace will print all the exceptions.
		return false;
	}
	return true;
	}


	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		}
	
	
	@SuppressWarnings("unchecked")
	
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	public boolean delete(String id){
		try{
			sessionFactory.getCurrentSession().delete(getCategoryById(id));
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		}
	public Category getCategoryById(String id){															//get method will return object
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);			//return(User)-->typecast the User into object
	}
	
	public Category getCategoryByName(String name){
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult();
	}
}
