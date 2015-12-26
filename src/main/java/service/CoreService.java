package service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Context;
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
import auth.Credentials3;
import facade.CoreFacade;
import model.Core;

@Path("/Core")
public class CoreService {
	
	@EJB 
	CoreFacade coreFacadeEJB;
	
	Logger logger = Logger.getLogger(CoreService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Core> findAll(){
		return coreFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Core find_id(@PathParam("id") Integer id) {
        return coreFacadeEJB.find(id);
    }

	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create2(@Context HttpHeaders httpHeaders,Credentials3 input) {
		Core entity=new Core();
		Integer idu=input.idu;
		Integer idcom=input.idcom;
		Integer idcat=input.idcat;
		String descripcion=input.descripcion;
		entity.setDescripcion(descripcion);
		String precio= input.precio;
		entity.setPrecio(precio);
		String duracion = input.duracion;
		entity.setDuracion(duracion);
		String titulo = input.titulo;
		entity.setTitulo(titulo);
		Date fecha = input.fecha;
		entity.setFecha(fecha);
		entity.setUsuario_idUsuario(idu);
		entity.setComunidad_idComunidad(idcom);
		entity.setCategoria_idCategoria(idcat);
        coreFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Core entity){
		entity.setIdServicio(id);
		coreFacadeEJB.edit(entity);
	}
}