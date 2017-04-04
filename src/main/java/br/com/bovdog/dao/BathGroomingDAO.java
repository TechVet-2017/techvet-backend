package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bovdog.bean.BathGrooming;
public class BathGroomingDAO {
	private final String URL = "jdbc:mysql://localhost:3306/techvet?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	public List<BathGrooming> getAllBathGrooming(){
		List<BathGrooming> services = new ArrayList<BathGrooming>();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM bathGrooming");
			ResultSet results = statement.executeQuery();
			
			while(results.next()){
				BathGrooming service = new BathGrooming();
				service.setIdBathGrooming(results.getInt("idBathGrooming"));
				service.setServiceBathGrooming(results.getString("serviceBathGrooming"));
				services.add(service);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	return services;
	}
	
	public void createBathGrooming(BathGrooming bathGrooming){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO bathGrooming (serviceBathGrooming) VALUES (?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bathGrooming.getServiceBathGrooming());
			preparedStatement.executeUpdate();
			
			}catch(SQLException e) {
				e.printStackTrace();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (preparedStatement!= null) preparedStatement.close();
				} catch(SQLException e) {
						e.printStackTrace();
					};
				try {
					if (connection != null) connection.close();
				} catch(SQLException e) {
					e.printStackTrace();
				};
			}
	}
	
	public void updateBathGrooming(int idBathGrooming, String serviceBathGrooming) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE bathGrooming SET text = ? WHERE idBathGrooming = ?";
		 		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 	connection = DriverManager.getConnection(URL, USER, PASSWORD);
		 	preparedStatement = connection.prepareStatement(sql);
		 	preparedStatement.setString(1, serviceBathGrooming);
		 	preparedStatement.setInt(2, idBathGrooming);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {	
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
		 	e.printStackTrace();
		} finally {
		try { if(preparedStatement!= null) preparedStatement.close(); } catch(SQLException e) {e.printStackTrace();}
		try { if(connection != null) connection.close(); } catch(SQLException e) {e.printStackTrace();}
		 	
		}
	}
		 	
	public void deleteBathGrooming(int idBathGrooming) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
 		String sql = "DELETE FROM bathGrooming WHERE idBathGrooming = ?";
		 		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 	connection = DriverManager.getConnection(URL, USER, PASSWORD);
		 	preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idBathGrooming);
		 	preparedStatement.executeUpdate();
		 } catch(SQLException e) {
			e.printStackTrace();
		 } catch(ClassNotFoundException e) {
		 	e.printStackTrace();
		 } finally {
			 try { 
				 if(preparedStatement!= null) preparedStatement.close(); 
			 } catch(SQLException e) {
				 e.printStackTrace();
			 }
			 try { 
				 if(connection != null) connection.close(); 
			 } catch(SQLException e) {
				 e.printStackTrace();
			 }
		 }
	}
	
	
}
