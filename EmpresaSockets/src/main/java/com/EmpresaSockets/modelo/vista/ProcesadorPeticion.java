package com.EmpresaSockets.modelo.vista;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.EmpresaSockets.modelo.entity.Credenciales;
import com.EmpresaSockets.modelo.util.HibernateUtils;


public class ProcesadorPeticion {
	public static String procesar(String peticion) {
		String[] partes = peticion.split("\\|");
		switch (partes[0]) {
		case "LOGIN":
			return login(partes[1], partes[2]);
		case "LIST_EMPRESAS":
			return listarEmpresas();
		case "ADD_EMPLEADO":
			return altaEmpleado(partes);
		// etc...
		default:
			return "ERROR|Comando no reconocido";
		}
	}

	private static String login(String user, String pass) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Query<Credenciales> q = session.createQuery("FROM Credenciales c WHERE c.login = :user AND c.pass = :pass",
					Credenciales.class);
			q.setParameter("user", user);
			q.setParameter("pass", pass);
			Credenciales cred = q.uniqueResult();
			return (cred != null) ? "OK|Login correcto" : "ERROR|Login incorrecto";
		}
	}
}
