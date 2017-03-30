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
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("INSERT INTO owner(cpf),owner(ownerName),owner(ownerLastNAme),owner(phoneNumber),owner(address) VALUES (?),(?),(?),(?),(?)");
			statement.setLong(1, owner.getCpf());
			statement.setString(2, owner.getOwnerName());
			statement.setString(3, owner.getOwnerLastName());
			statement.setLong(4, owner.getPhoneNumber());
			statement.setString(5, owner.getAddress());
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
		
	}
	public void updateCpf(Long cpf){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE owner SET cpf=?");
			statement.setLong(1, cpf);
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
	}
	public void updateOwnerName(String ownerName){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE owner SET ownerName=?");
			statement.setString(1, ownerName);
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	public void updateOwnerLastName(String ownerLastName){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE owner SET ownerLastName=?");
			statement.setString(1, ownerLastName);
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
	}
	public void updatePhoneNumber(Long phoneNumber){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE owner SET phoneNumber=?");
			statement.setLong(1, phoneNumber);
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
	}
	public void updateAddress(String address){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE owner SET address=?");
			statement.setString(1, address);
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	public void deleteOwner(Long cpf){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("DELETE FROM owner WHERE cpf = ?");
			statement.setLong(1, cpf);
			statement.executeUpdate();
		} catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	public List<Owner> getAllOwners(){
		List<Owner> owners = new ArrayList<Owner>();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM owner");
			ResultSet results = statement.executeQuery();
			
			while(results.next()){
				Owner owner = new Owner();
				owner.setCpf(results.getLong("cpf"));
				owner.setOwnerName(results.getString("ownerName"));
				owner.setOwnerLastName(results.getString("ownerLastName"));
				owner.setPhoneNumber(results.getLong("phoneNumber"));
				owner.setAddress(results.getString("address"));	
			}
		} catch(Exception exception){
			exception.printStackTrace();
		}
		return owners;
	}

}
