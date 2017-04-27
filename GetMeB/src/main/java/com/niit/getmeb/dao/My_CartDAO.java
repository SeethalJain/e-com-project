package com.niit.getmeb.dao;

import java.util.List;

import com.niit.getmeb.domain.My_Cart;


public interface My_CartDAO {
	public boolean save(My_Cart myc);
	public boolean update(My_Cart myc);
	public List<My_Cart> list();
	public My_Cart get(String id);

}
