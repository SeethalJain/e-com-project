package com.niit.Controller;

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
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	
	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("id")String id,
										@RequestParam("name")String name,								
										@RequestParam("cat_type")String cat_type){				//requestparam is used if we have only few parameters r elz v wl use modal
		category.setId(id);
		category.setName(name);
		category.setCat_type(cat_type);

		ModelAndView mv = new ModelAndView("Home");
		
		mv.addObject("isAdminClickedCategory","true");
		mv.addObject("isAdmin","true");
		
		//before creating save mtd,check whether cat id is already existing in db or not
		//if it doesnt exists only then it wll call save mtd
		
		if(categoryDAO.getCategoryById(id)!=null){
			mv.addObject("msg","Category already exists in DB"+id);
			return mv;
		}
		else{					
			categoryDAO.save(category);
			mv.addObject("msg","Category with id"+id+" is successfully created and stored");
		}
		return mv;
	}
	
	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{																		//pathvariable is used when we send value/value with url
		ModelAndView mv = new ModelAndView("Home");
		if(categoryDAO.delete(id))
		{
			mv.addObject("msg","successfully deleted the category");
		}
		else
		{
			mv.addObject("msg","cannot delete the category");
		}
		return mv;
	}
}
