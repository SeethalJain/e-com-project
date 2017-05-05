package com.niit.getmeb;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.getmeb.dao.UserDAO;
import com.niit.getmeb.domain.User;

public class UserDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;		//ACAC is used to configure Db using Annotations
	
	@Autowired static UserDAO userDAO;
	
	@Autowired static User user;
	
	//initialize the above methods
	
	@BeforeClass
	
	public static void initialize(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get userdao from context
		userDAO=(UserDAO) context.getBean("userDAO");
		
		//get user from context
		user=(User) context.getBean("user");
		}
	
	//TestCAses
	
	@Test
	public void createUserTestCase(){
		user.setId("S1001");
		user.setName("SEETHAL");
		user.setPassword("SEETHAL");
		user.setContact(955191);
		user.setRole("ROLE_ADMIN");
		boolean flag=userDAO.save(user);
		assertEquals("createUserTestCase",true,flag);
		
	}
	
	@Test
	public void updateUserTestCase(){
		user.setId("1000");
		user.setName("SJJAIN");
		user.setPassword("sjjain");
		user.setContact(99922);
		boolean flag=userDAO.update(user);
		assertEquals("createUserTestCase",true,flag);
		}
	
	@Test
	public void validateUserTestCase(){
		boolean flag=userDAO.validate("SJJAIN","SJJAIN");
		assertEquals(true,flag);
	}
	
	@Test
	public void getAllUserTestCase(){
		int actualSize=userDAO.list().size();
		assertEquals(7,actualSize);
	}
}
