package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bovdog.bean.BathGrooming;

public class BathGroomingDAO {
	private final String URL = "jdbc:mysql://localhost/bathGrooming";
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
	
}
