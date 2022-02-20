package com.MVCAct3.T22Act3.model.service;

import javax.swing.JOptionPane;


import com.MVCAct3.T22Act3.controller.ProyectoController;

import com.MVCAct3.T22Act3.model.dao.ProyectoDao;

import com.MVCAct3.T22Act3.model.dto.Proyecto;

public class ProyectoServ {
	
	private ProyectoController proyectoController;
	public static boolean consultProyecto = false;
	public static boolean modifyProyecto = false;

	// Metodo de vinculación con el controller principal
	public void setProyectoController(ProyectoController proyectoController) {
		this.setProyectoController(proyectoController);		
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if (miProyecto.getNombre().length() > 3) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.registrarProyecto(miProyecto);
		} else {
			JOptionPane.showMessageDialog(null, "The name must have more than 3 characters", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Proyecto validateQuery(String idProyecto) {
		ProyectoDao miProyectoDao;

		try {
			int id = Integer.parseInt(idProyecto);//mirar
			if (id >= 0 || id <= 200) {
				miProyectoDao = new ProyectoDao();
				consultProyecto = true;
				return miProyectoDao.buscarProyecto(id);
			} else {
				JOptionPane.showMessageDialog(null, "The client's id must be between 1-200",
						"Warning", JOptionPane.WARNING_MESSAGE);
				consultProyecto = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Must introduce numerical data", "Error", JOptionPane.ERROR_MESSAGE);
			consultProyecto = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There is an Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultProyecto = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if (miProyecto.getNombre().length() > 1) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(miProyecto);
			modifyProyecto = true;
		} else {
			JOptionPane.showMessageDialog(null, "The project's name must have more than 1 characters", "Warning",
					JOptionPane.WARNING_MESSAGE);
			modifyProyecto = false;
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
