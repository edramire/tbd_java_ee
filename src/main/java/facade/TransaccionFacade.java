package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;
@Local
public interface TransaccionFacade {

	public void create(Transaccion entity);

	public void edit(Transaccion entity);

	public void remove(Transaccion entity);

	public Transaccion find(Object id);

	public List<Transaccion> findAll();

	public List<Transaccion> findRange(int[] range);

	public int count();



}
