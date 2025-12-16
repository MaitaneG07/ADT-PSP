package com.RetrofitApp.modelo.dao;

import java.util.List;

public abstract class DaoGenerico<I> {

	public abstract List<I> findAll();
	
	public abstract List<I> findById(int id);
	
	public abstract List<I> getByIds (int id, int id2);
	
	public abstract I save(I entity);

	public abstract I update(I entity);
	
	public abstract void delete(I entity);
	
	public abstract void deleteById(int id);
}
