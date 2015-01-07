package Dao;

import java.util.List;

import biblioteca.models.classes.Autor;

public interface DaoAutor {

	public void save(Autor autor);
	public Autor getAutor(long id);
	public List<Autor> list();
	public void remove(Autor autor);
	public void update(Autor autor);
}
