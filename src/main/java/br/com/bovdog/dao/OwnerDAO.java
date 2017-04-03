package br.com.bovdog.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.bovdog.bean.Owner;

public class OwnerDAO {
	private final String URL = "jdbc:mysql://localhost/techvet?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	public void createOwner(Owner owner){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "INSERT INTO `owner` (id_owner, cpf, owner_name, owner_last_name, phone_number, zip_code, "
				+ "district, public_place, address_number) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
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
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}
		
	public void deleteOwner(Long cpf){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "DELETE FROM owner WHERE cpf = ?";
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, cpf);
			preparedStatement.executeUpdate();
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}

	public void deleteOwnerById(int ownerId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "DELETE FROM owner WHERE id_owner = ?";
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, ownerId);
			preparedStatement.executeUpdate();
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}
	
	public List<Owner> findOwnerByName(String insertedName){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner WHERE owner_name like CONCAT('%', ? ,'%')";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, insertedName);
			ResultSet results = preparedStatement.executeQuery();
			
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
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		return owners;
	}
	public List<Owner> findOwnerByCpf(Long insertedCpf){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner WHERE cpf like CONCAT('%',?,'%')";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, insertedCpf);
			ResultSet results = preparedStatement.executeQuery();
			
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
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		return owners;
	}	
	
	public List<Owner> findOwnerByPhoneNumber(Long insertedPhoneNumber){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner WHERE phone_number like CONCAT('%',?,'%')";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, insertedPhoneNumber);
			ResultSet results = preparedStatement.executeQuery();
			
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
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		return owners;	
	}
	
	public List<Owner> getAllOwners(){
		List<Owner> owners = new ArrayList<Owner>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT * FROM owner";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			ResultSet results = preparedStatement.executeQuery();
			
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
		} catch(SQLException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			try { 
				if(preparedStatement != null){
					preparedStatement.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
					exception.printStackTrace();
			}
			try { 
				if(connection != null){
					connection.close(); 
				} else {
					// Nothing to do
				}
			} catch(SQLException exception){
				exception.printStackTrace();
			}
		}
		return owners;
	}

}
