package com.niit.getmeb.dao;

import java.util.List;

import com.niit.getmeb.domain.Category;


public interface CategoryDAO {
	public boolean save(Category category);					//create category
	public boolean update(Category category);				//update
	public boolean delete(String id);						//delete category
	public List<Category> list();							//get all the categories
	public Category getCategoryById(String id);				//get  category by id
	public Category getCategoryByName(String name);			//get categoery by name
}
