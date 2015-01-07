package Dao;

import java.util.List;

import biblioteca.models.classes.Editora;

public interface DaoEditora {
	public void save(Editora editora);
	public Editora getEditora(long id);
	public List<Editora> list();
	public void remove(Editora editora);
	public void update(Editora editora);
}

