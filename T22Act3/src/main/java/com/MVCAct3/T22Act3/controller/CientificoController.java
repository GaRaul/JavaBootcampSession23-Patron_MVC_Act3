package com.MVCAct3.T22Act3.controller;

import com.MVCAct3.T22Act3.model.dto.Cientifico;
import com.MVCAct3.T22Act3.model.service.CientificoServ;
import com.MVCAct3.T22Act3.view.MenuView;
import com.MVCAct3.T22Act3.view.cientifico.RegistrarCientificoView;
import com.MVCAct3.T22Act3.view.cientifico.BuscarCientificoView;

public class CientificoController {

	private CientificoServ cientificoServ;
	private MenuView myMenuView;
	private RegistrarCientificoView myRegisterCientificoView;
	private BuscarCientificoView mySearchCientificoView;

	// Metodos getter Setters de vistas
	public CientificoServ getCientificoServ() {
		return cientificoServ;
	}

	public void setCientificoServ(CientificoServ cientificoServ) {
		this.cientificoServ = cientificoServ;
	}

	public MenuView getMyMenuView() {
		return myMenuView;
	}

	public void setMyMenuView(MenuView myMenuView) {
		this.myMenuView = myMenuView;
	}

	public RegistrarCientificoView getMyRegisterCientificoView() {
		return myRegisterCientificoView;
	}

	public void setMyRegisterCientificoView(RegistrarCientificoView myRegisterCientificoView) {
		this.myRegisterCientificoView = myRegisterCientificoView;
	}

	public BuscarCientificoView getMySearchCientificoView() {
		return mySearchCientificoView;
	}

	public void setMySearchCientificoView(BuscarCientificoView mySearchCientificoView) {
		this.mySearchCientificoView = mySearchCientificoView;
	}

	// Hace visible las vistas de Registro y Consulta
	public void showRegisterCientificoView() {
		myRegisterCientificoView.setVisible(true);
	}

	public void showSearchCientificoView() {
		mySearchCientificoView.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void añadirCientifico(Cientifico miCientifico) {
		cientificoServ.validarRegistro(miCientifico);
	}

	public Cientifico buscarCientifico(String DNI) {
		return cientificoServ.validateQuery(DNI);
	}

	public void modificarCientifico(Cientifico miCientifico) {
		cientificoServ.validarModificacion(miCientifico);
	}

	public void borrarCientifico(String DNI) {
		cientificoServ.validarBorrado(DNI);
	}

}
