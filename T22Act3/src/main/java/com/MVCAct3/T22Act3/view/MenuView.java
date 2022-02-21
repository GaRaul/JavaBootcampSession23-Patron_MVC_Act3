package com.MVCAct3.T22Act3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import com.MVCAct3.T22Act3.controller.CientificoController;
import com.MVCAct3.T22Act3.controller.ProyectoController;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ProyectoController proyectoController;
	private CientificoController cientificoController; // objeto PersonaController que permite la relacion entre esta
														// clase y
	// la clase PersonaController
	private JTextArea areaIntroduction;
	private JLabel lblTitulo, lblSeleccion;
	private JButton btnRegistrarProyecto, btnBuscarProyecto, btnRegistrarCientifico, btnBuscarCientifico;

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana principal
	 */
	public MenuView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnRegistrarProyecto = new JButton();
		btnRegistrarProyecto.setBounds(78, 280, 143, 25);
		btnRegistrarProyecto.setText("Registrar Proyecto");

		btnBuscarProyecto = new JButton();
		btnBuscarProyecto.setBounds(225, 280, 137, 25);
		btnBuscarProyecto.setText("Buscar Proyecto");

		btnRegistrarCientifico = new JButton();
		btnRegistrarCientifico.setText("Registrar Cientifico");
		btnRegistrarCientifico.setBounds(78, 311, 143, 25);
		getContentPane().add(btnRegistrarCientifico);

		btnBuscarCientifico = new JButton();
		btnBuscarCientifico.setText("Buscar Cientifico");
		btnBuscarCientifico.setBounds(225, 311, 137, 25);
		getContentPane().add(btnBuscarCientifico);

		lblTitulo = new JLabel();
		lblTitulo.setText("PATRON DE DISEÑO MVC");
		lblTitulo.setBounds(141, 38, 380, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		lblSeleccion = new JLabel();
		lblSeleccion.setText("Selecciona una opción");
		lblSeleccion.setBounds(171, 241, 250, 25);

		textoIntroduccion = "Esta aplicacion muestra un ejemplo práctico de patron de diseño MVC.\n\n"
				+ "La aplicación permite registrar, buscar, modificar y borrar registros de la base de datos de un Laboratorio.";

		areaIntroduction = new JTextArea();
		areaIntroduction.setBounds(50, 90, 380, 140);
		areaIntroduction.setEditable(false);
		areaIntroduction.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduction.setLineWrap(true);
		areaIntroduction.setText(textoIntroduccion);
		areaIntroduction.setWrapStyleWord(true);
		areaIntroduction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
				null, null, null, new java.awt.Color(0, 0, 0)));

		btnRegistrarProyecto.addActionListener(this);
		btnBuscarProyecto.addActionListener(this);

		btnRegistrarCientifico.addActionListener(this);
		btnBuscarCientifico.addActionListener(this);

		getContentPane().add(btnBuscarProyecto);
		getContentPane().add(btnRegistrarProyecto);
		getContentPane().add(lblSeleccion);
		getContentPane().add(lblTitulo);
		getContentPane().add(areaIntroduction);

		setSize(480, 386);
		setTitle("BASE DE DATOS LABORATORIO");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public void setProyectoCoordinator(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

	public void setCientificoCoordinator(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarProyecto) {
			proyectoController.showRegisterProyectoView();
		}
		if (e.getSource() == btnBuscarProyecto) {
			proyectoController.showSearchProyectoView();
		}
		if (e.getSource() == btnRegistrarCientifico) {
			cientificoController.showRegisterCientificoView();
		}
		if (e.getSource() == btnBuscarCientifico) {
			cientificoController.showSearchCientificoView();
		}
	}
}
