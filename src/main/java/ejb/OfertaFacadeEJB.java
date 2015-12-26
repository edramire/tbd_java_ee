package ejb;

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

}
