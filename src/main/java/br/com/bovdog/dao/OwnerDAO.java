package br.com.bovdog.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.bovdog.bean.Owner;

//create class Owner DAO for database communication.
public class OwnerDAO {
	private final String URL = "jdbc:mysql://localhost/techvet?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	// create method for creation of owners in database.
	public void createOwner(Owner owner){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "INSERT INTO `owner` (id_owner, cpf, owner_name, owner_last_name, phone_number, zip_code, "
				+ "district, public_place, address_number) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// treatment to ensure the successful insert of the operation.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, owner.getOwnerId());
			preparedStatement.setLong(2, owner.getCpf());
			preparedStatement.setString(3, owner.getOwnerName());
			preparedStatement.setString(4, owner.getOwnerLastName());
			preparedStatement.setLong(5, owner.getPhoneNumber());
			preparedStatement.setLong(6, owner.getZipCode());
			preparedStatement.setString(7, owner.getDistrict());
			preparedStatement.setString(8, owner.getPublicPlace());
			preparedStatement.setLong(9, owner.getAddressNumber());
			preparedStatement.executeUpdate();
			
		// return error if caught SQL exception.
		} catch(SQLException exception) {
			exception.printStackTrace();
		
		// return error if caught class exception.	
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		
		// close SQL statement and database connection. 
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}
	
	public void updateOwner(Owner owner){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "UPDATE owner SET owner_name = ?, owner_last_name = ?, phone_number = ?, zip_code = ?, "
				+ "district = ?, public_place = ?, address_number = ?  "
				+ "WHERE cpf = ? ";
		
		// treatment to ensure the successful update of the operation.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, owner.getOwnerName());
			preparedStatement.setString(2, owner.getOwnerLastName());
			preparedStatement.setLong(3, owner.getPhoneNumber());
			preparedStatement.setLong(4, owner.getZipCode());
			preparedStatement.setString(5, owner.getDistrict());
			preparedStatement.setString(6, owner.getPublicPlace());
			preparedStatement.setLong(7, owner.getAddressNumber());
			preparedStatement.executeUpdate();
		
		// return error if caught SQL exception.	
		} catch(SQLException exception) {
			exception.printStackTrace();
		
		// return error if caught class exception.	
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		
		// close SQL statement and database connection.  
		} finally {
			
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
				
			// return error if caught SQL exception.	
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.	
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}
		
	public void deleteOwner(Long cpf){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "DELETE FROM owner WHERE cpf = ?";
		
		// treatment to ensure the successful delete of the operation.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, cpf);
			preparedStatement.executeUpdate();
		
		// return error if caught SQL exception.	
		} catch(SQLException exception) {
			exception.printStackTrace();
		
		// return error if caught class exception.	
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
	
		// close SQL statement and database connection.  		
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.	
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.		
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}

	public void deleteOwnerById(int ownerId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "DELETE FROM owner WHERE id_owner = ?";
	
		// treatment to ensure the successful delete of the operation.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, ownerId);
			preparedStatement.executeUpdate();
		
		// return error if caught SQL exception.		
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		// return error if caught class exception.
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			
		// close SQL statement and database connection. 
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}
	
	// create method to select a specific owner from table by name.
	public List<Owner> findOwnerByName(String insertedName){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner WHERE owner_name like CONCAT('%', ? ,'%')";
		
		// treatment for existence of desired owner name.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, insertedName);
			ResultSet results = preparedStatement.executeQuery();
			
			/*
			 * if any results exist in one list, it increments Owner attributes 
			 * in the next list.
			 */
			while(results.next()){
				Owner owner = new Owner();
				owner.setOwnerId(results.getInt("id_owner"));
				owner.setCpf(results.getLong("cpf"));
				owner.setOwnerName(results.getString("owner_name"));
				owner.setOwnerLastName(results.getString("owner_last_name"));
				owner.setPhoneNumber(results.getLong("phone_number"));
				owner.setZipCode(results.getLong("zip_code"));
				owner.setDistrict(results.getString("district"));
				owner.setPublicPlace(results.getString("plubic_place"));
				owner.setAddressNumber(results.getLong("address_number"));
				owners.add(owner);
			}
			
		// return error if caught SQL exception
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		// return error if caught class exception
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		return owners;
	}
	
