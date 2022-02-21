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

public class SearchCientificoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CientificoController cientificoController; // objeto personaController que permite la relacion entre esta
														// clase y la
	// clase personaController
	private JLabel lblWindowTitle;
	private JTextField textDNI, textNomApels;
	private JLabel lblDNI, lblNomApels;
	private JButton btnSave, btnCancel, btnSearch, btnModify, btnDelete;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de busqueda
	 */
	public SearchCientificoView() {

		btnSave = new JButton();
		btnSave.setBounds(40, 177, 120, 25);
		btnSave.setText("Registrar");
		btnSave.setEnabled(false);

		btnCancel = new JButton();
		btnCancel.setBounds(170, 213, 120, 25);
		btnCancel.setText("Cancelar");

		btnSearch = new JButton();
		btnSearch.setBounds(211, 80, 100, 25);
		btnSearch.setText("Buscar");

		btnDelete = new JButton();
		btnDelete.setBounds(300, 177, 120, 25);
		btnDelete.setText("Borrar");
		btnDelete.setEnabled(false);

		btnModify = new JButton();
		btnModify.setBounds(170, 177, 120, 25);
		btnModify.setText("Modificar");

		lblWindowTitle = new JLabel();
		lblWindowTitle.setText("BUSCAR CIENTIFICOS");
		lblWindowTitle.setBounds(126, 39, 245, 30);
		lblWindowTitle.setFont(new java.awt.Font("Verdana", 1, 18));

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

		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);

		getContentPane().add(btnCancel);
		getContentPane().add(btnSearch);
		getContentPane().add(btnModify);
		getContentPane().add(btnDelete);
		getContentPane().add(btnSave);
		getContentPane().add(lblWindowTitle);
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
		if (e.getSource() == btnSave) {
			try {
				Cientifico miCientifico = new Cientifico();
				miCientifico.setDNI(textDNI.getText());
				miCientifico.setNomApels(textNomApels.getText());

				cientificoController.modificarCientifico(miCientifico);

				if (CientificoServ.modifyCientifico == true) {
					habilita(true, false, true, false, false, false);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Data insert Error", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == btnSearch) {
			Cientifico miCientifico = cientificoController.buscarCientifico(textDNI.getText());

			if (miCientifico != null) {
				mostrarCientifico(miCientifico);
			} else if (CientificoServ.consultCientifico == true) {
				JOptionPane.showMessageDialog(null, "Cientifico doesn't exist", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnModify) {
			habilita(true, true, true, true, true, true);

		}

		if (e.getSource() == btnDelete) {
			if (!textDNI.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure to delete a cientifico?",
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					cientificoController.borrarCientifico(textDNI.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Insert DNI", "Information", JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}

	}

	/**
	 * permite cargar los datos de la persona consultada
	 * 
	 * @param myClient
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
	 * @param bSearch
	 * @param bSave
	 * @param bModify
	 * @param bDelete
	 */
	public void habilita(boolean DNI, boolean nomApels, boolean bSearch, boolean bSave, boolean bModify, boolean bDelete) {
		textDNI.setEditable(DNI);
		textNomApels.setEditable(nomApels);

		btnSearch.setEnabled(bSearch);
		btnSave.setEnabled(bSave);
		btnModify.setEnabled(bModify);
		btnDelete.setEnabled(bDelete);
	}

}
