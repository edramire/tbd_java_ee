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

}
