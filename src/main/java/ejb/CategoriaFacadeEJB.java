package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.*;
import model.*;

@Stateless
public class CategoriaFacadeEJB extends AbstractFacade<Categoria> implements CategoriaFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public CategoriaFacadeEJB() {
		super(Categoria.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}


}
