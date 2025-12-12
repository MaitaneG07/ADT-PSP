package ProyectoMeteorologico;

import java.awt.EventQueue;

import ProyectoMeteorologico.views.Provincias;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Provincias().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