	// create method to select a specific owner from table by cpf.
	public List<Owner> findOwnerByCpf(Long insertedCpf){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner WHERE cpf like CONCAT('%',?,'%')";
		
		// treatment for existence of desired owner cpf.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, insertedCpf);
			ResultSet results = preparedStatement.executeQuery();
			
			/*
			 * if any results exist in one list, it increments Owner attributes 
			 * in the next list.
			 */
			while(results.next()){
				Owner owner = new Owner();
				owner.setOwnerId(results.getInt("id_owner"));
				owner.setCpf(results.getLong("cpf"));
				owner.setOwnerName(results.getString("owner_name"));
				owner.setOwnerLastName(results.getString("owner_last_name"));
				owner.setPhoneNumber(results.getLong("phone_number"));
				owner.setZipCode(results.getLong("zip_code"));
				owner.setDistrict(results.getString("district"));
				owner.setPublicPlace(results.getString("plubic_place"));
				owner.setAddressNumber(results.getLong("address_number"));
				owners.add(owner);
			}
			
		// return error if caught SQL exception
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		// return error if caught class exception
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			
		// close SQL statement and database connection. 
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception	
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		// returns wanted owners.
		return owners;
	}	
	
	// create method to select a specific owner from table by phone number.
	public List<Owner> findOwnerByPhoneNumber(Long insertedPhoneNumber){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner WHERE phone_number like CONCAT('%',?,'%')";
		
		// treatment for existence of desired owner phone number.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, insertedPhoneNumber);
			ResultSet results = preparedStatement.executeQuery();
			
			/*
			 * if any results exist in one list, it increments Owner attributes 
			 * in the next list.
			 */
			while(results.next()){
				Owner owner = new Owner();
				owner.setOwnerId(results.getInt("id_owner"));
				owner.setCpf(results.getLong("cpf"));
				owner.setOwnerName(results.getString("owner_name"));
				owner.setOwnerLastName(results.getString("owner_last_name"));
				owner.setPhoneNumber(results.getLong("phone_number"));
				owner.setZipCode(results.getLong("zip_code"));
				owner.setDistrict(results.getString("district"));
				owner.setPublicPlace(results.getString("plubic_place"));
				owner.setAddressNumber(results.getLong("address_number"));	
				owners.add(owner);
			}
			
		// return error if caught SQL exception
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		// return error if caught class exception
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			
		// close SQL statement and database connection.
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		// returns wanted owners.
		return owners;	
	}
	
	// create method getAllPatients to return list of Owners.
	public List<Owner> getAllOwners(){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner";
		
		// treatment for increment in Owner list.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			ResultSet results = preparedStatement.executeQuery();
			
			/*
			 * if any results exist in one list, it increments Owner attributes 
			 * in the next list.
			 */
			while(results.next()){
				Owner owner = new Owner();
				owner.setOwnerId(results.getInt("id_owner"));
				owner.setCpf(results.getLong("cpf"));
				owner.setOwnerName(results.getString("owner_name"));
				owner.setOwnerLastName(results.getString("owner_last_name"));
				owner.setPhoneNumber(results.getLong("phone_number"));
				owner.setZipCode(results.getLong("zip_code"));
				owner.setDistrict(results.getString("district"));
				owner.setPublicPlace(results.getString("public_place"));
				owner.setAddressNumber(results.getLong("address_number"));
				owners.add(owner);
			}
			
		// return error if caught SQL exception.
		} catch(SQLException exception) {
			exception.printStackTrace();
		
		// return error if caught class exception.
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			
		// close SQL statement and database connection. 
		} finally {
			try { 
				
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			// return error if caught SQL exception.
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		
		// return Owner list.
		return owners;
	}

}
