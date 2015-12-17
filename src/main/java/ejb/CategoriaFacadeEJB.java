package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class CategoriaFacadeEJB extends AbstractFacade<Core> implements CoreFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public CategoriaFacadeEJB() {
		super(Core.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
