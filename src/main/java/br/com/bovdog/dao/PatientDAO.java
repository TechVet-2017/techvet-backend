package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.text.SimpleDateFormat; 

import br.com.bovdog.bean.Patient;

// create class Patient DAO for database communication.
public class PatientDAO {
	private final String USER = "root";
	private final String PASSWORD = "16182534";
	private final String URL = "jdbc:mysql://localhost/techvet?useSSL=false&serverTimezone=UTC";
	
	// create method getAllPatients to return list of Patients.
	public List<Patient> getAllPatients() {
		List<Patient> patients= new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		
		// treatment for increment in Patient list.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement("SELECT * FROM patient;");
			results = preparedStatement.executeQuery();
			
			/*
			 * if any results exist in one list, it increments Patients attributes 
			 * in the next list.
			 */
			while(results.next()) {
				Patient patient = new Patient();
				patient.setIdPatient(results.getInt("id_patient"));
				patient.setPatientName(results.getString("name_patient"));
				patient.setSpecie(results.getString("specie"));
				patient.setBirthday(results.getDate("birthday"));
				patient.setCoat(results.getString("coat"));
				patient.setGender(results.getString("gender").charAt(0));
				patient.setBreed(results.getString("breed"));
				patient.setSize(results.getString("size").charAt(0));
				patients.add(patient);
			}
			
		// return error if caught SQL exception.
		} catch (SQLException e) {
			e.printStackTrace();
		
		// return error if caught class exception.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		// close SQL statement and database connection. 
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if (connection != null) {
					connection.close();
				}
				
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		// return Patients list.
		return patients;
	}
	
	// create method to select a specific patient from table by id.
	public Patient getPatientById(int id) {
		Patient patient = new Patient();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM patient WHERE id_patient = ?";
		ResultSet result = null;
		
		// treatment for existence of desired patient id.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			
			// checks if patient list isn't empty.
			if (result.next()) {
				patient.setIdPatient(result.getInt("id_patient"));
				patient.setBirthday(result.getDate("birthday"));
				patient.setCoat(result.getString("coat"));
				patient.setGender(result.getString("gender").charAt(0));
				patient.setPatientName(result.getString("name_patient"));
				patient.setBreed(result.getString("breed"));
				patient.setSize(result.getString("size").charAt(0));
				patient.setSpecie(result.getString("specie"));
			}
			
		// return error if caught SQL exception.
		} catch (SQLException e) {
			e.printStackTrace();
			
		// return error if caught class exception.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		// close SQL statement and database connection. 
		} finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();
				
			}
			try {
				if (connection != null) {
					connection.close();
				}
				
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		// returns wanted patient.
		return patient;
	}
	
	// create method for creation of patients in database.
	public void createPatient(Patient patient) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		// treatment to ensure the successful conclusion of the operation.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO patient (name_patient, specie, breed, size, gender, coat) "
					   + "VALUES (?, ?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, patient.getPatientName());
			preparedStatement.setString(2, patient.getSpecie());
			preparedStatement.setString(3, patient.getBreed());
			preparedStatement.setString(4, String.valueOf(patient.getSize()));
			preparedStatement.setString(5, String.valueOf(patient.getGender()));
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//			java.util.Date util = format.parse("20170405");
//			
//			preparedStatement.setDate(6, new Date(util.getTime()));
			preparedStatement.setString(6, patient.getCoat());
			preparedStatement.executeUpdate();
			
		// return error if caught SQL exception.
		} catch(SQLException e) {
			e.printStackTrace();
			
		// return error if caught class exception.
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				// close statement requirement. 
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				
				// close connection requirement. 
				if (connection != null) {
					connection.close();
				}
				
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// method for update Patient in database.
	public void updatePatient(int idPatient,
							  String patientName, 	
							  String specie, 
							  String breed,
							  char size,
							  char gender,
							  Date birthday,
							  String coat) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE patient SET name_patient = ?,"
				   + "specie = ?,"
				   + "breed = ?"
				   + "size = ?"
				   + "gender = ?"
				   + "birthday = ?"
				   + "coat = ?"
				   + "WHERE id_patient = ?";

		// treatment to insert attributes values in database. 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, patientName);
			preparedStatement.setString(2, specie);
			preparedStatement.setString(3, breed);
			preparedStatement.setString(4, String.valueOf(size));
			preparedStatement.setString(5, String.valueOf(gender));
			preparedStatement.setDate(6, new java.sql.Date(birthday.getTime()));
			preparedStatement.setString(7, coat);
			preparedStatement.setInt(8, idPatient);
			preparedStatement.executeQuery(sql);
		
		// return error if caught SQL and class exception.
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		
		} finally {
			
			try {
				
				// close statement requirement. 
				if (preparedStatement!=null) {
					preparedStatement.close();
				}
			
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();	
			}
			
			try {
				
				// close connection requirement. 
				if (connection != null) {
					connection.close();
				}
				
			// return error if caught SQL exception.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// method to delete a specific patient.
	public void deletePatient(int idPatient) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM patient WHERE id_patient = ?";
		
		// verifies that the operation has been successful.
		try {
			Class.forName("com.mysql.cj.jdbc.Drive");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idPatient);
			preparedStatement.executeUpdate();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// close statement requirement. 
				if (preparedStatement!=null) {
					preparedStatement.close();
				}
			
			// return error if caught SQL exception.
			} catch(SQLException e) {
				e.printStackTrace();	
			}
			try {
				
				// close connection requirement. 
				if (connection != null) {
					connection.close();
				}
				
			// return error if caught SQL exception.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
