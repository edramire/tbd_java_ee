package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class FavoritoFacadeEJB extends AbstractFacade<Favorito> implements FavoritoFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public FavoritoFacadeEJB() {
		super(Favorito.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
