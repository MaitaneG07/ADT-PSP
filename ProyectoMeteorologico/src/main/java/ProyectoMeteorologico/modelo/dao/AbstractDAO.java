package ProyectoMeteorologico.modelo.dao;

import java.util.List;

public abstract class AbstractDAO<I> {
	
	public abstract List<I> getAll();
	
	public abstract List<I> getById (int id);
	
	public abstract List<I> getByIds (int id, int id2);
	
	public abstract void insert (I i);

	public abstract void update (I i);
	
	public abstract void delete (int id);
}
