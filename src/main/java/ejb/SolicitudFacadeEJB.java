package ejb;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class SolicitudFacadeEJB extends AbstractFacade<Core_2> implements SolicitudFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public SolicitudFacadeEJB() {
		super(Core_2.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public void create2(Core_2 entity){
		String descripcion=entity.getDescripcion();
		String precio= entity.getPrecio();
		String duracion = entity.getDuracion();
		String titulo = entity.getTitulo();
		Date fecha = entity.getFecha();
		Integer idCom = entity.getComunidad_idComunidad();
		Integer idCat = entity.getCategoria_idCategoria();
		Integer idUser = entity.getUsuario_idUsuario();
		try{          
			em.createQuery(
					"INSERT c INTO servifast.Core_2 c WHERE c.Categoria_idCategoria = :idCat "
							+ "and c.Usuario_idUsuario = :idUser "
							+ "and c.Comunidad_idComunidad = :idCom "
							+ "and c.titulo = :titulo "
							+ "and c.descripcion = :descripcion "
							+ "and c.precio = :precio "
							+ "and c.duracion = :duracion "
							+ "and c.fecha = :fecha ")
				    .setParameter("titulo", titulo)
				    .setParameter("descripcion", descripcion)
				    .setParameter("precio",precio)
				    .setParameter("duracion", duracion)
				    .setParameter("fecha",fecha)
				    .setParameter("idCom",idCom)
				    .setParameter("idCat",idCat)
				    .setParameter("idUser",idUser)
				    .getSingleResult();	
            
		}catch (Exception e){}
	}

}
