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

public class RegistrarCientificoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CientificoController cientificoController; // objeto personaController que permite la relacion entre esta
														// clase y la
	// clase PersonaController
	private JLabel lblWindowTitle;
	private JTextField textDNI, textNomApels;

	private JLabel lblDNI, lblNomApels;
	private JButton btnSave, btnCancel;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de registro
	 */
	public RegistrarCientificoView() {

		btnSave = new JButton();
		btnSave.setBounds(80, 177, 120, 25);
		btnSave.setText("Registrar");

		btnCancel = new JButton();
		btnCancel.setBounds(220, 177, 120, 25);
		btnCancel.setText("Cancelar");

		lblWindowTitle = new JLabel();
		lblWindowTitle.setText("NUEVO CIENTIFICO");
		lblWindowTitle.setBounds(118, 40, 234, 30);
		lblWindowTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblDNI = new JLabel();
		lblDNI.setText("DNI");
		lblDNI.setBounds(20, 95, 80, 25);
		getContentPane().add(lblDNI);

		lblNomApels = new JLabel();
		lblNomApels.setText("NomApels");
		lblNomApels.setBounds(20, 131, 80, 25);
		getContentPane().add(lblNomApels);

		textDNI = new JTextField();
		textDNI.setBounds(80, 95, 290, 25);
		getContentPane().add(textDNI);

		textNomApels = new JTextField();
		textNomApels.setBounds(80, 131, 290, 25);
		getContentPane().add(textNomApels);

		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
		getContentPane().add(lblWindowTitle);
		limpiar();
		setSize(458, 264);
		setTitle("Registrar Cientifico");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	private void limpiar() {
		textDNI.setText("");
		textNomApels.setText("");
	}

	public void setCoordinator(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Cientifico miCientifico = new Cientifico();
				miCientifico.setDNI(textDNI.getText());
				miCientifico.setNomApels(textNomApels.getText());

				cientificoController.añadirCientifico(miCientifico);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al insertar los datos", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}

}
