package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.getmeb.dao.UserDAO;
import com.niit.getmeb.domain.User;

@Controller

public class UserController {
	@Autowired UserDAO userDAO;
	
	@Autowired User user;
	
	//get user id and pwd from login page & send it to userDao validate
	@RequestMapping("validate")
	public ModelAndView login(@RequestParam("username")String id, @RequestParam("password")String password){
		ModelAndView mv=new ModelAndView("/Home");
		if(userDAO.validate(id,password)==true){
			user=userDAO.get(id);
			mv.addObject("msg","welcome" +user.getName());
			mv.addObject("categoryList",categoryDAO.list());
		}
		else{
			mv.addObject("msg","InvalidCredentials...please try again...");
		}
	
		//to check whether user is admin or not
		if(user.getRole().equals("Role_Admin")){
			mv.addObject("isAdmin","true");
		}
		else{
			mv.addObject("isAdmin","false");
		}
				return mv;
	}
	
}
