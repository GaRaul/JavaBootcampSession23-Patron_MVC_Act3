package com.MVCAct3.T22Act3.view.proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.MVCAct3.T22Act3.controller.ProyectoController;
import com.MVCAct3.T22Act3.model.dto.Proyecto;

public class RegistrarProyectoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController; // objeto personaController que permite la relacion entre esta clase
													// y la
													// clase PersonaController
	private JLabel lblTitulo;
	private JTextField textNombre, textHoras;

	private JLabel lblNombre, lblHoras;
	private JButton btnRegistrar, btnCancelar;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de registro
	 */
	public RegistrarProyectoView() {

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(98, 195, 120, 25);
		btnRegistrar.setText("Registrar");

		btnCancelar = new JButton();
		btnCancelar.setBounds(242, 195, 120, 25);
		btnCancelar.setText("Cancelar");

		lblTitulo = new JLabel();
		lblTitulo.setText("NUEVO PROYECTO");
		lblTitulo.setBounds(135, 45, 196, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(20, 103, 80, 25);
		getContentPane().add(lblNombre);

		lblHoras = new JLabel();
		lblHoras.setText("Horas");
		lblHoras.setBounds(20, 139, 80, 25);
		getContentPane().add(lblHoras);

		textHoras = new JTextField();
		textHoras.setBounds(80, 139, 340, 25);
		getContentPane().add(textHoras);

		textNombre = new JTextField();
		textNombre.setBounds(80, 103, 340, 25);
		getContentPane().add(textNombre);

		btnRegistrar.addActionListener(this);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnRegistrar);
		getContentPane().add(lblTitulo);
		limpiar();
		setSize(480, 302);
		setTitle("Registrar Proyecto");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	private void limpiar() {
		textNombre.setText("");
		textHoras.setText("");

	}

	public void setCoordinator(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			try {
				Proyecto miProyecto = new Proyecto();
				miProyecto.setNombre(textNombre.getText());
				miProyecto.setHoras(textHoras.getText());

				proyectoController.añadirProyecto(miProyecto);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al insertar los datos", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}

}
