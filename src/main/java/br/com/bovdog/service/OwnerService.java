package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import br.com.bovdog.bean.Owner;
import br.com.bovdog.dao.OwnerDAO;

@Path("/OwnerService")

public class OwnerService {
	
	@GET
	@Path("/owners")
	@Produces("application/json")
	public List<Owner> getAllOwners(){
		OwnerDAO dao = new OwnerDAO();
		return dao.getAllOwners();
	}
	
	@POST
	@Path("/owners/findbyname")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Owner> findOwnerByName(@FormParam(value = "insertedName") String insertedName){
		OwnerDAO dao = new OwnerDAO();
		return dao.findOwnerByName(insertedName);
	}

	@POST
	@Path("/owners/findbycpf")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Owner> findOwnerByCpf(@FormParam(value = "insertedCpf") Long insertedCpf){
		OwnerDAO dao = new OwnerDAO();
		return dao.findOwnerByCpf(insertedCpf);
	}
	
	@POST
	@Path("/owners/findbyphone")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Owner> findOwnerByPhoneNumber(@FormParam(value = "insertedPhoneNumber") Long insertedPhoneNumber){
		OwnerDAO dao = new OwnerDAO();
		return dao.findOwnerByPhoneNumber(insertedPhoneNumber);
	}
	@POST
	@Path("/owners/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Owner createOwner(@FormParam(value = "cpf") Long cpf ,
								   @FormParam(value = "ownerName") String ownerName ,
								   @FormParam(value = "ownerLastName") String ownerLastName ,
								   @FormParam(value = "phoneNumber") Long phoneNumber ,
								   @FormParam(value = "zipCode") Long zipCode ,
								   @FormParam(value = "district") String district ,
								   @FormParam(value = "publicPlace") String publicPlace ,
								   @FormParam(value = "addressNumber") Long addressNumber){
		
		Owner owner = new Owner();
		owner.setCpf(cpf);
		owner.setOwnerName(ownerName);
		owner.setOwnerLastName(ownerLastName);
		owner.setPhoneNumber(phoneNumber);
		owner.setZipCode(zipCode);
		owner.setDistrict(district);
		owner.setPublicPlace(publicPlace);
		owner.setAddressNumber(addressNumber);		
		
		OwnerDAO dao = new OwnerDAO();
		dao.createOwner(owner);
		return owner;
	}
	
	@POST
	@Path("/owners/update")
	@Consumes("application/x-www-form-urlencoded")
	public void updateOwner(@FormParam(value = "cpf") Long cpf ,
								   @FormParam(value = "ownerName") String ownerName ,
								   @FormParam(value = "ownerLastName") String ownerLastName ,
								   @FormParam(value = "phoneNumber") Long phoneNumber ,
								   @FormParam(value = "zipCode") Long zipCode ,
								   @FormParam(value = "district") String district ,
								   @FormParam(value = "publicPlace") String publicPlace ,
								   @FormParam(value = "addressNumber") Long addressNumber){
		
		Owner owner = new Owner();
		owner.setCpf(cpf);
		owner.setOwnerName(ownerName);
		owner.setOwnerLastName(ownerLastName);
		owner.setPhoneNumber(phoneNumber);
		owner.setZipCode(zipCode);
		owner.setDistrict(district);
		owner.setPublicPlace(publicPlace);
		owner.setAddressNumber(addressNumber);
		
		OwnerDAO dao = new OwnerDAO();
		dao.updateOwner(owner);
	}
	
	@DELETE
	@Path("/owners/delete")
	public void deleteOwner(@FormParam(value = "cpf") Long cpf ){
		OwnerDAO dao = new OwnerDAO();
		dao.deleteOwner(cpf);
	}
	

}
