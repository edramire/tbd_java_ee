package ejb;

import javax.ejb.Stateless;

import java.util.UUID;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.*;

@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "ServiFast")
	private EntityManager em;
	
	public UsuarioFacadeEJB() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	public String login(String username, String password){

		try{ 
			Usuario test= (Usuario) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u WHERE u.usuario = :Name").setParameter("Name", username).getSingleResult();
			String pass=test.getPassword();
			if (pass.equals(password)){
			
            String authToken = UUID.randomUUID().toString();
            Usuario.authorizationTokensStorage.put( authToken, username );
            
            return authToken;
			}
			else{
				return pass+"   "+password;
			}
            
		}catch (Exception e){ return "mal";}
		
	}
	public String logout(String username){
		try{ 
			Query j = em.createQuery(
					"UPDATE Usuario c SET c.conectado = 0 WHERE c.usuario = :Name")
				    .setParameter("Name", username);
			int i=j.executeUpdate();
            return "bien";
            		
            
		}catch (Exception e){ return "mal";}
		
	}

	@Override
	public String find_nombre(String nombre) {
		try{
		Usuario test= (Usuario) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u WHERE u.usuario = :Name").setParameter("Name", nombre).getSingleResult();
		Integer result1=test.getIdUsuario();
		String result=result1.toString();
		return result;
		}catch (Exception e){return nombre;}
	}
	@Override
	public Usuario find_estado(String nombre) {
		Usuario test = null;
		try{
		test= (Usuario) em.createQuery("SELECT u FROM "+ entityClass.getName() + " u WHERE u.usuario = :Name").setParameter("Name", nombre).getSingleResult();
		return test;
		}catch (Exception e){return test;}
	}

}
