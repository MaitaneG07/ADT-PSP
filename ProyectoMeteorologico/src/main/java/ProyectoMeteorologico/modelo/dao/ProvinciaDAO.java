package ProyectoMeteorologico.modelo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ProyectoMeteorologico.modelo.entity.Provincia;
import ProyectoMeteorologico.util.HibernateUtils;

public class ProvinciaDAO extends AbstractDAO<Provincia> {

	@Override
	public List<Provincia> getAll() {
	    List<Provincia> ret = new ArrayList<>();
	    Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();

	        // HQL correcto: nombre de la entidad (clase), no de la tabla
	        ret = session.createQuery("FROM Provincia", Provincia.class).list();

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            try { transaction.rollback(); } catch (Exception ex) { /* ignore */ }
	        }
	        System.out.println("Error en busqueda: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return ret;
	}


	@Override
	public List<Provincia> getById(int id) {
		return Collections.emptyList();
	}

	@Override
	public void insert(Provincia i) {
		
	}

	@Override
	public void update(Provincia i) {
		
	}

	@Override
	public void delete(int id) {
		
	}


	@Override
	public List<Provincia> getByIds(int id, int id2) {
		return Collections.emptyList();
	}

}
