package com.MVCAct3.T22Act3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.MVCAct3.T22Act3.model.connection.MysqlConnection;
import com.MVCAct3.T22Act3.model.dto.Proyecto;

public class ProyectoDao {

	public void registrarProyecto(Proyecto miProyecto) {
		MysqlConnection conex = new MysqlConnection();

		try {
			Statement st = conex.getConnection().createStatement();
			String sql = "INSERT INTO Client VALUES ('" + miProyecto.getId() + "','" + miProyecto.getNombre() + "', '" + miProyecto.getHoras() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Proyecto añadido", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Inserción fallida");
		}
	}

	public Proyecto buscarProyecto(int id) {
		MysqlConnection conex = new MysqlConnection();
		Proyecto proyecto = new Proyecto();
		boolean existe = false;
		try {
			String sql = "SELECT * FROM Proyecto where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				proyecto.setId(res.getInt(id));
				proyecto.setNombre(res.getString("Nombre"));
				proyecto.setHoras(res.getString("Horas"));

			}
			res.close();
			conex.desconectar();
			System.out.println(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error de conexión");
			System.out.println(e);
		}

		if (existe) {
			return proyecto;
		} else
			return null;
	}

	public void modificarProyecto(Proyecto miProyecto) {

		MysqlConnection conex = new MysqlConnection();
		try {
			String consulta = "UPDATE Proyecto SET Id = ?, Nombre = ?, Horas = ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setInt(1, miProyecto.getId());
			estatuto.setString(2, miProyecto.getNombre());
			estatuto.setString(3, miProyecto.getHoras());
			estatuto.executeUpdate();

			JOptionPane.showMessageDialog(null, " Modification Done", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);

		} catch (SQLException e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Modification Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void borrarProyecto(String id) {
		MysqlConnection conex = new MysqlConnection();
		try {
			String sql = "DELETE FROM Proyecto WHERE id='" + id + "'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, " Delete Done", "Information", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Delete Error");
		}
	}
}
