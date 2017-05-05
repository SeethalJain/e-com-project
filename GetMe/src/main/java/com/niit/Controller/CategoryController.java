package com.niit.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.getmeb.dao.CategoryDAO;

import com.niit.getmeb.domain.Category;

@Controller

public class CategoryController {
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired(required=true) HttpSession session;
	@Autowired(required=true) CategoryDAO categorydAO;
	@Autowired (required=true)Category category;
	
	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("id")String id,
										@RequestParam("name")String name,								
										@RequestParam("cat_type")String cat_type){				//requestparam is used if we have only few parameters r elz v wl use modal
		log.debug("Starting of the method manageCategories");
		category.setId(id);
		category.setName(name);
		category.setCat_type(cat_type);

		ModelAndView mv = new ModelAndView("forward:/manageCategory");
		
		mv.addObject("isAdminClickedCategory","true");
		mv.addObject("isAdmin","true");
		
		//before creating save mtd,check whether cat id is already existing in db or not
		//if it doesnt exists only then it wll call save mtd
		
		if(categorydAO.getCategoryById(id)!=null){
			mv.addObject("msg","Category already exists in DB"+id);
			return mv;
		}
		else{					
			categorydAO.save(category);
			mv.addObject("msg","Category with id"+id+" is successfully created and stored");
		}
		session.setAttribute("categoryList",categorydAO.list());
		session.setAttribute("category", category);
		log.debug("End of the method manageCategories");
		return mv;
	}
	
	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)				//pathvariable is used when we send value/value with url
	{																	
		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("forward:/manageCategory");
		if(categorydAO.delete(id))
		{
			mv.addObject("msg","successfully deleted the category");
		}
		else
		{
			mv.addObject("msg","cannot delete the category");
		}
		session.setAttribute("categoryList",categorydAO.list());
		session.setAttribute("category", category);
		log.debug("Ending of the method deleteCategory");
		return mv;
	}
	@RequestMapping("manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id")String id)					//pathvariable is used when we send value/value with url
	{
		log.debug("start of method edit category");
		category=categorydAO.getCategoryById(id);
		
		//selected category details we haveto store in another instance
		//in MAV instance
		
		ModelAndView mv = new ModelAndView("forward:/manageCategory");
		
		mv.addObject("selectedCategory",category);
		log.debug("end of method edit category");
		return mv;
	}
	
	
		@RequestMapping("/manage_category_edit/manage_category_update")
		public ModelAndView updateCategory(@RequestParam("id")String id,
											@RequestParam("name")String name,								
											@RequestParam("cat_type")String cat_type){				//requestparam is used if we have only few parameters r elz v wl use modal
			log.debug("Starting of the method updateCategories");
			category.setId(id);
			category.setName(name);
			category.setCat_type(cat_type);

			ModelAndView mv = new ModelAndView("forward:/manageCategory");
			
			mv.addObject("isAdminClickedCategory","true");
			mv.addObject("isAdmin","true");
			
			//before creating save mtd,check whether cat id is already existing in db or not
			//if it doesnt exists only then it wll call save mtd
			
			if(categorydAO.getCategoryById(id)==null){
				mv.addObject("msg","Category doesnt exists in DB"+id);
				return mv;
			}
			else{					
				categorydAO.update(category);
				mv.addObject("msg","Category with id"+id+" is successfully created and stored");
			}
			session.setAttribute("categoryList",categorydAO.list());
			session.setAttribute("category", category);
			log.debug("End of the method updateCategories");
			return mv;

	}
	
	
}
