package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.bovdog.bean.Patient;

public class PatientDAO {
	private final String USER = "root";
	private final String PASSWORD = "16182534";
	private final String URL = "jdbc:mysql://localhost/chattering?useSSL=false&serverTimezone=UTC";
	
	public List<Patient> getAllPatients() {
		List<Patient> patients= new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(USER, PASSWORD, URL);
			preparedStatement = connection.prepareStatement("SELECT * FROM patient;");
			results = preparedStatement.executeQuery();
			
			while(results.next()) {
				Patient patient = new Patient();
				patient.setBirthDate(results.getDate("birthDate"));
				patient.setFurCharacteristics(results.getString("furCharacteristics"));
				patient.setGender(results.getString("gender").charAt(0));
				patient.setName(results.getString("name"));
				patient.setRace(results.getString("race"));
				patient.setSize(results.getString("size").charAt(0));
				patient.setSpecies(results.getString("spicies"));
				patient.setWeight(results.getFloat("weight"));
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return patients;
	}
	
	public Patient getPatientById(int id) {
		return null;
	}
}
