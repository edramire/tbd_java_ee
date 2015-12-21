package ejb;

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

}
