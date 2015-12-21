package ejb;

import javax.ejb.Stateless;

import java.util.UUID;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.*;

@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public UsuarioFacadeEJB() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	public String login(String username, String password){
		try{          
			em.createQuery(
					"SELECT c FROM "+ entityClass.getName()+ " c WHERE c.usuario = :Name and c.password = :pass")
				    .setParameter("Name", username)
				    .setParameter("pass", password)
				    .getSingleResult();				
            return "bien";
            
		}catch (Exception e){}
		return "malo";
	}

}
