package com.MVCAct3.T22Act3.model.service;

import javax.swing.JOptionPane;

import com.MVCAct3.T22Act3.controller.CientificoController;
import com.MVCAct3.T22Act3.model.dao.CientificoDao;
import com.MVCAct3.T22Act3.model.dto.Cientifico;



public class CientificoServ {
	
	private CientificoController cientificoController;
	public static boolean consultCientifico = false;
	public static boolean modifyCientifico = false;

	// Metodo de vinculación con el controller principal
	public void setCientificoController(CientificoController cientificoController) {
		this.setController(cientificoController);		
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getDNI().length() > 3) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.registrarCientifico(miCientifico);
		} else {
			JOptionPane.showMessageDialog(null, "The document must have more than 3 digits", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico validateQuery(String DNICientifico) {
		CientificoDao miCientificoDao;

		try {
			int id = Integer.parseInt(DNICientifico);//mirar
			if (id / 10000000 > 1 && id / 10000000 < 10) {
				miCientificoDao = new CientificoDao();
				consultCientifico = true;
				return miCientificoDao.buscarCientifico(id);
			} else {
				JOptionPane.showMessageDialog(null, "The cientifico's DNI must have 8 numerical characters",
						"Warning", JOptionPane.WARNING_MESSAGE);
				consultCientifico = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Must introduce numerical data", "Error", JOptionPane.ERROR_MESSAGE);
			consultCientifico = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There is an Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultCientifico = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getNomApels().length() > 1) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.modificarCientifico(miCientifico);
			modifyCientifico = true;
		} else {
			JOptionPane.showMessageDialog(null, "The cientifico's name must have more than 1 character", "Warning",
					JOptionPane.WARNING_MESSAGE);
			modifyCientifico = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarBorrado(String DNI) {
		CientificoDao miCientificoDao = new CientificoDao();
		miCientificoDao.borrarCientifico(DNI);
	}

	public CientificoController getCientificoController() {
		return cientificoController;
	}

	public void setController(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}

}
