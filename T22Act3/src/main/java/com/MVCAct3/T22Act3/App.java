package com.MVCAct3.T22Act3;

import com.MVCAct3.T22Act3.controller.CientificoController;
import com.MVCAct3.T22Act3.controller.ProyectoController;
import com.MVCAct3.T22Act3.model.service.CientificoServ;
import com.MVCAct3.T22Act3.model.service.ProyectoServ;
import com.MVCAct3.T22Act3.view.*;
import com.MVCAct3.T22Act3.view.cientifico.RegistrarCientificoView;
import com.MVCAct3.T22Act3.view.cientifico.BuscarCientificoView;
import com.MVCAct3.T22Act3.view.proyecto.RegistrarProyectoView;
import com.MVCAct3.T22Act3.view.proyecto.BuscarProyectoView;

/**
 * @autores: Abel, Albert, Edgar y Raúl 
 * Fecha modificación: 21/02/2021
 */
public class App {
	ProyectoServ miProyectoServ;
	CientificoServ miCientificoServ;
	MenuView myMenuView;
	BuscarProyectoView mySearchProyectoView;
	RegistrarProyectoView myRegisterProyectoView;
	BuscarCientificoView mySearchCientificoView;
	RegistrarCientificoView myRegisterCientificoView;
	ProyectoController proyectoController;
	CientificoController cientificoController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App miPrincipal = new App();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja el sistema
	 */
	private void iniciar() {
		/* Se instancian las clases */
		myMenuView = new MenuView();

		myRegisterProyectoView = new RegistrarProyectoView();
		mySearchProyectoView = new BuscarProyectoView();
		miProyectoServ = new ProyectoServ();
		proyectoController = new ProyectoController();

		myRegisterCientificoView = new RegistrarCientificoView();
		mySearchCientificoView = new BuscarCientificoView();
		miCientificoServ = new CientificoServ();
		cientificoController = new CientificoController();

		/* Se establecen las relaciones entre clases */
		myMenuView.setProyectoCoordinator(proyectoController);
		myMenuView.setCientificoCoordinator(cientificoController);

		myRegisterProyectoView.setCoordinator(proyectoController);
		mySearchProyectoView.setCoordinador(proyectoController);
		miProyectoServ.setProyectoController(proyectoController);

		myRegisterCientificoView.setCoordinator(cientificoController);
		mySearchCientificoView.setCoordinador(cientificoController);
		miCientificoServ.setCientificoController(cientificoController);

		/* Se establecen relaciones con la clase coordinador */
		proyectoController.setMyMenuView(myMenuView);
		proyectoController.setMyRegisterProyectoView(myRegisterProyectoView);
		proyectoController.setMySearchProyectoView(mySearchProyectoView);
		proyectoController.setProyectoServ(miProyectoServ);

		cientificoController.setMyMenuView(myMenuView);
		cientificoController.setMyRegisterCientificoView(myRegisterCientificoView);
		cientificoController.setMySearchCientificoView(mySearchCientificoView);
		cientificoController.setCientificoServ(miCientificoServ);

		myMenuView.setVisible(true);
	}

}
