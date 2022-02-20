package com.MVCAct3.T22Act3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.MVCAct3.T22Act3.model.connection.MysqlConnection;
import com.MVCAct3.T22Act3.model.dto.Cientifico;


public class CientificoDao {

	public void registrarCientifico(Cientifico miCientifico) {
		MysqlConnection conex = new MysqlConnection();

		try {
			Statement st = conex.getConnection().createStatement();
			String sql = "INSERT INTO Client VALUES ('" + miCientifico.getDNI() + "','" + miCientifico.getNomApels() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Client added", "Information", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed insertion");
		}
	}

	public Cientifico buscarCientifico(int DNI) {
		MysqlConnection conex = new MysqlConnection();
		Cientifico cientifico = new Cientifico();
		boolean existe = false;
		try {
			String sql = "SELECT * FROM Cientifico where DNI = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, DNI);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				cientifico.setDNI(res.getString("DNI"));
				cientifico.setNomApels(res.getString("NomApels"));

			}
			res.close();
			conex.desconectar();
			System.out.println(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			System.out.println(e);
		}

		if (existe) {
			return cientifico;
		} else
			return null;
	}

	public void modificarCientifico(Cientifico miCientifico) {

		MysqlConnection conex = new MysqlConnection();
		try {
			String consulta = "UPDATE Cientifico SET DNI = ?, NomApels = ? WHERE DNI = ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setString(1, miCientifico.getDNI());
			estatuto.setString(2, miCientifico.getNomApels());

			estatuto.executeUpdate();

			JOptionPane.showMessageDialog(null, " Modification Done", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);

		} catch (SQLException e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Modification Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void borrarCientifico(String DNI) {
		MysqlConnection conex = new MysqlConnection();
		try {
			String sql = "DELETE FROM Cientifico WHERE DNI='" + DNI + "'";
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
