package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;
@Local
public interface FavoritoFacade {

	public void create(Favorito entity);

	public void edit(Favorito entity);

	public void remove(Favorito entity);

	public Favorito find(Object id);

	public List<Favorito> findAll();

	public List<Favorito> findRange(int[] range);

	public int count();


}
