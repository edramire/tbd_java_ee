package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class ComunidadFacadeEJB extends AbstractFacade<Comunidad> implements ComunidadFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public ComunidadFacadeEJB() {
		super(Comunidad.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
