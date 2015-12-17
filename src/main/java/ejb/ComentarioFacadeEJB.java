package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class ComentarioFacadeEJB extends AbstractFacade<Comentario> implements ComentarioFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public ComentarioFacadeEJB() {
		super(Comentario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
