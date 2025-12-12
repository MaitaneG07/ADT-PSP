package ProyectoMeteorologico.modelo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ProyectoMeteorologico.modelo.entity.EspaciosNaturales;
import ProyectoMeteorologico.util.HibernateUtils;

public class EspaciosNaturalesDAO extends AbstractDAO<EspaciosNaturales> {

	@Override
	public List<EspaciosNaturales> getAll() {
		return Collections.emptyList();
	}

	@Override
	public List<EspaciosNaturales> getById(int idMunicipio) {
	    List<EspaciosNaturales> ret = new ArrayList<>();
	    Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();

	        // Consulta directa de espacios naturales vinculados al municipio
	        ret = session.createQuery(
	            "SELECT e FROM EspaciosNaturales e " +
	            "WHERE e.idEspacio IN (" +
	            "   SELECT me.id.idEspacio FROM MunicipiosEspaciosNat me " +
	            "   WHERE me.id.idMunicipio = :idMunicipio" +
	            ")",
	            EspaciosNaturales.class
	        )
	        .setParameter("idMunicipio", idMunicipio)
	        .list();

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            try { transaction.rollback(); } catch (Exception ex) { /* ignore */ }
	        }
	        System.out.println("Error en búsqueda: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return ret;
	}


	@Override
	public void insert(EspaciosNaturales i) {

	}

	@Override
	public void update(EspaciosNaturales i) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public List<EspaciosNaturales> getByIds(int id, int id2) {
		return Collections.emptyList();
	}

}
