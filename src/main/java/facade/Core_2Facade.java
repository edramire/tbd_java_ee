package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;
@Local
public interface Core_2Facade {

	public void create(Core_2 entity);

	public void edit(Core_2 entity);

	public void remove(Core_2 entity);

	public Core_2 find(Object id);

	public List<Core_2> findAll();

	public List<Core_2> findRange(int[] range);

	public int count();



}
