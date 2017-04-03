package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.dao.BathGroomingDAO;


@Path("/BathGroomingService")
public class BathGroomingService {
	
	@GET
	@Path("/BathGroomings")
	@Produces("/application/json")
	public List<BathGrooming> getAllBathGrooming(){
		BathGroomingDAO dao = new BathGroomingDAO();
		return dao.getAllBathGrooming();
	}
	
	@POST
	@Path("/BathGroomings/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<BathGrooming> createBathGrooming(@FormParam("text") String text){
		BathGrooming bathgrooming = new BathGrooming();
		BathGroomingDAO dao = new BathGroomingDAO();
		bathgrooming.setServiceBathGrooming(text);
		dao.createBathGrooming(bathgrooming);
		return dao.getAllBathGrooming();
		
	}
	
}
