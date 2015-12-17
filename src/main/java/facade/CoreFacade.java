package facade;

import java.util.List;

import javax.ejb.Local;

import model.*;

import java.util.List;

import model.Usuario;

public interface CoreFacade {

	void create(Core entity);

	void edit(Core entity);

	void remove(Core entity);

	Core find(Object id);

	List<Core> findAll();

	List<Core> findRange(int[] range);

	int count();

}