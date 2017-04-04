package br.com.bovdog.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int idUser;
	private String userFullName;
	private String userName;
	private String userPassword;
	
	// getters and setters for user attributes.
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}