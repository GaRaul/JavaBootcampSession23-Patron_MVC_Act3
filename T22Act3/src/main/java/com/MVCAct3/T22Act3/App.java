package com.MVCAct3.T22Act3;

import com.MVCAct3.T22Act3.controller.ClientController;
import com.MVCAct3.T22Act3.controller.VideoController;
import com.MVCAct3.T22Act3.model.service.ClientServ;
import com.MVCAct3.T22Act3.model.service.VideoServ;
import com.MVCAct3.T22Act3.view.*;
import com.MVCAct3.T22Act3.view.cientifico.RegisterCientificoView;
import com.MVCAct3.T22Act3.view.cientifico.SearchCientificoView;
import com.MVCAct3.T22Act3.view.proyecto.RegisterClientView;
import com.MVCAct3.T22Act3.view.proyecto.SearchClientView;

/**
 * Hello world!
 *
 */
public class App 
{
	ClientServ myClientServ;
	VideoServ myVideoServ;
	MenuView myMenuView;
	SearchClientView mySearchClientView;
	RegisterClientView myRegisterClientView;
	SearchCientificoView mySearchVideoView;
	RegisterCientificoView myRegisterVideoView;
	ClientController clientController;
	VideoController videoController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App miPrincipal=new App();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		myMenuView=new MenuView();
		
		myRegisterClientView=new RegisterClientView();
		mySearchClientView= new SearchClientView();
		myClientServ=new ClientServ();
		clientController= new ClientController();
		
		myRegisterVideoView=new RegisterCientificoView();
		mySearchVideoView= new SearchCientificoView();
		myVideoServ=new VideoServ();
		videoController= new VideoController();
		
		/*Se establecen las relaciones entre clases*/
		myMenuView.setClientCoordinator(clientController);
		myMenuView.setVideoCoordinator(videoController);
		
		myRegisterClientView.setCoordinator(clientController);
		mySearchClientView.setCoordinador(clientController);
		myClientServ.setProyectoController(clientController);
		
		myRegisterVideoView.setCoordinator(videoController);
		mySearchVideoView.setCoordinador(videoController);
		myVideoServ.setVideoController(videoController);
		
		/*Se establecen relaciones con la clase coordinador*/
		clientController.setMyMenuView(myMenuView);
		clientController.setMyRegisterClientView(myRegisterClientView);
		clientController.setMySearchClientView(mySearchClientView);
		clientController.setClientServ(myClientServ);
		
		videoController.setMyMenuView(myMenuView);
		videoController.setMyRegisterVideoView(myRegisterVideoView);
		videoController.setMySearchVideoView(mySearchVideoView);
		videoController.setVideoServ(myVideoServ);
				
		myMenuView.setVisible(true);
	}

}
