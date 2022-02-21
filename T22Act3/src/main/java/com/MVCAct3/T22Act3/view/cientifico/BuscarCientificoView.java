package com.MVCAct3.T22Act3.view.cientifico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.MVCAct3.T22Act3.controller.CientificoController;
import com.MVCAct3.T22Act3.model.dto.Cientifico;
import com.MVCAct3.T22Act3.model.service.CientificoServ;

public class BuscarCientificoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CientificoController cientificoController; // objeto personaController que permite la relacion entre esta
														// clase y la
	// clase personaController
	private JLabel lblTituloVentana;
	private JTextField textDNI, textNomApels;
	private JLabel lblDNI, lblNomApels;
	private JButton btnRegistrar, btnCancelar, btnBuscar, btnModificar, btnBorrar;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de busqueda
	 */
	public BuscarCientificoView() {

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(40, 177, 120, 25);
		btnRegistrar.setText("Registrar");
		btnRegistrar.setEnabled(false);

		btnCancelar = new JButton();
		btnCancelar.setBounds(170, 213, 120, 25);
		btnCancelar.setText("Cancelar");

		btnBuscar = new JButton();
		btnBuscar.setBounds(211, 80, 100, 25);
		btnBuscar.setText("Buscar");

		btnBorrar = new JButton();
		btnBorrar.setBounds(300, 177, 120, 25);
		btnBorrar.setText("Borrar");
		btnBorrar.setEnabled(false);

		btnModificar = new JButton();
		btnModificar.setBounds(170, 177, 120, 25);
		btnModificar.setText("Modificar");

		lblTituloVentana = new JLabel();
		lblTituloVentana.setText("BUSCAR CIENTIFICOS");
		lblTituloVentana.setBounds(126, 39, 245, 30);
		lblTituloVentana.setFont(new java.awt.Font("Verdana", 1, 18));

		lblDNI = new JLabel();
		lblDNI.setText("DNI");
		lblDNI.setBounds(20, 80, 80, 25);
		getContentPane().add(lblDNI);

		lblNomApels = new JLabel();
		lblNomApels.setText("NomApels");
		lblNomApels.setBounds(20, 120, 80, 25);
		getContentPane().add(lblNomApels);

		textDNI = new JTextField();
		textDNI.setBounds(82, 80, 119, 25);
		getContentPane().add(textDNI);

		textNomApels = new JTextField();
		textNomApels.setBounds(81, 120, 339, 25);
		getContentPane().add(textNomApels);

		btnModificar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnRegistrar.addActionListener(this);
		btnCancelar.addActionListener(this);

		getContentPane().add(btnCancelar);
		getContentPane().add(btnBuscar);
		getContentPane().add(btnModificar);
		getContentPane().add(btnBorrar);
		getContentPane().add(btnRegistrar);
		getContentPane().add(lblTituloVentana);
		limpiar();

		setSize(480, 320);
		setTitle("Buscar Cientifico");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public void setCoordinador(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			try {
				Cientifico miCientifico = new Cientifico();
				miCientifico.setDNI(textDNI.getText());
				miCientifico.setNomApels(textNomApels.getText());

				cientificoController.modificarCientifico(miCientifico);

				if (CientificoServ.modificarCientifico == true) {
					habilita(true, false, true, false, false, false);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error al insertar los datos", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == btnBuscar) {
			Cientifico miCientifico = cientificoController.buscarCientifico(textDNI.getText());

			if (miCientifico != null) {
				mostrarCientifico(miCientifico);
			} else if (CientificoServ.consultarCientifico == true) {
				JOptionPane.showMessageDialog(null, "No existen datos de cientifico con ese DNI", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnModificar) {
			habilita(true, true, true, true, true, true);

		}

		if (e.getSource() == btnBorrar) {
			if (!textDNI.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el cientifico?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					cientificoController.borrarCientifico(textDNI.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Inserte DNI", "Información", JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}

	}

	/**
	 * permite cargar los datos de la persona consultada
	 * 
	 * @param miCientifico
	 */
	private void mostrarCientifico(Cientifico miCientifico) {
		textDNI.setText(miCientifico.getDNI());
		textNomApels.setText(miCientifico.getNomApels() + "");

		habilita(true, false, true, false, true, false);
	}

	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar() {
		textDNI.setText("");
		textNomApels.setText("");

		habilita(true, false, true, false, false, false);
	}

	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * 
	 * @oaram DNI
	 * @param NomApels
	 * @param bBuscar
	 * @param bRegistrar
	 * @param bModificar
	 * @param bBorrar
	 */
	public void habilita(boolean DNI, boolean nomApels, boolean bBuscar, boolean bRegistrar, boolean bModificar,
			boolean bBorrar) {
		textDNI.setEditable(DNI);
		textNomApels.setEditable(nomApels);

		btnBuscar.setEnabled(bBuscar);
		btnRegistrar.setEnabled(bRegistrar);
		btnModificar.setEnabled(bModificar);
		btnBorrar.setEnabled(bBorrar);
	}

}
