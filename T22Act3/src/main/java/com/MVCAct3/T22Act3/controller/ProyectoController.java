package com.MVCAct3.T22Act3.controller;

import com.MVCAct3.T22Act3.model.dto.Proyecto;
import com.MVCAct3.T22Act3.model.service.ProyectoServ;
import com.MVCAct3.T22Act3.view.*;
import com.MVCAct3.T22Act3.view.proyecto.RegistrarProyectoView;
import com.MVCAct3.T22Act3.view.proyecto.BuscarProyectoView;

public class ProyectoController {

	private ProyectoServ proyectoServ;
	private MenuView myMenuView;
	private RegistrarProyectoView myRegisterProyectoView;
	private BuscarProyectoView mySearchProyectoView;

	// Metodos getter Setters de vistas
	public ProyectoServ getProyectoServ() {
		return proyectoServ;
	}

	public void setProyectoServ(ProyectoServ proyectoServ) {
		this.proyectoServ = proyectoServ;
	}

	public MenuView getMyMenuView() {
		return myMenuView;
	}

	public void setMyMenuView(MenuView myMenuView) {
		this.myMenuView = myMenuView;
	}

	public RegistrarProyectoView getMyRegisterProyectoView() {
		return myRegisterProyectoView;
	}

	public void setMyRegisterProyectoView(RegistrarProyectoView myRegisterProyectoView) {
		this.myRegisterProyectoView = myRegisterProyectoView;
	}

	public BuscarProyectoView getMySearchProyectoView() {
		return mySearchProyectoView;
	}

	public void setMySearchProyectoView(BuscarProyectoView mySearchProyectoView) {
		this.mySearchProyectoView = mySearchProyectoView;
	}

	// Hace visible las vistas de Registro y Consulta
	public void showRegisterProyectoView() {
		myRegisterProyectoView.setVisible(true);
	}

	public void showSearchProyectoView() {
		mySearchProyectoView.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void añadirProyecto(Proyecto miProyecto) {
		proyectoServ.validarRegistro(miProyecto);
	}

	public Proyecto buscarProyecto(String idProyecto) {
		return proyectoServ.validateQuery(idProyecto);
	}

	public void modificarProyecto(Proyecto miProyecto) {
		proyectoServ.validarModificacion(miProyecto);
	}

	public void borrarProyecto(String idProyecto) {
		proyectoServ.validarBorrado(idProyecto);
	}

}
