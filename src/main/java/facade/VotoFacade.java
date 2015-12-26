package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;
@Local
public interface VotoFacade {

	public void create(Voto entity);

	public void edit(Voto entity);

	public void remove(Voto entity);

	public Voto find(Object id);

	public List<Voto> findAll();

	public List<Voto> findRange(int[] range);

	public int count();


}
