package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.getmeb.dao.CategoryDAO;
import com.niit.getmeb.domain.Category;

@Controller

public class HomeController {
	
	@Autowired HttpSession session;
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
	@RequestMapping("/")	
	
	public ModelAndView goToHome(){
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("welcome", "thank you");
		
		//get all category
		List <Category> categoryList=categoryDAO.list();
		
		//attAch to session
		session.setAttribute("categoryList",categoryList);
		session.setAttribute("category", category);
		
		return mv;
	}
	
	@RequestMapping("/Login")
	public String login(Model model){
		model.addAttribute("isValidLogin","true");
		return "Home";
	}
	
	@RequestMapping("/Registration")
	public String register(Model model){
		model.addAttribute("isValidRegister","true");
		return "Home";
	}
}
