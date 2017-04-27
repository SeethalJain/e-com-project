package com.niit.getmeb.dao;



import java.util.List;

import com.niit.getmeb.domain.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public List<Product> list();
	public Product get(String id);

}
