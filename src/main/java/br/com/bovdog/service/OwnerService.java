package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import br.com.bovdog.bean.Owner;
import br.com.bovdog.dao.OwnerDAO;
import org.apache.log4j.Logger;

@Path("/owners")

public class OwnerService{
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(OwnerDAO.class);
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Owner> getAllOwners(){ // Listing all the DAO owners
		OwnerDAO dao = new OwnerDAO();
		logger.debug("GET /owners calling dao object = " + dao);
		return dao.getAllOwners();
	}
	
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public Owner getOwnerById(@PathParam("id") int id) {
		OwnerDAO dao = new OwnerDAO();
		return dao.getOwnerById(id);
	}

	@POST
	@Path("/owners/findbyname")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Owner> findOwnerByName(@FormParam(value = "insertedName") String insertedName){ // Finding owner DAO by it's name
		OwnerDAO dao = new OwnerDAO();
		logger.debug("POST /owners/findbyname with name ("+ insertedName +")calling dao object = " + dao);
		return dao.findOwnerByName(insertedName);
	}

	@POST
	@Path("/owners/findbycpf")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Owner> findOwnerByCpf(@FormParam(value = "insertedCpf") String insertedCpf){ // Finding owner DAO by it's cpf
		OwnerDAO dao = new OwnerDAO();
		logger.debug("POST /owners/findbycpf with cpf ("+ insertedCpf +") calling dao object = " + dao);
		return dao.findOwnerByCpf(insertedCpf);
	}

	@POST
	@Path("/owners/findbyphone")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Owner> findOwnerByPhoneNumber(@FormParam(value = "insertedPhoneNumber") String insertedPhoneNumber){ // Finding owner DAO by its phone number
		OwnerDAO dao = new OwnerDAO();
		logger.debug("POST /owners/findbyphone with phone ("+ insertedPhoneNumber +") calling dao object = " + dao);
		return dao.findOwnerByPhoneNumber(insertedPhoneNumber);
	}
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Owner createOwner(Owner request){

		Owner owner = new Owner();
		logger.debug("POST /owners/create with cpf = "+ request.getCpf());
		logger.debug("POST /owners/create with ownerName = "+ request.getOwnerName());
		logger.debug("POST /owners/create with ownerLastName = "+ request.getOwnerLastName());
		logger.debug("POST /owners/create with phoneNumber = "+ request.getPhoneNumber());
		logger.debug("POST /owners/create with zipCode = "+ request.getZipCode());
		logger.debug("POST /owners/create with district = "+ request.getDistrict());
		logger.debug("POST /owners/create with publicPlace = "+ request.getPublicPlace());
		logger.debug("POST /owners/create with addressNumber = "+ request.getAddressNumber());
		owner.setCpf(request.getCpf());
		owner.setOwnerName(request.getOwnerName());
		owner.setOwnerLastName(request.getOwnerLastName());
		owner.setPhoneNumber(request.getPhoneNumber());
		owner.setZipCode(request.getZipCode());
		owner.setDistrict(request.getDistrict());
		owner.setPublicPlace(request.getPublicPlace());
		owner.setAddressNumber(request.getAddressNumber());

		OwnerDAO dao = new OwnerDAO();
		dao.createOwner(owner);
		logger.debug("POST /owners/create with dao object = "+ dao);
		logger.debug("POST /owners/create with owner object = "+ owner);
		return owner;
	}

	@PUT
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	public Owner updateOwner(Owner request){

		Owner owner = new Owner();
		logger.debug("POST /owners/update with cpf = "+ request.getCpf());
		logger.debug("POST /owners/update with ownerName = "+ request.getOwnerName());
		logger.debug("POST /owners/update with ownerLastName = "+ request.getOwnerLastName());
		logger.debug("POST /owners/update with phoneNumber = "+ request.getPhoneNumber());
		logger.debug("POST /owners/update with zipCode = "+ request.getZipCode());
		logger.debug("POST /owners/update with district = "+ request.getDistrict());
		logger.debug("POST /owners/update with publicPlace = "+ request.getPublicPlace());
		logger.debug("POST /owners/update with addressNumber = "+ request.getAddressNumber());
        owner.setId(request.getId());
		owner.setCpf(request.getCpf());
		owner.setOwnerName(request.getOwnerName());
		owner.setOwnerLastName(request.getOwnerLastName());
		owner.setPhoneNumber(request.getPhoneNumber());
		owner.setZipCode(request.getZipCode());
		owner.setDistrict(request.getDistrict());
		owner.setPublicPlace(request.getPublicPlace());
		owner.setAddressNumber(request.getAddressNumber());

		OwnerDAO dao = new OwnerDAO();
		dao.updateOwner(owner);
		logger.debug("POST /owners/update with dao object = "+ dao);
		logger.debug("POST /owners/update with owner object = "+ owner);
		return dao.getOwnerById(request.getId());

	}

	@DELETE
	@Path("/{id: [0-9]+}")
	public void deleteOwner(@PathParam("id") int id ){
		OwnerDAO dao = new OwnerDAO();
		logger.debug("DELETE /owners/delete with dao object = "+ dao);
		logger.debug("DELETE /owners/delete with id object = "+ id);
		dao.deleteOwner(id);
	}


}
