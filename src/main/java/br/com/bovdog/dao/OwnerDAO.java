package br.com.bovdog.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.bovdog.bean.Owner;

public class OwnerDAO {
	private final String URL = "jdbc:mysql://localhost/techvet?useSSL=false&serverTimezone=UTC"; //url da database
	private final String USER = "root";
	private final String PASSWORD = "root";
	
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
		} catch(Exception e){
			e.printStackTrace();
		}
		return owners;
	}

}
