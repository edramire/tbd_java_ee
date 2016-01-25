package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;

import java.util.List;

public interface OfertaFacade {

	void create(Core entity);

	void edit(Core entity);

	void remove(Core entity);

	Core find(Object id);

	List<Core> findAll();

	List<Core> findRange(int[] range);

	int count();
	
	public List<Core> find_user(Integer id);

	List<Core> findAllplus();
}