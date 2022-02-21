package com.MVCAct3.T22Act3.model.service;

import javax.swing.JOptionPane;
import com.MVCAct3.T22Act3.controller.ProyectoController;
import com.MVCAct3.T22Act3.model.dao.ProyectoDao;
import com.MVCAct3.T22Act3.model.dto.Proyecto;

public class ProyectoServ {

	private ProyectoController proyectoController;
	public static boolean consultarProyecto = false;
	public static boolean modificarProyecto = false;

	// Metodo de vinculación con el controller principal
	public void setProyectoController(ProyectoController proyectoController) {
		this.setController(proyectoController);
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if (miProyecto.getNombre().length() > 3) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.registrarProyecto(miProyecto);
		} else {
			JOptionPane.showMessageDialog(null, "El nombre del proyecto ha de tener más de 3 caracteres", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Proyecto validateQuery(String idProyecto) {
		ProyectoDao miProyectoDao;

		try {
			int id = Integer.parseInt(idProyecto);// mirar
			if (id >= 0 || id <= 200) {
				miProyectoDao = new ProyectoDao();
				consultarProyecto = true;
				return miProyectoDao.buscarProyecto(id);
			} else {
				JOptionPane.showMessageDialog(null, "El id del cliente debe estar entre 1 y 200", "Warning",
						JOptionPane.WARNING_MESSAGE);
				consultarProyecto = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe introducir un valor numérico", "Error",
					JOptionPane.ERROR_MESSAGE);
			consultarProyecto = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error", JOptionPane.ERROR_MESSAGE);
			consultarProyecto = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if (miProyecto.getNombre().length() > 1) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(miProyecto);
			modificarProyecto = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre del proyecto ha de tener más de 1 caracter", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificarProyecto = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarBorrado(String id) {
		ProyectoDao miProyectoDao = new ProyectoDao();
		miProyectoDao.borrarProyecto(id);
	}

	public ProyectoController getProyectoController() {
		return proyectoController;
	}

	public void setController(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

}
