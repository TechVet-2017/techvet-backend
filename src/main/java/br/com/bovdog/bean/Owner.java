package br.com.bovdog.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	// create relationship between owner and patient
	@ManyToMany
    @JoinTable(name="owners_has_patients", joinColumns=
    {@JoinColumn(name="patient_id")}, inverseJoinColumns=
      {@JoinColumn(name="owner_id")})
	private Collection<Patient> patients = new ArrayList<>();
	
	public Collection<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Collection<Patient> patients) {
		this.patients = patients;
	}
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
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
