package com.RetrofitApp.modelo;

import com.RetrofitApp.modelo.dao.CancionDao;
import com.RetrofitApp.modelo.dao.DaoGenerico;
import com.RetrofitApp.modelo.dao.GrupoDao;
import com.RetrofitApp.modelo.dao.ListaDao;
import com.RetrofitApp.modelo.dao.UsuarioDao;
import com.RetrofitApp.modelo.exception.DaoFactoryException;

public class DaoFactory {

	// AÑADIR LOS OTROS DAO
	public static final String DAO_USUARIO = "daoUsuario";
	public static final String DAO_LISTA = "daoLista";
	public static final String DAO_GRUPO = "daoGrupo";
	public static final String DAO_CANCION = "daoCancion";

	/**
	 * Generates and returns a new DAO of the chosen type
	 * 
	 * @param type
	 * @return The selected DAO
	 * @throws DaoFactoryException if a wrong type is chosen
	 */
	public DaoGenerico<?> getDao(String type) throws DaoFactoryException {
		DaoGenerico<?> ret = null;

		switch (type) {
		case DAO_USUARIO:
			ret = new UsuarioDao();
			break;
		case DAO_LISTA:
			ret = new ListaDao();
			break;
		case DAO_GRUPO:
			ret = new GrupoDao();
			break;
		case DAO_CANCION:
			ret = new CancionDao();
			break;
		default:
			throw new DaoFactoryException();
		}

		return ret;
	}
}
