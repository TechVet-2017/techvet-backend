package br.com.bovdog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Owner {

	@Id
	@GeneratedValue
	private int id;
	private String cpf; //Individual Registry in Brazil
	private String ownerName;
	private String ownerLastName;
	private String phoneNumber;
	private Long zipCode;
	private String publicPlace;
	private Long addressNumber;
	private String neighborhood;
	private String complement;
	private String city;
	private String district;

	public int getId() {
		return id;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setId(int ownerId) {
		this.id = ownerId;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPublicPlace() {
		return publicPlace;
	}
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}
	public Long getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(Long addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getComplement() {
		return this.complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
}
