/*
 * File: Owner.java
 * Description: Defines owner object and his attributes. 
 */
package br.com.bovdog.bean;

// imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class that describes the owner, and contains the information and methods it requires.
 * @author flavio
 * @version 1.0
 */
@Entity
public class Owner {

	@Id
	@GeneratedValue
	private int id;
	private String cpf; //Individual Registry in Brazil
	private String ownerName;
	private String ownerLastName;
	private String phoneNumber;
	private String zipCode;
	private String publicPlace;
	private Long addressNumber;
	private String neighborhood;
	private String complement;
	private String city;
	private String district;
	
	/**
	 * Identifier owner get method.
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Identifier owner set method. 
	 * @param ownerId
	 */
	public void setId(int ownerId) {
		this.id = ownerId;
	}
	
	/**
	 * Owner's neighborhood get method.
	 * @return neighborhood
	 */
	public String getNeighborhood() {
		return this.neighborhood;
	}
	
	/**
	 * Owner's neighborhood set method.
	 * @param neighborhood
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	/**
	 * Owner's city get method.
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Owner's city set method.
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Owner's cpf get method.
	 * @return cpf
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/**
	 * Owner's cpf set method.
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Owner name get method.
	 * @return ownerName
	 */
	public String getOwnerName() {
		return this.ownerName;
	}
	
	/**
	 * Owner name set method.
	 * @param ownerName
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	/**
	 * Owner last name get method.
	 * @return ownerLastName
	 */
	public String getOwnerLastName() {
		return this.ownerLastName;
	}
	
	/**
	 * Owner last name set method.
	 * @param ownerLastName
	 */
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	
	/**
	 * Owner's phone number get method.
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * Owner's phone number set method.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Owner's zip code get method.
	 * @return zipCode
	 */
	public String getZipCode() {
		return this.zipCode;
	}
	
	/**
	 * Owner's zip code set method.
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Owner's district get method.
	 * @return district
	 */
	public String getDistrict() {
		return this.district;
	}
	
	/**
	 * Owner's district set method.
	 * @param district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	
	/**
	 * Owner's public place get method.
	 * @return publicPlace
	 */
	public String getPublicPlace() {
		return this.publicPlace;
	}
	
	/**
	 * Owner's public place set method.
	 * @param publicPlace
	 */
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}
	
	/**
	 * Owner's address number get method.
	 * @return addressNumber
	 */
	public Long getAddressNumber() {
		return this.addressNumber;
	}
	
	/**
	 * Owner's address number set method.
	 * @param addressNumber
	 */
	public void setAddressNumber(Long addressNumber) {
		this.addressNumber = addressNumber;
	}
	
	/**
	 * Owner's complement get method.
	 * @return complement
	 */
	public String getComplement() {
		return this.complement;
	}
	
	/**
	 * Owner's complement set method.
	 * @param complement
	 */
	public void setComplement(String complement) {
		this.complement = complement;
	}
}