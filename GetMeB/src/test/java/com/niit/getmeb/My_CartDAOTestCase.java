package com.niit.getmeb;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.getmeb.dao.My_CartDAO;
import com.niit.getmeb.domain.My_Cart;

public class My_CartDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;		//ACAC is used to configure Db using Annotations
	
	@Autowired static My_CartDAO my_CartDAO;
	
	@Autowired static My_Cart my_Cart;
	
	//initialize the above methods
	
	@BeforeClass
	
	public static void initialize(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get my_cartdao from context
		my_CartDAO=(My_CartDAO) context.getBean("my_CartDAO");
		
		//get my_cart from context
		my_Cart=(My_Cart) context.getBean("my_Cart");
		}
	
	//TestCAses
	
	@Test
	public void createMy_CartTestCase(){
		my_Cart.setId("10911");
		my_Cart.setUser_id("aaa");
		my_Cart.setUser_name("ssdj");
		my_Cart.setProduct_name("9924569");
		my_Cart.setPrice(9924);
		my_Cart.setQuantity(5);
		boolean flag=my_CartDAO.save(my_Cart);
		assertEquals("createMy_CartTestCase",true,flag);
		
	}

}
