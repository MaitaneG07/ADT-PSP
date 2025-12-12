package ProyectoMeteorologico.modelo;

import ProyectoMeteorologico.modelo.dao.AbstractDAO;
import ProyectoMeteorologico.modelo.dao.CentroMeteorologicoDAO;
import ProyectoMeteorologico.modelo.dao.EspaciosNaturalesDAO;
import ProyectoMeteorologico.modelo.dao.MedicionesDAO;
import ProyectoMeteorologico.modelo.dao.MunicipioDAO;
import ProyectoMeteorologico.modelo.dao.ProvinciaDAO;
import ProyectoMeteorologico.modelo.exception.DaoFactoryException;

public class DaoFactory {
	
	//AÑADIR LOS OTROS DAO
	public static final String DAO_PROVINCIA = "daoProvincia";
	public static final String DAO_MUNICIPIO = "daoMunicipio";
	public static final String DAO_CENTRO = "daoCentro";
	public static final String DAO_ESPACIO = "daoEspacio";
	public static final String DAO_MEDICION = "daoMedicion";

	/**
	 * Generates and returns a new DAO of the chosen type
	 * 
	 * @param type
	 * @return The selected DAO
	 * @throws DaoFactoryException if a wrong type is chosen
	 */
	public AbstractDAO<?> getDao(String type) throws DaoFactoryException {
		AbstractDAO<?> ret = null;

		switch (type) {
		case DAO_PROVINCIA:
			ret = new ProvinciaDAO();
			break;
		case DAO_MUNICIPIO:
			ret = new MunicipioDAO();
			break;
		case DAO_CENTRO:
			ret = new CentroMeteorologicoDAO();
			break;
		case DAO_ESPACIO:
			ret = new EspaciosNaturalesDAO();
			break;
		case DAO_MEDICION:
			ret = new MedicionesDAO();
			break;
		default:
			throw new DaoFactoryException();
		}

		return ret;
	}
}
