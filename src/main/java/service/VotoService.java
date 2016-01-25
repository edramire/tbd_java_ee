package service;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import helper.ResponseHelper;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import auth.Credentials;
import auth.Credentials2;
import facade.UsuarioFacade;
import facade.VotoFacade;
import model.Usuario;
import model.Voto;

@Path("/Voto")
public class VotoService {
	@EJB 
	VotoFacade votoFacadeEJB;
	
	Logger logger = Logger.getLogger(VotoService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Voto> findAll(){
		return votoFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Voto find_id(@PathParam("id") Integer id) {
        return votoFacadeEJB.find(id);
    }

	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Voto entity) {
		votoFacadeEJB.create(entity);		
    }


}
