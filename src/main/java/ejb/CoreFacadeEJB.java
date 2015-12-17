package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class CoreFacadeEJB extends AbstractFacade<Core> implements CoreFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public CoreFacadeEJB() {
		super(Core.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
