package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class Core_2FacadeEJB extends AbstractFacade<Core_2> implements Core_2Facade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public Core_2FacadeEJB() {
		super(Core_2.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
