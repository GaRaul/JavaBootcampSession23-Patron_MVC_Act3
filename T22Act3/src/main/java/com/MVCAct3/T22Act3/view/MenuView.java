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
	private CientificoController cientificoController; // objeto PersonaController que permite la relacion entre esta clase y
												// la clase PersonaController
	private JTextArea areaIntroduction;
	private JLabel lblTitle, lblSelection;
	private JButton btnRegisterProyecto, btnSearchProyecto, btnRegisterCientifico, btnSearchCientifico;

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

		btnRegisterProyecto = new JButton();
		btnRegisterProyecto.setBounds(100, 280, 120, 25);
		btnRegisterProyecto.setText("Registrar Proyecto");

		btnSearchProyecto = new JButton();
		btnSearchProyecto.setBounds(240, 280, 120, 25);
		btnSearchProyecto.setText("Buscar Proyecto");

		btnRegisterCientifico = new JButton();
		btnRegisterCientifico.setText("Registrar Cientifico");
		btnRegisterCientifico.setBounds(100, 311, 120, 25);
		getContentPane().add(btnRegisterCientifico);

		btnSearchCientifico = new JButton();
		btnSearchCientifico.setText("Buscar Cientifico");
		btnSearchCientifico.setBounds(240, 312, 120, 25);
		getContentPane().add(btnSearchCientifico);

		lblTitle = new JLabel();
		lblTitle.setText("MVC DESIGN PATRON");
		lblTitle.setBounds(141, 38, 380, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 15));

		lblSelection = new JLabel();
		lblSelection.setText("Selecciona una opción");
		lblSelection.setBounds(171, 241, 250, 25);

		textoIntroduccion = "This application shows a practical example of MVC design Patron.\n\n"
				+ "The application allows to register, search, modify and delete registers from a Clients database.";

		areaIntroduction = new JTextArea();
		areaIntroduction.setBounds(50, 90, 380, 140);
		areaIntroduction.setEditable(false);
		areaIntroduction.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduction.setLineWrap(true);
		areaIntroduction.setText(textoIntroduccion);
		areaIntroduction.setWrapStyleWord(true);
		areaIntroduction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
				null, null, null, new java.awt.Color(0, 0, 0)));

		btnRegisterProyecto.addActionListener(this);
		btnSearchProyecto.addActionListener(this);

		btnRegisterCientifico.addActionListener(this);
		btnSearchCientifico.addActionListener(this);

		getContentPane().add(btnSearchProyecto);
		getContentPane().add(btnRegisterProyecto);
		getContentPane().add(lblSelection);
		getContentPane().add(lblTitle);
		getContentPane().add(areaIntroduction);

		setSize(480, 386);
		setTitle("CLIENTS DATABASE");
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
		if (e.getSource() == btnRegisterProyecto) {
			proyectoController.showRegisterProyectoView();
		}
		if (e.getSource() == btnSearchProyecto) {
			proyectoController.showSearchProyectoView();
		}
		if (e.getSource() == btnRegisterCientifico) {
			cientificoController.showRegisterCientificoView();
		}
		if (e.getSource() == btnSearchCientifico) {
			cientificoController.showSearchCientificoView();
		}
	}
}
