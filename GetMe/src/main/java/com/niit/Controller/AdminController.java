package com.niit.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	//SLF4J
	
	private static Logger log = LoggerFactory.getLogger(AdminController.class);	
	
	@RequestMapping("/manageCategory")							//maps to manageCategory link for Admin
	public ModelAndView manageCategory(){
		log.debug("Stating of mtd");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedCategory","true");
		mv.addObject("isAdmin","true");										//to show the category in browser
		log.debug("end of managecategory");
		return mv;
	}

	
		@RequestMapping("/manageSupplier")							//maps to manageSupplier link for Admin
		public ModelAndView manageSupplier(){
			log.debug("start of managesupplier");
			ModelAndView mv = new ModelAndView("Home");
			mv.addObject("isAdminClickedSupplier","true");
			mv.addObject("isAdmin","true");							//to show the category in browser
			log.debug("end of managesupplier");
			return mv;
		}
		
			@RequestMapping("/manageProduct")							//maps to manageProduct link for Admin
			public ModelAndView manageProduct(){
				log.debug("start of manageproduct");
				ModelAndView mv = new ModelAndView("Home");
				mv.addObject("isAdminClickedProduct","true");
				mv.addObject("isAdmin","true");						//to show the category in browser
				log.debug("end of manageproduct");
				return mv;
			}
}
