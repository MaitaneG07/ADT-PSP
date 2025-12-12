package ProyectoMeteorologico.modelo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ProyectoMeteorologico.modelo.entity.MedicionesCentroMet;
import ProyectoMeteorologico.util.HibernateUtils;

public class MedicionesDAO extends AbstractDAO<MedicionesCentroMet> {

	@Override
	public List<MedicionesCentroMet> getAll() {
		return Collections.emptyList();
	}

	@Override
	public List<MedicionesCentroMet> getById(int id) {
		return Collections.emptyList();
	}

	@Override
	public void insert(MedicionesCentroMet i) {

	}

	@Override
	public void update(MedicionesCentroMet i) {
	}

	@Override
	public void delete(int id) {
	}

	@Override
	public List<MedicionesCentroMet> getByIds(int idCentro, int idEspacio) {
	    List<MedicionesCentroMet> ret = Collections.emptyList();
	    Transaction tx = null;

	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        tx = session.beginTransaction();

	        ret = session.createQuery(
	                "SELECT m FROM MedicionesCentroMet m " +
	                "JOIN m.centrosMeteorologicos c " +
	                "JOIN c.municipio mu " +
	                "JOIN mu.municipiosEspaciosNats men " +
	                "WHERE c.idCentroMet = :idCentroMet " +
	                "AND men.id.idEspacio = :idEspacio",
	                MedicionesCentroMet.class)
	            .setParameter("idCentroMet", idCentro)
	            .setParameter("idEspacio", idEspacio)
	            .list();

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            try { tx.rollback(); } catch (Exception ignore) {}
	        }
	        System.out.println("Error en búsqueda: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return ret;
	}
}
