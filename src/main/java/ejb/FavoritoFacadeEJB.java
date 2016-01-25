package ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	public List<Favorito> find_user(Integer id){
		List<Favorito> test = null;
		try{ 
			test= (List<Favorito>) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u WHERE u.usuario_idUsuario = :ID").setParameter("ID", id).getResultList();
			return test;
            
		}catch (Exception e){ return test;}
		
	}

	@Override
	public List<Core> find_oferta(Integer id) {
		List<Core> test = new ArrayList<Core>();
		List<Favorito> help=null;
		int ctd=0;
			help= (List<Favorito>) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u WHERE u.usuario_idUsuario = :ID").setParameter("ID", id).getResultList();
			for (Favorito fav :help){
				test.add(ctd,(Core)em.createQuery("SELECT u FROM Core u WHERE u.idServicio = :ID").setParameter("ID", fav.getServicio_idServicio()).getSingleResult());
				ctd++;
			}
			return test;
	}

}
