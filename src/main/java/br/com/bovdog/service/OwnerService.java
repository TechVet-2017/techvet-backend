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
	@Path("/owners/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public void createOwner(@FormParam(value = "cpf") Long cpf ,
								   @FormParam(value = "ownerName") String ownerName ,
								   @FormParam(value = "ownerLastName") String ownerLastName ,
								   @FormParam(value = "phoneNumber") Long phoneNumber ,
								   @FormParam(value = "address") String address){
		
		Owner owner = new Owner();
		owner.setCpf(cpf);
		owner.setOwnerName(ownerName);
		owner.setOwnerLastName(ownerLastName);
		owner.setPhoneNumber(phoneNumber);
		owner.setAddress(address);		
		
		OwnerDAO dao = new OwnerDAO();
		dao.updateOwner(owner);
	}
	
	@POST
	@Path("/owners/update")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public void updateOwner(@FormParam(value = "cpf") Long cpf ,
								   @FormParam(value = "ownerName") String ownerName ,
								   @FormParam(value = "ownerLastName") String ownerLastName ,
								   @FormParam(value = "phoneNumber") Long phoneNumber ,
								   @FormParam(value = "address") String address){
		
		Owner owner = new Owner();
		owner.setCpf(cpf);
		owner.setOwnerName(ownerName);
		owner.setOwnerLastName(ownerLastName);
		owner.setPhoneNumber(phoneNumber);
		owner.setAddress(address);		
		
		OwnerDAO dao = new OwnerDAO();
		dao.updateOwner(owner);
	}
	
	@DELETE
	@Path("/owners/delete")
	@Produces("application/json")
	public void deleteOwner(@FormParam(value = "cpf") Long cpf ){
		OwnerDAO dao = new OwnerDAO();
		dao.deleteOwner(cpf);
	}
	

}
