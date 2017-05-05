package com.niit.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.getmeb.dao.CategoryDAO;
import com.niit.getmeb.dao.UserDAO;
import com.niit.getmeb.domain.Category;
import com.niit.getmeb.domain.User;

@Controller

public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired UserDAO userDAO;
	@Autowired User user;
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	
	//get user id and pwd from login page & send it to userDao validate
	@RequestMapping(value="validate",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username")String id, @RequestParam(value="password")String password){		
		log.debug("Starting of the method login");
		log.info("You are login with the id "+id);
		ModelAndView mv=new ModelAndView("/Home");
		if(userDAO.validate(id,password)==true)
		{
			log.debug("valid credentials");
			user=userDAO.get(id);
			mv.addObject("msg","welcome" +user.getName());
			mv.addObject("categoryList",categoryDAO.list());
			mv.addObject("category",category);
	
		//to check whether user is admin or not
		if(user.getRole().equals("ROLE_ADMIN")){
			log.debug("you are admin");
			mv.addObject("isAdmin","true");
		}
		else{
			log.debug("you are customer");
			mv.addObject("isAdmin","false");
		}
	}
		else{
			log.debug("invalid user");
			mv.addObject("msg","InvalidCredentials...please try again...");
		}
		log.debug("Ending of the method login");
				return mv;
	}
	
}
