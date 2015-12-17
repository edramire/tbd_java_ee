package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class TransaccionFacadeEJB extends AbstractFacade<Transaccion> implements TransaccionFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public TransaccionFacadeEJB() {
		super(Transaccion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
