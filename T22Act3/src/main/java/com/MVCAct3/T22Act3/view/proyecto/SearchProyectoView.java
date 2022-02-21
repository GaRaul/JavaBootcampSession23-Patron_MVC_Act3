package com.MVCAct3.T22Act3.view.proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.MVCAct3.T22Act3.controller.ProyectoController;
import com.MVCAct3.T22Act3.model.dto.Proyecto;
import com.MVCAct3.T22Act3.model.service.ProyectoServ;

public class SearchProyectoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController; // objeto personaController que permite la relacion entre esta clase y la
												// clase personaController
	private JLabel lblTitle;
	private JTextField textId, textNombre, textHoras;
	private JLabel lblId, lblNombre, lblHoras;
	private JButton btnSave, btnCancel, btnSearch, btnModify, btnDelete;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de busqueda
	 */
	public SearchProyectoView() {

		btnSave = new JButton();
		btnSave.setBounds(32, 220, 120, 25);
		btnSave.setText("Registrar");
		btnSave.setEnabled(false);

		btnCancel = new JButton();
		btnCancel.setBounds(170, 245, 120, 25);
		btnCancel.setText("Cancelar");

		btnSearch = new JButton();
		btnSearch.setBounds(168, 80, 100, 25);
		btnSearch.setText("Buscar");

		btnDelete = new JButton();
		btnDelete.setBounds(300, 220, 120, 25);
		btnDelete.setText("Borrar");
		btnDelete.setEnabled(false);

		btnModify = new JButton();
		btnModify.setBounds(170, 220, 120, 25);
		btnModify.setText("Modificar");

		lblTitle = new JLabel();
		lblTitle.setText("BUSCAR PROYECTOS");
		lblTitle.setBounds(128, 30, 242, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblId = new JLabel();
		lblId.setText("Id");
		lblId.setBounds(20, 80, 80, 25);
		getContentPane().add(lblId);

		lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(20, 120, 80, 25);
		getContentPane().add(lblNombre);

		lblHoras = new JLabel();
		lblHoras.setText("Surname");
		lblHoras.setBounds(20, 156, 80, 25);
		getContentPane().add(lblHoras);

		textId = new JTextField();
		textId.setBounds(71, 80, 80, 25);
		getContentPane().add(textId);

		textNombre = new JTextField();
		textNombre.setBounds(71, 120, 349, 25);
		getContentPane().add(textNombre);

		textHoras = new JTextField();
		textHoras.setBounds(71, 156, 349, 25);
		textHoras.setEditable(false);
		getContentPane().add(textHoras);

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
		getContentPane().add(lblTitle);
		limpiar();

		setSize(480, 320);
		setTitle("Buscar Proyecto");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Proyecto miProyecto = new Proyecto();
				miProyecto.setId(Integer.parseInt(textId.getText()));
				miProyecto.setNombre(textNombre.getText());
				miProyecto.setHoras(textHoras.getText());

				proyectoController.modificarProyecto(miProyecto);

				if (ProyectoServ.modifyProyecto == true) {
					habilita(true, false, false, true, false, false, false);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Data insert Error", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == btnSearch) {
			Proyecto miProyecto = proyectoController.buscarProyecto(textId.getText());

			if (miProyecto != null) {
				mostrarProyecto(miProyecto);
			} else if (ProyectoServ.consultProyecto == true) {
				JOptionPane.showMessageDialog(null, "Proyecto doesn't exist", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnModify) {
			habilita(true, true, true, true, true, true, true);

		}

		if (e.getSource() == btnDelete) {
			if (!textId.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure to delete a proyecto?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					proyectoController.borrarProyecto(textId.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Insert document number", "Information",
						JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}

	}

	/**
	 * permite cargar los datos de la persona consultada
	 * 
	 * @param miProyecto
	 */
	private void mostrarProyecto(Proyecto miProyecto) {
//		textId.setText(String.valueOf(miProyecto.getId()));
		textNombre.setText(miProyecto.getNombre() + "");
		textHoras.setText(miProyecto.getHoras() + "");

		habilita(true, false, false, true, false, true, false);
	}

	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar() {
		textId.setText("");
		textNombre.setText("");
		textHoras.setText("");

		habilita(true, false, false, true, false, false, false);
	}

	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * 
	 * @oaram Id
	 * @param NomApels
	 * @param Horas
	 * @param bSearch
	 * @param bSave
	 * @param bModify
	 * @param bDelete
	 */
	public void habilita(boolean id, boolean nombre, boolean horas, boolean bSearch, boolean bSave, boolean bModify, boolean bDelete) {
		textId.setEditable(id);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		
		btnSearch.setEnabled(bSearch);
		btnSave.setEnabled(bSave);
		btnModify.setEnabled(bModify);
		btnDelete.setEnabled(bDelete);
	}

}
