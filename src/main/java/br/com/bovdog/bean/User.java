package br.com.bovdog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**Class for objects of users, where they will be contained, values and methods for the same.
 * @author antoniocoj, luizguilherme
 * @version 1.0
 */

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String userFullName;
	private String userName;
	private String userPassword;
	
    /** Method for returning the user id
     *  @return int - identification number*/
	public int getId() {
		return id;
	}
    /** Method for setting the user id
     * @param id
     * */
	public void setId(int id) {
		this.id = id;
	}
    /** Method for returning the user full name
     * @return String - User full name*/
	public String getUserFullName() {
		return userFullName;
	}
    /** Method for setting the user full name
     * @param userFullName*/
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
    /** Method for returning the user name
     * @return String - User name*/
	public String getUserName() {
		return userName;
	}
	/** Method for setting the user name
	 * @param userName*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** Method for returning the user password
     *  @return String - User password*/
	public String getUserPassword() {
		return userPassword;
	}
	/** Method for setting the user password
	 * @param userPassword*/
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}