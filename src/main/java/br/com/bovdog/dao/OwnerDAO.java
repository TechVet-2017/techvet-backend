package br.com.bovdog.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.bovdog.bean.Owner;

public class OwnerDAO {
	private final String URL = "jdbc:mysql://localhost/techvet?useSSL=false&serverTimezone=UTC"; //url da database
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	public void createOwner(Owner owner){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "INSERT INTO owner(cpf),owner(ownerName),owner(ownerLastNAme),owner(phoneNumber),owner(address) VALUES (?),(?),(?),(?),(?)";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, owner.getCpf());
			preparedStatement.setString(2, owner.getOwnerName());
			preparedStatement.setString(3, owner.getOwnerLastName());
			preparedStatement.setLong(4, owner.getPhoneNumber());
			preparedStatement.setString(5, owner.getAddress());
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
	
	public void updateOwner(Long cpf, String ownerName, String ownerLastName, Long phoneNumber,String address){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "UPDATE owner SET ownerName = ?, ownerLastName = ?, phoneNumber = ?, address = ? WHERE cpf = ? ";
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, ownerName);
			preparedStatement.setString(2, ownerLastName);
			preparedStatement.setLong(3, phoneNumber);
			preparedStatement.setString(4, address);
			preparedStatement.setLong(5, cpf);
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
				owner.setCpf(results.getLong("cpf"));
				owner.setOwnerName(results.getString("ownerName"));
				owner.setOwnerLastName(results.getString("ownerLastName"));
				owner.setPhoneNumber(results.getLong("phoneNumber"));
				owner.setAddress(results.getString("address"));	
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
