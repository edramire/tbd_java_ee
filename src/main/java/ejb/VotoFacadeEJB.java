package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class VotoFacadeEJB extends AbstractFacade<Voto> implements VotoFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public VotoFacadeEJB() {
		super(Voto.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	public String calif(Integer iduser, Integer idservicio,Integer nota){
		try{          
			em.createQuery(
					"INSERT c INTO "+ entityClass.getName()+ " c WHERE c.Serivicio_idServicio = :idservicio and c.Usuario_idUsuario = :iduser and c.calificacion =:nota")
				    .setParameter("iduser", iduser)
				    .setParameter("idservicio", idservicio)
				    .setParameter("nota", nota)
				    
				    .getSingleResult();				
            return "bien";
            
		}catch (Exception e){}
		return "malo";
	}
}
