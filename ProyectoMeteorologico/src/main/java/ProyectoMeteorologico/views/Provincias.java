package ProyectoMeteorologico.views;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ProyectoMeteorologico.modelo.DaoFactory;
import ProyectoMeteorologico.modelo.dao.CentroMeteorologicoDAO;
import ProyectoMeteorologico.modelo.dao.EspaciosNaturalesDAO;
import ProyectoMeteorologico.modelo.dao.MedicionesDAO;
import ProyectoMeteorologico.modelo.dao.MunicipioDAO;
import ProyectoMeteorologico.modelo.dao.ProvinciaDAO;
import ProyectoMeteorologico.modelo.entity.CentroMeteorologico;
import ProyectoMeteorologico.modelo.entity.EspaciosNaturales;
import ProyectoMeteorologico.modelo.entity.MedicionesCentroMet;
import ProyectoMeteorologico.modelo.entity.Municipio;
import ProyectoMeteorologico.modelo.entity.Provincia;
import ProyectoMeteorologico.modelo.exception.DaoFactoryException;

public class Provincias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Provincia> comboBoxProvincias;
	private JLabel lblMunicipio;
	private JScrollPane scrollPaneMunicipios;
	private DefaultTableModel modeloMunicipios;
	private JTable tablaMunicipios;
	private JLabel lblProvincias;
	private JScrollPane scrollPaneCentrosMeteorologicos;
	private DefaultTableModel modeloCentrosMeteorologicos;
	private JTable tablaCentrosMeteorologicos;
	private JScrollPane scrollPaneEspaciosNaturales;
	private DefaultTableModel modeloEspaciosNaturales;
	private JTable tablaEspaciosNaturales;
	private JLabel lblCentros;
	private JLabel lblEspacios;
	private JScrollPane scrollPaneMediciones;
	private DefaultTableModel modeloMediciones;
	private JTable tablaMediciones;
	private int idEspacioSeleccionado;
	@SuppressWarnings("unused")
	private int idMunicipioSeleccionado;
	private int idCentroSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Provincias frame = new Provincias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Provincias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblProvincias = new JLabel("ELIJA UNA PROVINCIA");
		lblProvincias.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvincias.setBounds(10, 11, 248, 32);
		contentPane.add(lblProvincias);

		lblMunicipio = new JLabel("ELIJA UN MUNICIPIO");
		lblMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMunicipio.setBounds(10, 97, 248, 32);
		contentPane.add(lblMunicipio);

		// CREACIÓN TABLA MUNICIPIOS
		scrollPaneMunicipios = new JScrollPane();
		scrollPaneMunicipios.setBounds(20, 140, 218, 104);
		contentPane.add(scrollPaneMunicipios);

		modeloMunicipios = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloMunicipios.addColumn("ID");
		modeloMunicipios.addColumn("Nombre");

		tablaMunicipios = new JTable(modeloMunicipios);
		tablaMunicipios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tablaMunicipios.getColumnModel().getColumn(0).setMinWidth(0);
		tablaMunicipios.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaMunicipios.getColumnModel().getColumn(0).setWidth(0);

		// Agregar MouseListener para detectar el un clic y obtener el id
		tablaMunicipios.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && tablaMunicipios.getSelectedRow() != -1) {
					int selectedRow = tablaMunicipios.getSelectedRow();
					int idMunicipio = (int) tablaMunicipios.getValueAt(selectedRow, 0);

					System.out.println("ID Municipio seleccionado: " + idMunicipio);

					try {
						actualizarTablaCentroMeteorologico(modeloCentrosMeteorologicos, idMunicipio);
						actualizarTablaEspaciosNaturales(modeloEspaciosNaturales, idMunicipio);
					} catch (DaoFactoryException e1) {
						System.out.println("Error al intentar actualizar la tabla de centros y espacios.");
						e1.printStackTrace();
					}

					idMunicipioSeleccionado = idMunicipio;
				}
			}
		});

		scrollPaneMunicipios.setViewportView(tablaMunicipios);

		// CREACION TABLA CENTRO METEOROLOGICO
		scrollPaneCentrosMeteorologicos = new JScrollPane();
		scrollPaneCentrosMeteorologicos.setBounds(284, 57, 218, 188);
		contentPane.add(scrollPaneCentrosMeteorologicos);

		modeloCentrosMeteorologicos = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloCentrosMeteorologicos.addColumn("ID");
		modeloCentrosMeteorologicos.addColumn("Nombre");

		tablaCentrosMeteorologicos = new JTable(modeloCentrosMeteorologicos);
		tablaCentrosMeteorologicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tablaCentrosMeteorologicos.getColumnModel().getColumn(0).setMinWidth(0);
		tablaCentrosMeteorologicos.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaCentrosMeteorologicos.getColumnModel().getColumn(0).setWidth(0);

		tablaCentrosMeteorologicos.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && tablaCentrosMeteorologicos.getSelectedRow() != -1) {
					int selectedRow = tablaCentrosMeteorologicos.getSelectedRow();
					int idCentro = (int) tablaCentrosMeteorologicos.getValueAt(selectedRow, 0);

					System.out.println("ID Centro seleccionado: " + idCentro);

					idCentroSeleccionado = idCentro;
				}
			}
		});

		scrollPaneCentrosMeteorologicos.setViewportView(tablaCentrosMeteorologicos);

		// CREACION TABLA ESPACIOS NATURALES
		scrollPaneEspaciosNaturales = new JScrollPane();
		scrollPaneEspaciosNaturales.setBounds(543, 57, 218, 188);
		contentPane.add(scrollPaneEspaciosNaturales);

		modeloEspaciosNaturales = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloEspaciosNaturales.addColumn("ID");
		modeloEspaciosNaturales.addColumn("Nombre");

		tablaEspaciosNaturales = new JTable(modeloEspaciosNaturales);
		tablaEspaciosNaturales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tablaEspaciosNaturales.getColumnModel().getColumn(0).setMinWidth(0);
		tablaEspaciosNaturales.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaEspaciosNaturales.getColumnModel().getColumn(0).setWidth(0);

		// Agregar MouseListener para detectar el un clic y obtener el id
		tablaEspaciosNaturales.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && tablaEspaciosNaturales.getSelectedRow() != -1) {
					int selectedRow = tablaEspaciosNaturales.getSelectedRow();
					int idEspacio = (int) tablaEspaciosNaturales.getValueAt(selectedRow, 0);

					System.out.println("ID Espacio seleccionado: " + idEspacio);

					idEspacioSeleccionado = idEspacio;
					
					if (idCentroSeleccionado != 0 && idEspacioSeleccionado != 0) {
		                try {
		                    pasarId(idCentroSeleccionado, idEspacioSeleccionado);
		                } catch (DaoFactoryException ex) {
		                    ex.printStackTrace();
		                }
		            }
				}
			}
		});

		scrollPaneEspaciosNaturales.setViewportView(tablaEspaciosNaturales);

		// CREACION TABLA MEDICIONES
		scrollPaneMediciones = new JScrollPane();
		scrollPaneMediciones.setBounds(20, 286, 741, 175);
		contentPane.add(scrollPaneMediciones);

		modeloMediciones = new DefaultTableModel();
		modeloMediciones.addColumn("ID");
		modeloMediciones.addColumn("Fecha");
		modeloMediciones.addColumn("Hora");
		modeloMediciones.addColumn("Ica");
		modeloMediciones.addColumn("Dir. Viento");
		modeloMediciones.addColumn("H. Relativa");
		modeloMediciones.addColumn("P. Atmos.");
		modeloMediciones.addColumn("Precip.");
		modeloMediciones.addColumn("Rad. Solar");
		modeloMediciones.addColumn("Temp. AM");
		modeloMediciones.addColumn("V. Viento");

		tablaMediciones = new JTable(modeloMediciones);
		tablaMediciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tablaMediciones.getColumnModel().getColumn(0).setMinWidth(0);
		tablaMediciones.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaMediciones.getColumnModel().getColumn(0).setWidth(0);

		scrollPaneMediciones.setViewportView(tablaMediciones);

		// CREACIÓN DEL COMBOBOX
		comboBoxProvincias = new JComboBox<Provincia>();
		comboBoxProvincias.setMaximumRowCount(50);
		comboBoxProvincias.setBounds(20, 54, 218, 22);
		contentPane.add(comboBoxProvincias);

		lblCentros = new JLabel("ELIGE UN CENTRO METEOROLOGICO");
		lblCentros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentros.setBounds(272, 11, 239, 32);
		contentPane.add(lblCentros);

		lblEspacios = new JLabel("ELIGE UN ESPACIO NATURAL");
		lblEspacios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspacios.setBounds(533, 11, 239, 32);
		contentPane.add(lblEspacios);

		JLabel lblMediciones = new JLabel("MEDICIONES");
		lblMediciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMediciones.setBounds(272, 256, 239, 32);
		contentPane.add(lblMediciones);

		// AL SELECCIONAR LA PROVINCIA, SE OBTIENE TODA LA PROVINCIA Y SE LLAMA A
		// ACTUALIZAR TABLA DE MUNICIPIOS PARA QUE SE MUESTREN LOS MUNICIPIOS DE DICHA
		// PROVINCIA
		comboBoxProvincias.addActionListener(e -> {
			Provincia seleccionada = (Provincia) comboBoxProvincias.getSelectedItem();
			if (seleccionada != null) {
				try {
					actualizarTablaMunicipios(modeloMunicipios, seleccionada);
				} catch (DaoFactoryException ex) {
					System.out.println("Error al actualizar la tabla con los municipios.");
					ex.printStackTrace();
				}
			}
		});

		try {
			cargarProvincias();
		} catch (DaoFactoryException e) {
			System.out.println("Error al cargar provincias");
			e.printStackTrace();
		}

	}

	// PASAMOS LOS ID PARA BUSCAR LAS MEDICIONES Y ACTUALIZAR LA TABLA
	private void pasarId(int idCentroSeleccionado, int idEspacioSeleccionado) throws DaoFactoryException {
		actualizarTablaMediciones(modeloMediciones, idCentroSeleccionado, idEspacioSeleccionado);
	}

	// INSERTAMOS EN LA TABLA DE MEDICIONES, LAS MEDICIONES OBTENIDAS DEL ESPACIO Y CENTRO SELECCIONADO
	private void actualizarTablaMediciones(DefaultTableModel modeloMediciones, int idCentroSeleccionado,
			int idEspacioSeleccionado) throws DaoFactoryException {

		modeloMediciones.setRowCount(0);
		List<MedicionesCentroMet> listaMediciones = cargarMediciones(idCentroSeleccionado, idEspacioSeleccionado);
		System.out.println("Número de mediciones: " + listaMediciones.size());

		if (listaMediciones != null && !listaMediciones.isEmpty()) {
			for (MedicionesCentroMet medicion : listaMediciones) {
				modeloMediciones.addRow(new Object[] { medicion.getId(), medicion.getId().getFecha(),
						medicion.getId().getHora(), medicion.getIca(), medicion.getDirViento(), medicion.getHRelativa(),
						medicion.getPAtmosferica(), medicion.getPrecip(), medicion.getRadSolar(),
						medicion.getTempAmbiente(), medicion.getVViento() });
			}
			tablaMediciones.revalidate();
			tablaMediciones.repaint();
		} else {
			System.out.println("No hay mediciones en ese Espacio y Centro");
		}
	}

	// INSERTAMOS EN LA TABLA DE ESPACIOS NATURALES, LOS ESPACIOS OBTENIDOS DEL
	// MUNICIPIO SELECCIONADO
	protected void actualizarTablaEspaciosNaturales(DefaultTableModel modeloEspaciosNaturales, int idMunicipio)
			throws DaoFactoryException {

		modeloEspaciosNaturales.setRowCount(0);
		List<EspaciosNaturales> listaEspacios = cargarEspacios(idMunicipio);
		System.out.println("Número de espacios naturales: " + listaEspacios.size());

		if (listaEspacios != null && !listaEspacios.isEmpty()) {
			for (EspaciosNaturales espacio : listaEspacios) {
				modeloEspaciosNaturales.addRow(new Object[] { espacio.getIdEspacio(), espacio.getNombre() });
			}
			tablaEspaciosNaturales.revalidate();
			tablaEspaciosNaturales.repaint();
		} else {
			System.out.println("No hay espacios naturales en ese Municipio");
		}
	}

	// INSERTAMOS EN LA TABLA DE CENTROS METEOROLOGICOS, LOS CENTROS OBTENIDOS DEL
	// MUNICIPIO SELECCIONADO
	protected void actualizarTablaCentroMeteorologico(DefaultTableModel modeloCentrosMeteorologicos, int idMunicipio)
			throws DaoFactoryException {

		modeloCentrosMeteorologicos.setRowCount(0);
		List<CentroMeteorologico> listaCentros = cargarCentros(idMunicipio);
		System.out.println("Número de centros meteorologico: " + listaCentros.size());

		if (listaCentros != null && !listaCentros.isEmpty()) {
			for (CentroMeteorologico centros : listaCentros) {
				modeloCentrosMeteorologicos.addRow(new Object[] { centros.getIdCentro(), centros.getNombre() });
			}
			tablaCentrosMeteorologicos.revalidate();
			tablaCentrosMeteorologicos.repaint();
		} else {
			System.out.println("No hay espacios naturales en ese Municipio");
		}
	}

	// INSERTAMOS EN LA TABLA DE MUNICIPIOS, LOS MUNICIPIOS OBTENIDOS DE LA
	// PROVINCIA SELECCIONADA
	public void actualizarTablaMunicipios(DefaultTableModel modeloMunicipios, Provincia provinciaSeleccionada)
			throws DaoFactoryException {

		modeloMunicipios.setRowCount(0);
		List<Municipio> listaMunicipios = cargarMunicipios(provinciaSeleccionada);
		System.out.println("Número de municipios: " + listaMunicipios.size());

		if (listaMunicipios != null && !listaMunicipios.isEmpty()) {
			for (Municipio municipio : listaMunicipios) {
				modeloMunicipios.addRow(new Object[] { municipio.getIdMunicipio(), municipio.getNombre() });
			}
			tablaMunicipios.revalidate();
			tablaMunicipios.repaint();
		} else {
			System.out.println("No hay municipios en esa Provincia");
		}
	}

	// OBTENEMOS LAS PROVINCIAS
	private void cargarProvincias() throws DaoFactoryException {
		DaoFactory daoFactory = new DaoFactory();
		ProvinciaDAO provinciasDAO = (ProvinciaDAO) daoFactory.getDao(DaoFactory.DAO_PROVINCIA);

		List<Provincia> provincias = provinciasDAO.getAll();

		if (provincias == null) {
			System.out.println("No hay provincias");
		} else {
			for (Provincia provincia : provincias) {
				System.out.println(provincia.toString());
				comboBoxProvincias.addItem(provincia);
			}
			System.out.println("Provincias cargadas: " + comboBoxProvincias.getItemCount());
		}
	}

	// OBTENEMOS LOS MUNICIPIOS DE LA PROVINCIA SELECCIONADA
	private List<Municipio> cargarMunicipios(Provincia provinciaSeleccionada) throws DaoFactoryException {
		DaoFactory daoFactory = new DaoFactory();
		MunicipioDAO municipiosDAO = (MunicipioDAO) daoFactory.getDao(DaoFactory.DAO_MUNICIPIO);

		if (provinciaSeleccionada == null)
			return Collections.emptyList();

		System.out.println("Provincia seleccionada: " + provinciaSeleccionada.getIdProvincia());
		return municipiosDAO.getById(provinciaSeleccionada.getIdProvincia());
	}

	// OBTENEMOS LOS ESPACIOS NATURALES DEL MUNICIPIO SELECCIONADO
	private List<EspaciosNaturales> cargarEspacios(int idMunicipio) throws DaoFactoryException {
		DaoFactory daoFactory = new DaoFactory();
		EspaciosNaturalesDAO espaciosNaturalesDAO = (EspaciosNaturalesDAO) daoFactory.getDao(DaoFactory.DAO_ESPACIO);

		if (idMunicipio == 0)
			return Collections.emptyList();

		System.out.println("Espacio seleccionado: " + idMunicipio);
		return espaciosNaturalesDAO.getById(idMunicipio);
	}

	// OBTENEMOS LOS CENTROS METEOROLOGICOS DEL MUNICIPIO SELECCIONADO
	private List<CentroMeteorologico> cargarCentros(int idMunicipio) throws DaoFactoryException {
		DaoFactory daoFactory = new DaoFactory();
		CentroMeteorologicoDAO centroMeteorologicoDAO = (CentroMeteorologicoDAO) daoFactory
				.getDao(DaoFactory.DAO_CENTRO);

		if (idMunicipio == 0)
			return Collections.emptyList();

		System.out.println("Centro seleccionado: " + idMunicipio);
		return centroMeteorologicoDAO.getById(idMunicipio);
	}

	// OBTENEMOS LAS MEDICIONES DEL ESPACIO Y CENTRO SELECCIONADO
	private List<MedicionesCentroMet> cargarMediciones(int idCentroSeleccionado, int idEspacioSeleccionado)
			throws DaoFactoryException {
		DaoFactory daoFactory = new DaoFactory();
		MedicionesDAO medicionesDAO = (MedicionesDAO) daoFactory.getDao(DaoFactory.DAO_MEDICION);

		if (idCentroSeleccionado == 0 && idEspacioSeleccionado == 0)
			return Collections.emptyList();

		System.out.println("Centro seleccionado: " + idCentroSeleccionado);
		System.out.println("Espacio seleccionado: " + idEspacioSeleccionado);
		return medicionesDAO.getByIds(idCentroSeleccionado, idEspacioSeleccionado);
	}
}
