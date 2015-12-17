package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;
@Local
public interface ComunidadFacade {

	public void create(Comunidad entity);

	public void edit(Comunidad entity);

	public void remove(Comunidad entity);

	public Comunidad find(Object id);

	public List<Comunidad> findAll();

	public List<Comunidad> findRange(int[] range);

	public int count();



}
