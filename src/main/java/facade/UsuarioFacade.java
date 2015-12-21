package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;

@Local
public interface UsuarioFacade {

	public void create(Usuario entity);

	public void edit(Usuario entity);

	public void remove(Usuario entity);

	public Usuario find(Object id);
	
	public Usuario find_user(Object usuario);
	
	public String login(String username, String password);
	

	public List<Usuario> findAll();

	public List<Usuario> findRange(int[] range);

	public int count();

}
