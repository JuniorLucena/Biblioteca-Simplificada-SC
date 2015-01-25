package Dao;

import java.util.List;

import biblioteca.models.classes.Livro;

public interface DaoLivros {
	 
	public void save(Livro livro);
	public Livro getLivro(long id);
	public List<Livro> list();
	public void remove(Livro livro);
	public void update(Livro livro);
	public Livro findByCodigo(String codigoBarra);
}
