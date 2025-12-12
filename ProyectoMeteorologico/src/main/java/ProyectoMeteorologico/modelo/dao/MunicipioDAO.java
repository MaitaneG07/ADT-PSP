package ProyectoMeteorologico.modelo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ProyectoMeteorologico.modelo.entity.Municipio;
import ProyectoMeteorologico.util.HibernateUtils;

public class MunicipioDAO extends AbstractDAO<Municipio> {

	@Override
	public List<Municipio> getAll() {
		return Collections.emptyList();
	}

	@Override
	public List<Municipio> getById(int id) {
		List<Municipio> ret = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			// HQL correcto: nombre de la entidad (clase), no de la tabla
			ret = session.createQuery("FROM Municipio m WHERE m.provincia.idProvincia = :idProvincia", Municipio.class)
					.setParameter("idProvincia", id).list();

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
	public void insert(Municipio i) {

	}

	@Override
	public void update(Municipio i) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public List<Municipio> getByIds(int id, int id2) {
		return Collections.emptyList();
	}

}
