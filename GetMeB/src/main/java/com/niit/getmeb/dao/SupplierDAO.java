package com.niit.getmeb.dao;

import java.util.List;

import com.niit.getmeb.domain.Supplier;

public interface SupplierDAO {
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public List<Supplier> list();
	public Supplier get(String supplier_id);

}
