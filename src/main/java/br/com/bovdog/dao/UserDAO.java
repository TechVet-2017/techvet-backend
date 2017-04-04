package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bovdog.bean.User;

// create class User DAO for database communication.
public class UserDAO {
	private final String USER = "root";
	private final String PASSWORD = "4775";
	private final String URL = "jdbc:mysql://localhost/techvet?useSSL=false&serverTimezone=UTC";

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		
		// Treatment for increment in user list.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement ("SELECT * FROM user;");
			results = preparedStatement.executeQuery();
			
			//if any results exist in one list, it increments User attributes in the next list.
			 
			while(results.next()) {
				User user = new User();
				user.setIdUser(results.getInt("id_user"));
				user.setUserFullName(results.getString("user_full_name"));
				user.setUserName(results.getString("user_name"));
				user.setUserPassword(results.getString("user_password"));
				users.add(user);
			}
			
		// return error if caught SQL exception.
		} catch (SQLException e){
			e.printStackTrace();
			
		// return error if caught class exception.
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		
		// close SQL statement and database connection.
		} finally {
			
			try {
					if (preparedStatement != null){
						preparedStatement.close();
					} else {
						//nothing to do.
					}
			// return error if caught SQL exception.
			} catch(SQLException e){
				e.printStackTrace();
			}
			
			try {
				if (connection != null) {
					connection.close();
				} else {
					//nothing to do.
				}
			
			// return error if caught SQL exception.
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return users;
	}
	
	// create method to select a specific user from table by UserName.
	public User getUserByUserName(String userName) {
		User user = new User();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM user WHERE user_name = ?";
		ResultSet result = null;
			
		// treatment for existence of desired user id.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			result = preparedStatement.executeQuery();
				
			// checks if user list isn't empty.
			if (result.next()) {
				user.setIdUser(result.getInt("id_user"));
				user.setUserFullName(result.getString("user_full_name"));
				user.setUserName(result.getString("user_name"));
				user.setUserPassword(result.getString("user_password"));
			} else {
				//nothing to do.
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
					} else {
						//nothing to do.
					}
					
				// return error if caught SQL exception.
				} catch(SQLException e) {
					e.printStackTrace();
					
				}
				try {
					if (connection != null) {
						connection.close();
					} else {
						//nothing to do.
					}
					
				// return error if caught SQL exception.
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			// returns wanted user.
			return user;
		}
	
	// create method for creation of user in database.
		public void createUser(User user) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			// treatment to ensure the successful conclusion of the operation.
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				String sql = "INSERT INTO user (user_full_name, user_name, user_password) "
						   + "VALUES (?, ?, ?);";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getUserFullName());
				preparedStatement.setString(2, user.getUserName());
				preparedStatement.setString(3, user.getUserPassword());
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
					} else {
						//nothing to do.
					}
					
				// return error if caught SQL exception.
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				try {
					
					// close connection requirement. 
					if (connection != null) {
						connection.close();
					} else {
						//nothing to do.
					}
					
				// return error if caught SQL exception.
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// method for update user in database.
		public void updateUser(int idUser,
								  String userFullName, 	
								  String userName, 
								  String userPassword) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String sql = "UPDATE user SET user_full_name = ?, user_name = ?, user_password = ? WHERE id_user = ?";

			// treatment to insert attributes values in database. 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL,USER,PASSWORD);
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, userFullName);
				preparedStatement.setString(2, userName);
				preparedStatement.setString(3, userPassword);
				preparedStatement.setInt(4, idUser);
				preparedStatement.executeUpdate();
			
			// return error if caught SQL and class exception.
			} catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			
			} finally {
				
				try {
					
					// close statement requirement. 
					if (preparedStatement!=null) {
						preparedStatement.close();
					} else {
						//nothing to do.
					}
				
				// return error if caught SQL exception.
				} catch(SQLException e) {
					e.printStackTrace();	
				}
				
				try {
					
					// close connection requirement. 
					if (connection != null) {
						connection.close();
					} else {
						//nothing to do.
					}
					
				// return error if caught SQL exception.
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// method to delete a specific user.
		public void deleteUser(int idUser) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String sql = "DELETE FROM user WHERE id_user = ?";
			
			// verifies that the operation has been successful.
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, idUser);
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
	
}