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

public class BuscarProyectoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController; // objeto personaController que permite la relacion entre esta clase
													// y la
													// clase personaController
	private JLabel lblTitle;
	private JTextField textId, textNombre, textHoras;
	private JLabel lblId, lblNombre, lblHoras;
	private JButton btnRegistrar, btnCancelar, btnBuscar, btnModificar, btnBorrar;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de busqueda
	 */
	public BuscarProyectoView() {

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(32, 220, 120, 25);
		btnRegistrar.setText("Registrar");
		btnRegistrar.setEnabled(false);

		btnCancelar = new JButton();
		btnCancelar.setBounds(170, 245, 120, 25);
		btnCancelar.setText("Cancelar");

		btnBuscar = new JButton();
		btnBuscar.setBounds(168, 80, 100, 25);
		btnBuscar.setText("Buscar");

		btnBorrar = new JButton();
		btnBorrar.setBounds(300, 220, 120, 25);
		btnBorrar.setText("Borrar");
		btnBorrar.setEnabled(false);

		btnModificar = new JButton();
		btnModificar.setBounds(170, 220, 120, 25);
		btnModificar.setText("Modificar");

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
		lblHoras.setText("Horas");
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
		if (e.getSource() == btnRegistrar) {
			try {
				Proyecto miProyecto = new Proyecto();
				miProyecto.setId(Integer.parseInt(textId.getText()));
				miProyecto.setNombre(textNombre.getText());
				miProyecto.setHoras(textHoras.getText());

				proyectoController.modificarProyecto(miProyecto);

				if (ProyectoServ.modificarProyecto == true) {
					habilita(true, false, false, true, false, false, false);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error al insertar los datos", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == btnBuscar) {
			Proyecto miProyecto = proyectoController.buscarProyecto(textId.getText());

			if (miProyecto != null) {
				mostrarProyecto(miProyecto);
			} else if (ProyectoServ.consultarProyecto == true) {
				JOptionPane.showMessageDialog(null, "No existe proyecto con ese Id", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnModificar) {
			habilita(true, true, true, true, true, true, true);

		}

		if (e.getSource() == btnBorrar) {
			if (!textId.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el proyecto?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					proyectoController.borrarProyecto(textId.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Inserte Id", "Informacion", JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}

	}

	/**
	 * permite cargar los datos de la persona consultada
	 * 
	 * @param miProyecto
	 */
	private void mostrarProyecto(Proyecto miProyecto) {
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
	 * @param bBuscar
	 * @param bRegistrar
	 * @param bModificar
	 * @param bBorrar
	 */
	public void habilita(boolean id, boolean nombre, boolean horas, boolean bBuscar, boolean bRegistrar,
			boolean bModificar, boolean bBorrar) {
		textId.setEditable(id);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);

		btnBuscar.setEnabled(bBuscar);
		btnRegistrar.setEnabled(bRegistrar);
		btnModificar.setEnabled(bModificar);
		btnBorrar.setEnabled(bBorrar);
	}

}
