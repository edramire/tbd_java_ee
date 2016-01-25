package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class OfertaFacadeEJB extends AbstractFacade<Core> implements OfertaFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public OfertaFacadeEJB() {
		super(Core.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public List<Core> find_user(Integer id){
		List<Core> test = null;
		try{ 
			test= (List<Core>) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u WHERE u.usuario_idUsuario = :ID").setParameter("ID", id).getResultList();
			return test;
            
		}catch (Exception e){ return test;}
		
	}

	@Override
	public List<Core> findAllplus() {
		List<Core> test = null;
		try{ 
			test= (List<Core>) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u").getResultList();
			return test;
            
		}catch (Exception e){ return test;}
	}

}
