package com.niit.getmeb;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.getmeb.dao.CategoryDAO;
import com.niit.getmeb.domain.Category;


public class CategoryDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;		//ACAC is used to configure Db using Annotations
	
	@Autowired static CategoryDAO categoryDAO;
	
	@Autowired static Category category;
	
	//initialize the above methods
	
	@BeforeClass
	
	public static void initialize(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get userdao from context
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
		//get user from context
		category=(Category) context.getBean("category");
		}
	
	//TestCAses
	//@Test
	/*public void createCategoryTestCase(){
		category.setId("1001");
		category.setName("nokia");
		category.setCat_type("mobile");
		boolean flag=categoryDAO.save(category);
		assertEquals("createCategoryTestCase",true,flag);
		}
	*/
	@Test
	public void updateCategoryTestCase(){
		category.setId("1001");
		category.setName("SJJAIN1");
		category.setCat_type("sjjain1");
		boolean flag=categoryDAO.update(category);
		assertEquals("createCategoryTestCase",true,flag);
		}
	
		@Test
		public void getAllCategorTestCase(){
			List<Category> category=categoryDAO.list();
			assertEquals(2,category.size());
		}

}
