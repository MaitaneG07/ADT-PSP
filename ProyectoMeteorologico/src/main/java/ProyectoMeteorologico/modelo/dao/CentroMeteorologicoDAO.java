package ProyectoMeteorologico.modelo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ProyectoMeteorologico.modelo.entity.CentroMeteorologico;
import ProyectoMeteorologico.util.HibernateUtils;

public class CentroMeteorologicoDAO extends AbstractDAO<CentroMeteorologico> {

	@Override
	public List<CentroMeteorologico> getAll() {
		return Collections.emptyList();
	}

	@Override
	public List<CentroMeteorologico> getById(int id) {
		List<CentroMeteorologico> ret = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			// HQL correcto: nombre de la entidad (clase), no de la tabla
			ret = session.createQuery("FROM CentroMeteorologico c WHERE c.municipio.idMunicipio = :idMunicipio", CentroMeteorologico.class)
					.setParameter("idMunicipio", id).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (Exception ex) {
					/* ignore */ }
			}
			System.out.println("Error en busqueda: " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void insert(CentroMeteorologico i) {
		
	}

	@Override
	public void update(CentroMeteorologico i) {
		
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public List<CentroMeteorologico> getByIds(int id, int id2) {
		return Collections.emptyList();
	}

}
